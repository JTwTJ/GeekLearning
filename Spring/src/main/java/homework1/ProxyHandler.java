package homework1;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 实现 InvocationHandler接口的代理处理类---aop切面处理
 *
 * @author jiangwentao
 * @date 2021/4/9
 */
@Data
@AllArgsConstructor
public class ProxyHandler implements InvocationHandler {

    /**
     * 代理类中的真实对象
     */
    private Object obj;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invoke = method.invoke(obj, args);//注意这里用obj不用proxy，proxy是代理对象，obj是真实对象
        after();
        return invoke;
    }

    private void before() {
        System.out.println("吃饭之前先洗手=======>>>");
    }

    private void after() {
        System.out.println("吃完饭后要洗碗=======>>>");
    }


}
