package com.jwt.springboot.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.jms.core.JmsMessagingTemplate;

/**
 * @author jiangwentao
 * @date 2021/4/15
 * @detail activemq 配置类
 */
@Configuration
@EnableConfigurationProperties(ActiveMqProperties.class)
public class ActiveMqConfiguration {

    @Autowired
    private ActiveMqProperties activeMqProperties;

    @Bean(name = "queue")
    public ActiveMQQueue queue() {
        return new ActiveMQQueue(activeMqProperties.getQueueName());
    }

    @Bean(name = "topic")
    public ActiveMQTopic topic() {
        return new ActiveMQTopic(activeMqProperties.getTopicName());
    }

    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        return new ActiveMQConnectionFactory(activeMqProperties.getUser(),
                activeMqProperties.getPassword(), activeMqProperties.getBrokerUrl());
    }

    @Bean
    public JmsMessagingTemplate jmsMessagingTemplate() {
        return new JmsMessagingTemplate(connectionFactory());
    }

    /**
     * 在Queue模式中，对消息的监听需要对containerFactory进行配置
     */
    @Bean("queueListener")
    public JmsListenerContainerFactory<?> queueJmsListenerContainerFactory(ActiveMQConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        //整合springboot默认使用queue，设置为false表示不使用topic
        factory.setPubSubDomain(false);
        return factory;
    }

    /**
     * 在Topic模式中，对消息的监听需要对containerFactory进行配置
     */
    @Bean("topicListener")
    public JmsListenerContainerFactory<?> topicJmsListenerContainerFactory(ActiveMQConnectionFactory connectionFactory) {
        SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        //设置为true表示topic
        factory.setPubSubDomain(true);
        return factory;
    }

}
