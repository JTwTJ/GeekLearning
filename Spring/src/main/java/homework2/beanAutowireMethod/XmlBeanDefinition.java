package homework2.beanAutowireMethod;

import homework2.BeanProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * xml实现Spring bean装配
 *
 * @author jiangwentao
 * @date 2021/4/9
 */
public class XmlBeanDefinition {

    public static void main(String[] args) {

        //找到装配bean的xml文件
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:bean-definition.xml");
        //启动上下文
        ((ClassPathXmlApplicationContext) context).refresh();
        BeanProperties bean = context.getBean(BeanProperties.class);
        System.out.println(bean);
        ((ClassPathXmlApplicationContext) context).close();
    }
}
