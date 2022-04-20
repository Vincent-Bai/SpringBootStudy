package com.bai.SpringBootStudy.SpringBootStudy.service;

import com.bai.SpringBootStudy.SpringBootStudy.module.User;

import java.util.List;

public interface UserService {
    //查询所有用户，mybatis
    List<User> getAllUser();

    //新增用户 mybatis-plus
    void insertUser(User user);


}
