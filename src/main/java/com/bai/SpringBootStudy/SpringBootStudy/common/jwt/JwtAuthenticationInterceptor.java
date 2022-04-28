package com.bai.SpringBootStudy.SpringBootStudy.common.jwt;

import com.bai.SpringBootStudy.SpringBootStudy.common.enums.ResultCode;
import com.bai.SpringBootStudy.SpringBootStudy.common.exception.BizException;
import com.bai.SpringBootStudy.SpringBootStudy.module.User;
import com.bai.SpringBootStudy.SpringBootStudy.service.UserService;
import com.bai.SpringBootStudy.SpringBootStudy.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * JWT 拦截器
 */
public class JwtAuthenticationInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object object) throws Exception {
        // 从请求头中取出 token  这里需要和前端约定好把jwt放到请求头一个叫token的地方
        String token = httpServletRequest.getHeader("token");
        // 如果不是映射到方法直接通过
        if (!(object instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) object;
        Method method = handlerMethod.getMethod();
        //检查是否有passtoken注释，有则跳过认证
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }
        //默认全部检查
        else {
            System.out.println("被jwt拦截需要验证");
            // 执行认证
            if (null == token) {
                //这里其实是登录失效,没token了
                throw new BizException(ResultCode.UNAUTHORIZED);
            }

            // 获取 token 中的 user Name
            String userName = JWTUtil.getAudience(token);

            //找找看是否有这个user   因为我们需要检查用户是否存在，读者可以自行修改逻辑
            User user = userService.getUserForName(userName);

            if (null==user) {
                //这个错误也是我自定义的
                throw new BizException(ResultCode.USER_NOT_EXIST_ERROR);
            }

            // 验证 token
            JWTUtil.verifyToken(token, userName);

            //获取载荷内容
            String realName = JWTUtil.getClaimByName(token, "realName").asString();

            return true;

        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest,
                           HttpServletResponse httpServletResponse,
                           Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest,
                                HttpServletResponse httpServletResponse,
                                Object o, Exception e) throws Exception {
    }

}
