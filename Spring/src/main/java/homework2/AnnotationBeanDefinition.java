package homework2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Import;

/**
 * 注解装配bean
 *
 * @author jiangwentao
 * @date 2021/4/9
 */
@Import(BeanConfiguration.class)
public class AnnotationBeanDefinition {

    @Qualifier("bean1")
    @Autowired
    private BeanProperties beanProperties;

    public static void main(String[] args) {
        //创建BeanFactory容器
        ApplicationContext context = new AnnotationConfigApplicationContext();
        //注册配置类 ===>将当前类注入BeanFactory
        ((AnnotationConfigApplicationContext) context).register(AnnotationBeanDefinition.class);
        //启动上下文
        ((AnnotationConfigApplicationContext) context).refresh();
        //依赖查找
        BeanProperties bean = (BeanProperties) context.getBean("bean2");
        System.out.println(bean);
        ((AnnotationConfigApplicationContext) context).close();
        AnnotationBeanDefinition annotationBeanDefinition = new AnnotationBeanDefinition();
        annotationBeanDefinition.test();
    }

    public void test() {
        System.out.println(beanProperties);
    }
}
