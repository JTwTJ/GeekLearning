package Temp;

/**
 * @author jiangwentao
 * @date 2021/8/5
 * @detail
 */
public class Singleton {

    private volatile static Singleton singleton;

    private Singleton newInstance() {

        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = newInstance();
                }
            }
        }
        return singleton;
    }
}
