package homework2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 静态bean工厂
 *
 * @author jiangwentao
 * @date 2021/4/9
 */
@Configuration
public class StaticBeanFactory {

    @Bean
    public static BeanProperties createBean() {
        BeanProperties bean = new BeanProperties();
        bean.setGender("男");
        bean.setAge(24);
        bean.setName("蒋文涛");
        return bean;
    }
}
