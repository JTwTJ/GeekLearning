package com.jwt.springboot.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author jiangwentao
 * @date 2021/4/15
 * @detail activemq 消费者主题监听器
 */
@Component
public class TopicConsumerListener {

    //topic模式的消费者
    @JmsListener(destination = "${spring.activemq.topic-name}", containerFactory = "topicListener")
    public void readActiveQueue(String message) {
        System.out.println("========>>>>topic接受到：" + message);
    }
}
