package homework2;

/**
 * @author jiangwentao
 * @date 2021/4/9
 */
public interface DefaultBeanFactory {

    default BeanProperties createBean() {
        BeanProperties bean = new BeanProperties();
        bean.setName("蒋文涛");
        bean.setAge(24);
        bean.setGender("男");
        return bean;
    }
}
