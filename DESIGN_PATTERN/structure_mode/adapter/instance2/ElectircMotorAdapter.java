package structure_mode.adapter.instance2;

/**
 * @author jiangwentao
 * @date 2021/6/30
 * @detail 电力发动机适配器
 */
public class ElectircMotorAdapter implements Motor {

    private ElectricMotor electricMotor;

    public ElectircMotorAdapter(ElectricMotor electricMotor) {
        this.electricMotor = electricMotor;
    }

    @Override
    public void drive() {
        electricMotor.electricDrive();
    }
}
