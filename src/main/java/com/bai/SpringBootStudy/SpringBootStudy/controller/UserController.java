package com.bai.SpringBootStudy.SpringBootStudy.controller;

import com.bai.SpringBootStudy.SpringBootStudy.common.Result;
import com.bai.SpringBootStudy.SpringBootStudy.common.enums.ResultCode;
import com.bai.SpringBootStudy.SpringBootStudy.module.User;
import com.bai.SpringBootStudy.SpringBootStudy.service.UserService;
import com.google.common.base.Strings;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    @ApiOperation("新增用户")
    @PostMapping("/insert")
    public Result insertUser(/*@Valid*/ User user /*, BindingResult bindingResult*/) {
       /* if (bindingResult.hasErrors()) {
            return bindingResult.getAllErrors().get(0).getDefaultMessage();
        }*/

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



}
