package com.jwt.springboot.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author jiangwentao
 * @date 2021/4/15
 * @detail activemq 消费者队列监听器
 */
@Component
public class QueueConsumerListener {

    //queue模式的消费者
    @JmsListener(destination = "${spring.activemq.queue-name}", containerFactory = "queueListener")
    public void readActiveQueue(String message) {
        System.out.println("========>>>>queue接收到：" + message);
    }
}
