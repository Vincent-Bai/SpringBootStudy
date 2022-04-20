package com.bai.SpringBootStudy.SpringBootStudy.service.impl;

import com.bai.SpringBootStudy.SpringBootStudy.module.User;
import com.bai.SpringBootStudy.SpringBootStudy.mapper.UserMapper;
import com.bai.SpringBootStudy.SpringBootStudy.service.UserService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author BaiYe
 * @since 2022-04-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Override
    public Integer insertUser(User user) {
        int count = userMapper.insert(user);
        return count;
    }

    @Override
    public List<User> getAllUser() {
        QueryWrapper queryWrapper = new QueryWrapper();
        List<User> users = userMapper.selectList(queryWrapper);
        return users;
    }
}
