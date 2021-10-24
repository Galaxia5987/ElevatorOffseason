package frc.robot.subsystems.Elevator;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import frc.robot.subsystems.UnitModel;
import org.w3c.dom.ls.LSOutput;

import static frc.robot.Constants.Elevator.*;
import static frc.robot.Ports.Elevator.*;

public class Elevator {
    private UnitModel unitMan = new UnitModel(TICKS_PER_METER);
    private TalonFX motor = new TalonFX(eleMotor);

    public Elevator() {
        motor.setSelectedSensorPosition(sensorPos);
        motor.setInverted(inverted);
        motor.configMotionAcceleration(ACCELERATION);
        motor.configMotionCruiseVelocity(MAX_VELOCITY);

        motor.config_kP(pidSlot, kP);
        motor.config_kI(pidSlot, kI);
        motor.config_kD(pidSlot, kD);
        motor.config_kF(pidSlot, kF);
    }

    public double getPosition(){
        return motor.getSelectedSensorPosition();
    }

    public void setPosition(double position){
        motor.set(ControlMode.MotionMagic, position, DemandType.ArbitraryFeedForward, kF);
    }

}
