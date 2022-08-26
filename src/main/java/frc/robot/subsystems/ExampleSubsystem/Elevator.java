package frc.robot.subsystems.ExampleSubsystem;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Ports;
import frc.robot.subsystems.UnitModel;

public class Elevator extends SubsystemBase {
    private final WPI_TalonFX motor=new WPI_TalonFX(Ports.MOTOR);
    private static final Elevator INSTANCE=null;
    public static final UnitModel unitModel  = new UnitModel(Constants.TICKS_PER_METER);

    public Elevator(){
        motor.enableVoltageCompensation(Constants.ENABLE_VOLT_COMP);
        motor.configVoltageCompSaturation(Constants.CONFIG_VOLT);
        motor.configMotionAcceleration(Constants.MOTION_ACCELERATION);
        motor.configMotionCruiseVelocity(Constants.CRUISE_VELOCITY);

    }
}
