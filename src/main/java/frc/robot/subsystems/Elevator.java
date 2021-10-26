package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Ports;

public class Elevator extends SubsystemBase {
    public static TalonFX motor = new TalonFX(Constants.Elevator.MOTOR);
    public static UnitModel unitModel = new UnitModel(Constants.Elevator.UNIT_MODEL);
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
        motor.configForwardLimitSwitchSource(
                LimitSwitchSource.FeedbackConnector,
                Ports.Elevator.IS_SWITCHED ? LimitSwitchNormal.NormallyOpen : LimitSwitchNormal.NormallyClosed,
                Constants.TALON_TIMEOUT
        );
    }

    public double atTop() {
        return motor.getSensorCollection().isFwdLimitSwitchClosed() = ;
        if (LimitSwitchNormal.NormallyOpen == true){

        }

    }

    public double getPosition() {
        return unitModel.toUnits(motor.getSelectedSensorPosition());
    }

    public void setPosition(double position){
        motor.set(ControlMode.MotionMagic, unitModel.toTicks(position));
    }

}
