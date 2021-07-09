package structure_mode.adapter.instance1;

/**
 * @author jiangwentao
 * @date 2021/6/30
 * @detail 对象适配器模式
 */
public class ObjAdapterMode {

    static class ObjAdapter implements Target {

        private Adaptee adaptee;

        public ObjAdapter(Adaptee adaptee) {
            this.adaptee = adaptee;
        }

        @Override
        public void request() {
            adaptee.specificRequest();
        }
    }

    public static void main(String[] args) {
        System.out.println("对象适配器模式测试：");
        Adaptee adaptee = new Adaptee();
        Target target = new ObjAdapter(adaptee);
        target.request();
    }
}
