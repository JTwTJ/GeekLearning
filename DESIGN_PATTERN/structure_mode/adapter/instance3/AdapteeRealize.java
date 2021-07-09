package structure_mode.adapter.instance3;

/**
 * @author jiangwentao
 * @date 2021/6/30
 * @detail
 */
public class AdapteeRealize implements TwoWayAdaptee {
    @Override
    public void adapteeRequst() {
        System.out.println("适配者代码被调用");
    }
}
