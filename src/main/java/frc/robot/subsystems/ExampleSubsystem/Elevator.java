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

    /**
     * creates an instance if there isn't one
     * @return
     */
    public Elevator getInstance(){
        if(INSTANCE==null){
            INSTANCE = new Elevator();
        }
        return INSTANCE;
    }

    /**
     * gets the power of the elevator
     * @return
     */
    public double getPower(){
        return motor.get();
    }

    /**
     * sets the power of the elevator
     * @param Power
     */
    public void setPower(double Power){
        motor.set(Power);
    }

    /**
     * sets the velocity of the elevator
     * @param velocity
     */
    public void setVelocity(double velocity){
        motor.set(ControlMode.Velocity, unitModel.toTicks100ms(velocity));
    }

    /**
     * gets the velocity of the elevator
     * @return
     */
    public double getVelocity(){
         return unitModel.toVelocity(motor.getSelectedSensorVelocity());
    }

    /**
     * checks if the joystick is in the defined dead zone and stops the elevator from moving if it's in the dead zone
     * @param value
     * @return
     */
    public double DeadZone(double value){
        if(value>=Constants.DEAD_BEND||value<=Constants.DEAD_BEND){
            return 0;
        }
        else{
            return value;
        }
    }

    /**
     * sets the position of the elevator
     * @param height
     */
    public void setPosition(double height){
        motor.set(ControlMode.Position, unitModel.toTicks(height));
    }

    /**
     * ges the position of the elevator
     * @return
     */
    public double getPosition(){
        return unitModel.toUnits(motor.getSelectedSensorPosition());
    }

    /**
     * checks if the elevator reached the desired position
     * @param currentHeight
     * @param desiredHeight
     * @return
     */
    public boolean heightCheck(double currentHeight, double desiredHeight){
        if (currentHeight>=desiredHeight-3&&currentHeight<=desiredHeight+3){
            return true;
        }
        else{
            return false;
        }
    }
}
