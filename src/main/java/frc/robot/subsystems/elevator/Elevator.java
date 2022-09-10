package frc.robot.subsystems.elevator;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Ports;
import frc.robot.subsystems.UnitModel;

import javax.sound.sampled.Port;

public class Elevator extends SubsystemBase {
    private final WPI_TalonFX motor = new WPI_TalonFX(Ports.Elevator.motor);
    private final UnitModel unitModel = new UnitModel(Constants.Elevator.TICKS_PER_METER);
    private static Elevator INSTANCE = null;
    private Elevator(){
        motor.setInverted(TalonFXInvertType.Clockwise);
        motor.config_kP(0, Constants.Elevator.kP);
        motor.config_kI(0, Constants.Elevator.kI);
        motor.config_kD(0, Constants.Elevator.kD);
        motor.config_kF(0, Constants.Elevator.kF);

    }
    public static Elevator getInstance(){
        if (INSTANCE == null){
            INSTANCE = new Elevator();

        }
        return INSTANCE;
    }

    public double getheight(){
        return unitModel.toUnits(motor.getSensorCollection().getIntegratedSensorPosition());
    }
    public void setHeight(double height){
        motor.set(ControlMode.Position,unitModel.toTicks(height));
    }

    public void stop(){
        motor.set(0);
    }
}
