package structure_mode.adapter.instance3;

/**
 * @author jiangwentao
 * @date 2021/6/30
 * @detail 双向适配器
 */
public class TwoWayAdapter implements TwoWayTarget, TwoWayAdaptee {

    private TwoWayTarget target;
    private TwoWayAdaptee adaptee;

    public TwoWayAdapter(TwoWayTarget target) {
        this.target = target;
    }

    public TwoWayAdapter(TwoWayAdaptee adaptee) {
        this.adaptee = adaptee;
    }

    @Override
    public void adapteeRequst() {
        target.targetRequest();
    }

    @Override
    public void targetRequest() {
        adaptee.adapteeRequst();
    }
}
