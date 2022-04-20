package com.bai.SpringBootStudy.SpringBootStudy.service;

import com.bai.SpringBootStudy.SpringBootStudy.mapper.UserMapper;
import com.bai.SpringBootStudy.SpringBootStudy.module.User;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author BaiYe
 * @since 2022-04-20
 */
public interface UserService extends IService<User> {

    Integer insertUser(User user);

    List<User>  getAllUser();
}
