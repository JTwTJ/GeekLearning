package com.jwt.springboot.activemq;

import lombok.extern.slf4j.Slf4j;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;

/**
 * @author jiangwentao
 * @date 2021/4/15
 * @detail activemq生产者发消息到queue、topic
 */
@RequestMapping("/activemq")
@RestController
@Slf4j
public class ProducerController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private ActiveMQQueue activeMQQueue;

    @Autowired
    private ActiveMQTopic activeMQTopic;

    /**
     * 发送消息到队列
     *
     * @param message 消息
     * @return 成功消息
     */
    @PostMapping("/queue")
    public String sendQueue(@RequestBody String message) {
        sendMessage(activeMQQueue, message);
        return "send to queue success";
    }

    /**
     * 发送消息到 topic
     *
     * @param message 消息
     * @return 成功消息
     */
    @PostMapping("/topic")
    public String sendTopic(@RequestBody String message) {
        sendMessage(activeMQTopic, message);
        return "send to topic success";
    }

    /**
     * 发送消息
     *
     * @param destination 发送到
     * @param message     消息
     */
    private void sendMessage(Destination destination, String message) {
        jmsMessagingTemplate.convertAndSend(destination, message);
    }
}
