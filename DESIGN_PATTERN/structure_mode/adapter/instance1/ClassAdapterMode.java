package structure_mode.adapter.instance1;

/**
 * @author jiangwentao
 * @date 2021/6/30
 * @detail 类适配器模式
 */
public class ClassAdapterMode {

    static class ClassAdapter extends Adaptee implements Target {

        @Override
        public void request() {
            super.specificRequest();
        }
    }

    public static void main(String[] args) {
        System.out.println("类适配器模式测试：");
        Target target = new ClassAdapter();
        target.request();
    }
}
