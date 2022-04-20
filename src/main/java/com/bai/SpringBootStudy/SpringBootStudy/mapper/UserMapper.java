package com.bai.SpringBootStudy.SpringBootStudy.mapper;

import com.bai.SpringBootStudy.SpringBootStudy.module.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    //获取所有用户
    List<User> getAllUser();
}
