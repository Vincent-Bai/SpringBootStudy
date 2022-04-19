package com.bai.SpringBootStudy.SpringBootStudy.mapper;

import com.bai.SpringBootStudy.SpringBootStudy.module.User;

import java.util.List;

public interface UserMapper {
    //获取所有用户
    List<User> getAllUser();
}
