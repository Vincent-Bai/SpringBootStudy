package com.bai.SpringBootStudy.SpringBootStudy.service.impl;

import com.bai.SpringBootStudy.SpringBootStudy.module.Student;
import com.bai.SpringBootStudy.SpringBootStudy.mapper.StudentMapper;
import com.bai.SpringBootStudy.SpringBootStudy.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author BaiYe
 * @since 2022-04-20
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
