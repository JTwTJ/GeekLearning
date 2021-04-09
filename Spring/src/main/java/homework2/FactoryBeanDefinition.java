package homework2;

import lombok.SneakyThrows;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * bean工厂向spring容器注入bean
 *
 * @author jiangwentao
 * @date 2021/4/9
 */
public class FactoryBeanDefinition {

    @SneakyThrows
    public static void main(String[] args) {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //===>将当前类注入BeanFactory
        context.register(SelfFactoryBean.class);
        context.refresh();
        SelfFactoryBean beanFactory = context.getBean(SelfFactoryBean.class);
        BeanProperties bean = beanFactory.getObject();
        System.out.println(bean);
        context.close();
    }
}
