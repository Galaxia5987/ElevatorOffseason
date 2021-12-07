package frc.robot.subsystems.elevator;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Ports;
import frc.robot.subsystems.UnitModel;
import webapp.FireLog;

public class Elevator extends SubsystemBase {

    private static TalonFX motor = new TalonFX(Ports.Elevator.MOTOR);
    private static UnitModel unitModel = new UnitModel(Constants.Elevator.TICKS_PER_METER);
    private static DigitalInput topLimitSwitch = new DigitalInput(Ports.Elevator.TOP_LIMIT_SWITCH);
    private static DigitalInput bottomLimitSwitch = new DigitalInput(Ports.Elevator.BOTTOM_LIMIT_SWITCH);
    private static final Elevator INSTANCE = new Elevator();

    /**
     * Add PID.
     */
    private Elevator() {
        motor.setSelectedSensorPosition(0);
        motor.setSensorPhase(Ports.Elevator.SENSOR_PHASE);
        motor.setInverted(Ports.Elevator.MOTOR_INVERTED);
        motor.config_kP(0, Constants.Elevator.PID_P.get());
        motor.config_kI(0, Constants.Elevator.PID_I.get());
        motor.config_kD(0, Constants.Elevator.PID_D.get());
        motor.config_kF(0, Constants.Elevator.PID_F.get());

        motor.configMotionAcceleration(unitModel.toTicks100ms(Constants.Elevator.ACCELERATION));
        motor.configMotionCruiseVelocity(unitModel.toTicks100ms(Constants.Elevator.MAX_VELOCITY));

        motor.enableVoltageCompensation(true);
        motor.configVoltageCompSaturation(Constants.NOMINAL_VOLTAGE);
    }
    public void resetElevator(){
        motor.setSelectedSensorPosition(0);
    }

    /**
     * Create object.
     *
     * @return the elevator instance
     */
    public static Elevator getInstance() {
        return INSTANCE;
    }

    /**
     * get top limit switch.
     *
     * @return top limit switch.
     */
    public boolean atTop() {
        return topLimitSwitch.get();
    }

    /**
     * get bottom limit switch.
     *
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
     *
     * @param power [%]
     */
    public void setPower(double power) {
        motor.set(ControlMode.PercentOutput, power);
    }

    @Override
    public void periodic() {
        FireLog.log("elevator-position", getPosition());
        FireLog.log("elevator-motorVoltage", motor.getMotorOutputVoltage());

        motor.config_kP(0, Constants.Elevator.PID_P.get());
        motor.config_kI(0, Constants.Elevator.PID_I.get());
        motor.config_kD(0, Constants.Elevator.PID_D.get());
        motor.config_kF(0, Constants.Elevator.PID_F.get());


    }
}