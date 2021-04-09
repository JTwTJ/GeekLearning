package jms;

import model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * jms activemq 发送消息demo   docker pull activemq 映射端口
 */
public class JmsSender {
    
    public static void main( String[] args )
    {
        Student student2 = new Student(201, "KK0201", null, null, null);
        
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:springjms-sender.xml");
        
        SendService sendService = (SendService)context.getBean("sendService");
        
        sendService.send(student2);
        
        System.out.println("send successfully, please visit http://localhost:8162/admin to see it");
    }
    
}
