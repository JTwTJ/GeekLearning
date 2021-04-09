package homework2;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jiangwentao
 * @date 2021/4/9
 */
@Configuration
public class SelfFactoryBean implements FactoryBean<BeanProperties> {


    @Override
    public BeanProperties getObject() {

        BeanProperties bean = new BeanProperties();
        bean.setName("蒋文涛");
        bean.setAge(24);
        bean.setGender("男");
        return bean;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
