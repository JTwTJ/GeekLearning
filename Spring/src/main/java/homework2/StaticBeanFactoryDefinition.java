package homework2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 静态工厂向spring容器注入bean
 *
 * @author jiangwentao
 * @date 2021/4/9
 */
public class StaticBeanFactoryDefinition {

    public static void main(String[] args) {
        //创建BeanFactory容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //注册当前类 ===>将当前类注入BeanFactory
        context.register(StaticBeanFactory.class);
        //启动上下文
        context.refresh();
        BeanProperties bean = StaticBeanFactory.createBean();
        System.out.println(bean);
        context.close();
    }
}
