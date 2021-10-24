package frc.robot.subsystems.elevator;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.UnitModel;

import static frc.robot.Constants.Elevator.*;
import static frc.robot.Port.Elevator.motorPort;

public class Elevator extends SubsystemBase {
    private TalonFX motor = new TalonFX(motorPort);
    private UnitModel unitModel = new UnitModel();

    public Elevator() {

        motor.setInverted(IS_MOTOR_INVERTED);
        motor.setSensorPhase(SENSORPHASE);

        motor.config_kP(0, KP);
        motor.config_kI(0, KI);
        motor.config_kD(0, KD);
        motor.config_kF(0, KF);

        motor.configMotionCruiseVelocity(unitModel.toTicks100ms(MAX_VELOCITY));
        motor.configMotionAcceleration(unitModel.toTicks100ms(ACCELERATION));
    }

    public double getPosition() {
        return unitModel.toUnits(motor.getSelectedSensorPosition());
    }
    public double setPosition(){
        motor.set(ControlMode.MotionMagic, 8000);
    }
}