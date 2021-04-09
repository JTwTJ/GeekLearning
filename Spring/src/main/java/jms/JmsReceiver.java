package jms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * jms activemq 接收消息
 */
public class JmsReceiver {
    
    public static void main( String[] args ) throws IOException {

        //从xml中读取配置
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:springjms-receiver.xml");
        
        System.in.read();
        
        System.out.println("send successfully, please visit http://localhost:8162/admin to see it");
    }
    
}
