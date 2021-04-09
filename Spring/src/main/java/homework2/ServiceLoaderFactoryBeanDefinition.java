package homework2;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * 利用JDK里面的反向控制 向spring容器注入bean
 *
 * @author jiangwentao
 * @date 2021/4/9
 */
public class ServiceLoaderFactoryBeanDefinition {

    public static void main(String[] args) {
        // 创建 BeanFactory 容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //注册当前类
        context.register(BeanServiceLoaderFactoryBean.class);
        //启动应用上下文
        context.refresh();

        AutowireCapableBeanFactory autowireCapableBeanFactory = context.getAutowireCapableBeanFactory();
        ServiceLoader<DefaultBeanFactory> bean = autowireCapableBeanFactory.getBean(ServiceLoader.class);

        Iterator<DefaultBeanFactory> iterator = bean.iterator();
        while (iterator.hasNext()) {
            DefaultBeanFactory next = iterator.next();
            System.out.println(next.createBean());
        }
        context.close();
    }
}
