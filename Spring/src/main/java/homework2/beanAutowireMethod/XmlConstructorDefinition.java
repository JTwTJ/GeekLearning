package homework2.beanAutowireMethod;

import homework2.BeanProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * xml 构造器注入装配bean
 *
 * @author jiangwentao
 * @date 2021/4/9
 */
public class XmlConstructorDefinition {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:xml-constructor-definition.xml");
        ((ClassPathXmlApplicationContext) context).refresh();
        BeanProperties bean = context.getBean(BeanProperties.class);
        System.out.println(bean);
        ((ClassPathXmlApplicationContext) context).close();
    }
}
