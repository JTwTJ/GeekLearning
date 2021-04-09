package homework2;

import org.springframework.beans.factory.serviceloader.ServiceLoaderFactoryBean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author jiangwentao
 * @date 2021/4/9
 */
@Configuration
public class BeanServiceLoaderFactoryBean extends ServiceLoaderFactoryBean {

    @PostConstruct
    public void setServiceType() {
        super.setServiceType(DefaultBeanFactory.class);
    }
}
