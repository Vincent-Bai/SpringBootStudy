package com.bai.SpringBootStudy.SpringBootStudy.controller;

import com.bai.SpringBootStudy.SpringBootStudy.common.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("测试类")
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("hello")
    public String hello(){
        return "Hello World";
    }

    @ApiOperation("t1")
    @GetMapping("t1")
    public Result t1(){
        return Result.success();
    }
}
