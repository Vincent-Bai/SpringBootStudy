package com.bai.SpringBootStudy.SpringBootStudy.controller;

import com.bai.SpringBootStudy.SpringBootStudy.common.Result;
import com.bai.SpringBootStudy.SpringBootStudy.common.enums.ResultCode;
import com.bai.SpringBootStudy.SpringBootStudy.common.exception.BizException;
import com.bai.SpringBootStudy.SpringBootStudy.common.jwt.PassToken;
import com.bai.SpringBootStudy.SpringBootStudy.module.User;
import com.bai.SpringBootStudy.SpringBootStudy.service.UserService;
import com.bai.SpringBootStudy.SpringBootStudy.utils.JWTUtil;
import com.bai.SpringBootStudy.SpringBootStudy.utils.RedisUtil;
import com.google.common.base.Strings;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author BaiYe
 * @since 2022-04-20
 */
@Api("用户管理")
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @Resource
    private RedisUtil redisUtil;

    @ApiOperation("新增用户")
    @PostMapping("/insert")
    public Result insertUser(@Valid @RequestBody User user) {

        if (Strings.isNullOrEmpty(user.getName())) {
            return Result.faild(ResultCode.PARAMETER_EXCEPTION);
        }
        return Result.success();
    }

    @ApiOperation("按照id查询用户信息")
    @GetMapping("/getOne")
    public Result getUserById(Integer id) {
        return Result.success();
    }

    @ApiOperation("按姓名查询用户")
    @GetMapping("getUserForName")
    public User getUserForName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new BizException(ResultCode.PARAMETER_EXCEPTION);
        }
        User user = userService.getUserForName(name);
        if (null == user) {
            throw new BizException(ResultCode.USER_NOT_EXIST_ERROR);
        }
        return user;
    }

    @PassToken
    @ApiOperation("登录")
    @GetMapping("login")
    public String login(String name) {
        if (StringUtils.isBlank(name)) {
            throw new BizException(ResultCode.PARAMETER_EXCEPTION);
        }
        User user = userService.getUserForName(name);
        if (null == user) {
            throw new BizException(ResultCode.USER_NOT_EXIST_ERROR);
        }

        String token = JWTUtil.createToken(user);
        //token存入redis中
        redisUtil.set(name, token, 7200);
        return token;
    }


}
