package com.jwt.springboot.mysql;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author jiangwentao
 * @date 2021/4/19
 * @detail 多数据源-ds1
 */
@ConfigurationProperties(prefix = "spring.datasource.ds1")
@Component("ds1Properties")
@Data
public class Ds1Properties {

    private String jdbcUrl;

    private String username;

    private String password;

    private String diverClassName;
}
