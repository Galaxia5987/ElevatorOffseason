package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Ports;

public class Elevator extends SubsystemBase {
    private final WPI_TalonFX motor = new WPI_TalonFX(Ports.Elevator.MOTOR);
    private Elevator INSTANCE = null;
    private final UnitModel unitModel = new UnitModel(Constants.Elevator.TICKS_PER_METER);
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

    /**
     * set power
     * @param power
     */
    public void setPower(double power){
        motor.set(power);
    }

    /**
     * get power
     * @return
     */
    public double getPower(){
        return motor.get();
    }

    /**
     * deadband
     * @param value
     * @return
     */
    public double getDeadband(double value){
        if (Math.abs(value) < 0.05){
            value = 0;
        }
        return value;
    }

    /**
     * set position to pos
     * @param pos
     */
    public void setPosition(double pos){
        motor.set(ControlMode.Position, unitModel.toTicks(pos));
    }
    public double getPosition(){
        return unitModel.toUnits(motor.getSelectedSensorPosition());
    }

}