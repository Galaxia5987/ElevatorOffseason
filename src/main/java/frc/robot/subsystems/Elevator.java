package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
<<<<<<< HEAD
import edu.wpi.first.wpilibj2.command.Command;
=======
>>>>>>> parent of 86ddd8e... Merge pull request #5 from Galaxia5987/Jonathan
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Ports;

public class Elevator extends SubsystemBase {
    private final WPI_TalonFX motor = new WPI_TalonFX(Ports.Elevator.MOTOR);
<<<<<<< HEAD
    private Elevator INSTANCE = null;
    private final UnitModel unitModel = new UnitModel(Constants.Elevator.TICKS_PER_METER);
    private Elevator(){
=======
    private final UnitModel unitModel = new UnitModel(Constants.Elevator.TICKS_PER_METER);
    private static Elevator INSTANCE = null;

    private Elevator() {
>>>>>>> parent of 86ddd8e... Merge pull request #5 from Galaxia5987/Jonathan
        motor.setInverted(Ports.Elevator.INVERT);
        motor.enableVoltageCompensation(Constants.Elevator.VOLT);
        motor.configVoltageCompSaturation(Constants.Elevator.SAT);
    }

<<<<<<< HEAD
    public Elevator setINSTANCE(){
        if (INSTANCE == null){
            INSTANCE= new Elevator();
=======
    public static Elevator getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Elevator();
>>>>>>> parent of 86ddd8e... Merge pull request #5 from Galaxia5987/Jonathan
        }
        return INSTANCE;
    }

    /**
<<<<<<< HEAD
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
=======
     * get power
     *
     * @return
     */
    public double getPower() {
        return motor.get();
    }

    /**
     * set power
     *
     * @param power
     */
    public void setPower(double power) {
        motor.set(power);
>>>>>>> parent of 86ddd8e... Merge pull request #5 from Galaxia5987/Jonathan
    }

    /**
     * deadband
<<<<<<< HEAD
     * @param value
     * @return
     */
    public double getDeadband(double value){
        if (Math.abs(value) < 0.05){
=======
     *
     * @param value
     * @return
     */
    public double getDeadband(double value) {
        if (Math.abs(value) < 0.05) {
>>>>>>> parent of 86ddd8e... Merge pull request #5 from Galaxia5987/Jonathan
            value = 0;
        }
        return value;
    }

<<<<<<< HEAD
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
=======
    public double getPosition() {
        return unitModel.toUnits(motor.getSelectedSensorPosition());
    }

    /**
     * set position to pos
     *
     * @param pos
     */
    public void setPosition(double pos) {
        motor.set(ControlMode.Position, unitModel.toTicks(pos));
    }
>>>>>>> parent of 86ddd8e... Merge pull request #5 from Galaxia5987/Jonathan

}