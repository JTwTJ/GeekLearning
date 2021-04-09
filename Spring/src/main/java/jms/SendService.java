package jms;

import com.alibaba.fastjson.JSON;
import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

//注解注入bean
@Component
public class SendService {
    @Autowired
    JmsTemplate jmsTemplate;
    
    public void send(final Student user) {
        jmsTemplate.send("test.queue", new MessageCreator() {
            
            public Message createMessage(Session session) throws JMSException {
                return session.createObjectMessage(JSON.toJSONString(user));
            }
        });
    }
}