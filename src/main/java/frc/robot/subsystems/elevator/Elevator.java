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
    public static TalonFX motor = new TalonFX(Constants.Elevator.MOTOR);
    public static UnitModel unitModel = new UnitModel(Constants.Elevator.UNIT_MODEL);
    public static DigitalInput topLimitSwitch = new DigitalInput(Ports.Elevator.TOP_LIMIT_SWITCH);
    public static DigitalInput bottomLimitSwitch = new DigitalInput(Ports.Elevator.BOTTOM_LIMIT_SWITCH);
    public static Joystick joystick = new Joystick(Ports.Elevator.JOYSTICK);
    private static final Elevator INSTANCE = new Elevator();
    public static Elevator getInstance(){
        return INSTANCE;
    }

    public Elevator() { motor.setSelectedSensorPosition(0);
        motor.setSensorPhase(Ports.Elevator.SENSOR_PHASE);
        motor.setInverted(Ports.Elevator.MOTOR_INVERTED);
        motor.config_kP(0, Ports.Elevator.PID_P);
        motor.config_kI(0, Ports.Elevator.PID_I);
        motor.config_kD(0, Ports.Elevator.PID_D);
        motor.config_kF(0, Ports.Elevator.PID_F);
    }

    public boolean atTop() {
       return topLimitSwitch.get();
    }

    public boolean atBottom() {
        return bottomLimitSwitch.get();
    }

    public double getPosition() {
        return unitModel.toUnits(motor.getSelectedSensorPosition());
    }

    public void setPosition(double position){
        motor.set(ControlMode.MotionMagic, unitModel.toTicks(position));
    }
    }

