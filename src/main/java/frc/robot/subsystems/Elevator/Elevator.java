package frc.robot.subsystems.Elevator;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import frc.robot.subsystems.UnitModel;

import static frc.robot.Constants.Elevator.*;
import static frc.robot.Ports.Elevator.*;

public class Elevator {
    private UnitModel unitMan = new UnitModel(TICKS_PER_METER);
    private TalonFX motor = new TalonFX(ELE_MOTOR);

    public Elevator() {
        motor.setSelectedSensorPosition(SENSOR_POS);
        motor.setInverted(INVERTED);
        motor.configMotionAcceleration(ACCELERATION);
        motor.configMotionCruiseVelocity(MAX_VELOCITY);

        motor.config_kP(PID_X, kP);
        motor.config_kI(PID_X, kI);
        motor.config_kD(PID_X, kD);
        motor.config_kF(PID_X, kF);
    }

    public double getPosition(){
        return motor.getSelectedSensorPosition();
    }

    public void setPosition(double position){
        motor.set(ControlMode.MotionMagic, position, DemandType.ArbitraryFeedForward, kF);
    }

}
