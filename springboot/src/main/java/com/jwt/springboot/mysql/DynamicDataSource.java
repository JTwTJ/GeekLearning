package com.jwt.springboot.mysql;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author jiangwentao
 * @date 2021/4/19
 * @detail 动态数据源
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceType.getDataSourceType();
    }
}
