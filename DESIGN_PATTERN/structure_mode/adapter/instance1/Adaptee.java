package structure_mode.adapter.instance1;

/**
 * @author jiangwentao
 * @date 2021/6/30
 * @detail 适配者接口
 */
public class Adaptee {

    public void specificRequest() {
        System.out.println("适配者中业务代码被调用！");
    }
}
