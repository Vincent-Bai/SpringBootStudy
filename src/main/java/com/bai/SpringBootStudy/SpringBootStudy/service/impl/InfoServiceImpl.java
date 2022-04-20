package com.bai.SpringBootStudy.SpringBootStudy.service.impl;

import com.bai.SpringBootStudy.SpringBootStudy.module.Info;
import com.bai.SpringBootStudy.SpringBootStudy.mapper.InfoMapper;
import com.bai.SpringBootStudy.SpringBootStudy.service.InfoService;
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
public class InfoServiceImpl extends ServiceImpl<InfoMapper, Info> implements InfoService {

}
