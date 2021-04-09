package homework2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 手动向spring 容器注入bean
 *
 * @author jiangwentao
 * @date 2021/4/9
 */
public class BeanDefinitionRegister {

    @Autowired
    private BeanProperties beanProperties;

    public static void main(String[] args) {

        BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition();
        //设置属性值
        beanDefinitionBuilder.addPropertyValue("age", 24)
                .addPropertyValue("gender", "男")
                .addPropertyValue("name", "蒋文涛");
        AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
        //设置bean类型
        beanDefinition.setBeanClass(BeanProperties.class);

        //创建BeanFactory容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //注册当前类 ===>将当前类注入BeanFactory
        context.registerBeanDefinition("beanProperties", beanDefinition);
        context.register(BeanDefinitionRegister.class);
        //启动上下文
        context.refresh();

        BeanDefinitionRegister bean = context.getBean(BeanDefinitionRegister.class);
        System.out.println(bean.beanProperties);
        context.close();
    }
}
