package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Ports;

public class Elevator extends SubsystemBase {
    private final WPI_TalonFX motor = new WPI_TalonFX(Ports.Elevator.MOTOR);
    private Elevator INSTANCE = null;

    private Elevator(){
        motor.setInverted(Ports.Elevator.INVERT);
        motor.enableVoltageCompensation(Constants.Elevator.VOLT);
        motor.configVoltageCompSaturation(Constants.Elevator.SAT);
    }

    public Elevator setINSTANCE(){
        if (INSTANCE == null){
            INSTANCE= new Elevator();
        }
        return INSTANCE;
    }
    public void setPower(double power){
        motor.set(power);
    }
    public double getPower(){
        return motor.get();
    }
    public double getDeadband(double value){
        if (Math.abs(value) < 0.05){
            value = 0;
        }
        return value;
    }

}