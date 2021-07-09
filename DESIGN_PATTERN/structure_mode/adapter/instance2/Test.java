package structure_mode.adapter.instance2;

/**
 * @author jiangwentao
 * @date 2021/6/30
 * @detail
 */
public class Test {

    public static void main(String[] args) {
        Motor electircMotor = new ElectircMotorAdapter(new ElectricMotor());
        electircMotor.drive();
        Motor opticalMotor = new OpticalMotorAdapter(new OpticalMotor());
        opticalMotor.drive();
    }
}
