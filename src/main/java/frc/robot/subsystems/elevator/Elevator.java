package frc.robot.subsystems.elevator;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Ports;
import frc.robot.subsystems.UnitModel;

public class Elevator extends SubsystemBase {

    public static TalonFX motor = new TalonFX(Ports.Elevator.MOTOR);
    public static UnitModel unitModel = new UnitModel(Constants.Elevator.TICKS_PER_METER);
    public static DigitalInput topLimitSwitch = new DigitalInput(Ports.Elevator.TOP_LIMIT_SWITCH);
    public static DigitalInput bottomLimitSwitch = new DigitalInput(Ports.Elevator.BOTTOM_LIMIT_SWITCH);
    private static final Elevator INSTANCE = new Elevator();

    /**
     * Add PID.
     */
    public Elevator() {
        motor.setSelectedSensorPosition(0);
        motor.setSensorPhase(Ports.Elevator.SENSOR_PHASE);
        motor.setInverted(Ports.Elevator.MOTOR_INVERTED);
        motor.config_kP(0, Ports.Elevator.PID_P);
        motor.config_kI(0, Ports.Elevator.PID_I);
        motor.config_kD(0, Ports.Elevator.PID_D);
        motor.config_kF(0, Ports.Elevator.PID_F);

        motor.configMotionAcceleration(unitModel.toTicks100ms(Constants.Elevator.ACCELERATION));
        motor.configMotionCruiseVelocity(unitModel.toTicks100ms(Constants.Elevator.MAX_VELOCITY));
    }

    /**
     * Create object.
     * @return
     */
    public static Elevator getInstance() {
        return INSTANCE;
    }

    /**
     * get top limit switch.
     * @return top limit switch.
     */
    public boolean atTop() {
        return topLimitSwitch.get();
    }

    /**
     * get bottom limit switch.
     * @return bottom limit switch.
     */
    public boolean atBottom() {
        return bottomLimitSwitch.get();
    }

    /**
     * get position.
     */

    public double getPosition() {
        return unitModel.toUnits(motor.getSelectedSensorPosition());
    }

    /**
     * set position in ticks.
     */
    public void setPosition(double position) {
        System.out.println("ticks: " + unitModel.toTicks(position));
        motor.set(ControlMode.MotionMagic, unitModel.toTicks(position));
    }

    /**
     * set power.
     * @param power [%]
     */
    public void setPower(double power) {
        motor.set(ControlMode.PercentOutput, power);
    }


}

