package homework1;

import org.springframework.stereotype.Component;

/**
 * @author jiangwentao
 * @date 2021/4/9
 */
@Component
public class ProxyServiceImpl implements ProxyService {


    @Override
    public void eat() {
        System.out.println("start eat rice======>>>");
    }

    @Override
    public void run() {
        System.out.println("start run======>>>");
    }
}
