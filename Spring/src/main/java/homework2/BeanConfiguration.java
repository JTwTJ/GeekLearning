package homework2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 注解实现装配bean
 *
 * @author jiangwentao
 * @date 2021/4/9
 */
@Configuration//@Configuration相当于xml里面的<beans>标签
public class BeanConfiguration {

    @Bean("bean1")//@Bean相当于xml里面的<bean>标签
    public BeanProperties beanProperties1() {
        BeanProperties bean = new BeanProperties();
        bean.setAge(24);
        bean.setGender("男");
        bean.setName("蒋文涛");
        return bean;
    }

    @Bean("bean2")//@Bean相当于xml里面的<bean>标签
    public BeanProperties beanProperties2() {
        BeanProperties bean = new BeanProperties();
        bean.setAge(32);
        bean.setGender("女");
        bean.setName("德莱厄斯");
        return bean;
    }
}
