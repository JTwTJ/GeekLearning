package com.jwt.springboot.mysql;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author jiangwentao
 * @date 2021/4/19
 * @detail 多数据源-ds2
 */
@ConfigurationProperties(prefix = "spring.datasource.ds2")
@Component("ds2Properties")
@Data
public class Ds2Properties {

    private String jdbcUrl;

    private String username;

    private String password;

    private String driverClassName;
}
