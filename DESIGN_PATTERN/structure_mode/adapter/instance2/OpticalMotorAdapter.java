package structure_mode.adapter.instance2;

/**
 * @author jiangwentao
 * @date 2021/6/30
 * @detail 光力发动机适配器
 */
public class OpticalMotorAdapter implements Motor {

    private OpticalMotor opticalMotor;

    public OpticalMotorAdapter(OpticalMotor opticalMotor) {
        this.opticalMotor = opticalMotor;
    }

    @Override
    public void drive() {
        opticalMotor.opticalDrive();
    }
}
