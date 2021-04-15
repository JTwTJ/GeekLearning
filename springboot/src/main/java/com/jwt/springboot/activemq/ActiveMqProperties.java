package com.jwt.springboot.activemq;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author jiangwentao
 * @date 2021/4/15
 * @detail activemq 配置属性
 */
@ConfigurationProperties(prefix = "spring.activemq")
@Data
public class ActiveMqProperties {

    private String brokerUrl;

    private String user;

    private String password;

    private String queueName;

    private String topicName;
}
