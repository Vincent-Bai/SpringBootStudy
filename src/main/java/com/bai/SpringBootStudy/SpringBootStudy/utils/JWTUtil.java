package com.bai.SpringBootStudy.SpringBootStudy.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.bai.SpringBootStudy.SpringBootStudy.common.exception.BizException;
import com.bai.SpringBootStudy.SpringBootStudy.module.User;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;

@Component
public class JWTUtil {

    /**
     * 签发对象：这个用户的id
     * 签发时间：现在
     * 有效时间：120分钟
     * 载荷内容：暂时设计为：这个人的名字
     * 加密密钥：这个人的id加上一串字符串
     */
    public static String createToken(User user) {
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE, 120);
        Date expiresDate = nowTime.getTime();

        return JWT.create().withAudience(user.getName())
                .withIssuedAt(new Date())
                .withExpiresAt(expiresDate)
                .withClaim("realName", user.getName())
                .sign(Algorithm.HMAC256(user.getName() + "Vincent"));
    }

    /**
     * 检验合法性，其中secret参数就应该传入的是用户的id
     */
    public static void verifyToken(String token, String sercet) throws BizException {
        DecodedJWT jwt = null;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(sercet + "Vincent")).build();
            jwt = verifier.verify(token);
        } catch (Exception e) {
            e.printStackTrace();
            throw new BizException();
        }
    }

    /**
     * 获取签发对象
     */
    public static String getAudience(String token) throws BizException {
        String audience = null;
        try {
            audience = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException e) {
            e.printStackTrace();
            throw new BizException();
        }
        return audience;
    }

    /**
     * 通过载荷名字获取载荷的值
     */
    public static Claim getClaimByName(String token, String name) {
        return JWT.decode(token).getClaim(name);
    }

}
