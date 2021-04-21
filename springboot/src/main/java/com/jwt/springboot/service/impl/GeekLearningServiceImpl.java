package com.jwt.springboot.service.impl;

import com.jwt.springboot.mapper.CustomerMapper;
import com.jwt.springboot.service.GeekLearningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author jiangwentao
 * @date 2021/4/19
 * @detail
 */
@Service
public class GeekLearningServiceImpl implements GeekLearningService {

    @Autowired
    private CustomerMapper userMapper;

    @Override
    public Integer checkDynamicDataSource() {
        return userMapper.selectRecordsCount();
    }
}
