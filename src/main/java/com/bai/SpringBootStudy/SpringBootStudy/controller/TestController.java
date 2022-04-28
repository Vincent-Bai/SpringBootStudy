package com.bai.SpringBootStudy.SpringBootStudy.controller;

import com.bai.SpringBootStudy.SpringBootStudy.common.Result;
import com.bai.SpringBootStudy.SpringBootStudy.common.enums.ResultCode;
import com.bai.SpringBootStudy.SpringBootStudy.module.User;
import com.bai.SpringBootStudy.SpringBootStudy.service.UserService;
import com.google.common.collect.Maps;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Api("测试类")
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserService userService;

    @GetMapping("hello")
    public String hello() {
        return "Hello World";
    }

    @ApiOperation("getFirstUserName")
    @GetMapping("getFirstUserName")
    public String getFirstUserName(){
        List<User> users = new ArrayList<>();
        return users.get(3).getName();
    }

    @ApiOperation("getLong")
    @GetMapping("getLong")
    public User getLong(){
       long id=10/0;
        return userService.getById(id);
    }

    @ApiOperation("insert")
    @PostMapping("insert")
    public void addUser(@Valid @RequestBody User user){

    }


}
