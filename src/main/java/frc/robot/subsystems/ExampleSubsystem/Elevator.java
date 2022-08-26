package frc.robot.subsystems.ExampleSubsystem;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Ports;
import frc.robot.subsystems.UnitModel;

public class Elevator extends SubsystemBase {
    private final WPI_TalonFX motor=new WPI_TalonFX(Ports.MOTOR);
    private static Elevator INSTANCE=null;
    public static final UnitModel unitModel  = new UnitModel(Constants.TICKS_PER_METER);

    public Elevator(){
        motor.enableVoltageCompensation(Constants.ENABLE_VOLT_COMP);
        motor.configVoltageCompSaturation(Constants.CONFIG_VOLT);
        motor.configMotionAcceleration(Constants.MOTION_ACCELERATION);
        motor.configMotionCruiseVelocity(Constants.CRUISE_VELOCITY);
        motor.setInverted(Ports.INVERTED);
        motor.setNeutralMode(NeutralMode.Brake);


    }

    public Elevator getInstance(){
        if(INSTANCE==null){
            INSTANCE = new Elevator();
        }
        return INSTANCE;
    }

    public double getPower(){
        return motor.get();
    }

    public void setPower(double Power){
        motor.set(Power);
    }

    public void setVelocity(double velocity){
        motor.set(ControlMode.Velocity, unitModel.toTicks100ms(velocity));
    }

    public double getVelocity(){
         return unitModel.toVelocity(motor.getSelectedSensorVelocity());
    }

    
}
