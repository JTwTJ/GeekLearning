package homework1;

import java.lang.reflect.Proxy;

/**
 * Java动态代理实现AOP demo
 *
 * @author jiangwentao
 * @date 2021/4/9
 */
public class ProxySimpleAopTest {

    public static void main(String[] args) {

        //要代理的真实对象
        ProxyService proxyService = new ProxyServiceImpl();
        //代理对象的调用处理程序，我们将要代理的真实对象传入代理对象的调用处理的构造函数中，最终代理对象的调用处理程序会调用真实对象的方法
        ProxyHandler handler = new ProxyHandler(proxyService);
        /**
         * 通过Proxy类的newProxyInstance方法创建代理对象，我们来看下方法中的参数
         * 第一个参数：proxyService.getClass().getClassLoader()，使用handler对象的classloader对象来加载我们的代理对象
         * 第二个参数：proxyService.getClass().getInterfaces()，这里为代理类提供的接口是真实对象实现的接口，这样代理对象就能像真实对象一样调用接口中的所有方法
         * 第三个参数：handler，我们将代理对象关联到上面的InvocationHandler对象上
         */
        ProxyService proxy = (ProxyService) Proxy.newProxyInstance(proxyService.getClass().getClassLoader(),
                proxyService.getClass().getInterfaces(), handler);
        proxy.eat();
        proxy.run();
        System.out.println(proxy.getClass());//此proxy生成的是JDK动态代理的代理类 com.sun.proxy.$Proxy0
        System.out.println(proxyService);//此proxy是实例化的类
    }
}
