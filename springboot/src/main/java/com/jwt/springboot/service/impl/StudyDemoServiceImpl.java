package com.jwt.springboot.service.impl;

import com.jwt.springboot.mapper.GoodsMapper;
import com.jwt.springboot.service.StudyDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jiangwentao
 * @date 2021/4/19
 * @detail
 */
@Service
public class StudyDemoServiceImpl implements StudyDemoService {

    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public Integer checkDynamicDataSource() {
        return goodsMapper.selectRecordsCount();
    }
}
