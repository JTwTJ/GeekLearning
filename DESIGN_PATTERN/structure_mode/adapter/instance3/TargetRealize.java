package structure_mode.adapter.instance3;

/**
 * @author jiangwentao
 * @date 2021/6/30
 * @detail 目标实现
 */
public class TargetRealize implements TwoWayTarget {
    @Override
    public void targetRequest() {
        System.out.println("目标代码被调用！");
    }
}
