package com.bai.SpringBootStudy.SpringBootStudy.service.impl;

import com.bai.SpringBootStudy.SpringBootStudy.module.Emp;
import com.bai.SpringBootStudy.SpringBootStudy.mapper.EmpMapper;
import com.bai.SpringBootStudy.SpringBootStudy.service.EmpService;
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
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements EmpService {

}
