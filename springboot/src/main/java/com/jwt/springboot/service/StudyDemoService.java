package com.jwt.springboot.service;

import org.springframework.stereotype.Service;

/**
 * @author jiangwentao
 * @date 2021/4/19
 * @detail
 */
@Service
public interface StudyDemoService {

    /**
     * 动态切换数据源测试
     */
    Integer checkDynamicDataSource();
}
