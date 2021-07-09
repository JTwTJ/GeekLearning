package structure_mode.adapter.instance3;

/**
 * @author jiangwentao
 * @date 2021/6/30
 * @detail
 */
public class Test {

    public static void main(String[] args) {
        System.out.println("目标通过双向适配器访问适配器");
        TwoWayAdaptee adaptee = new AdapteeRealize();
        TwoWayTarget target = new TwoWayAdapter(adaptee);
        target.targetRequest();
        System.out.println("-----------------");
        System.out.println("适配器通过双向适配器访问目标");
        target = new TargetRealize();
        adaptee = new TwoWayAdapter(target);
        adaptee.adapteeRequst();
    }
}
