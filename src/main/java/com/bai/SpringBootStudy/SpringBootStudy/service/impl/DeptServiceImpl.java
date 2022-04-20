package com.bai.SpringBootStudy.SpringBootStudy.service.impl;

import com.bai.SpringBootStudy.SpringBootStudy.module.Dept;
import com.bai.SpringBootStudy.SpringBootStudy.mapper.DeptMapper;
import com.bai.SpringBootStudy.SpringBootStudy.service.DeptService;
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
public class DeptServiceImpl extends ServiceImpl<DeptMapper, Dept> implements DeptService {

}
