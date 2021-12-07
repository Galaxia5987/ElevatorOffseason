package frc.robot.subsystems.gripper;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Ports;

import static frc.robot.Ports.Gripper.*;

public class Gripper extends SubsystemBase {
    private final VictorSPX motorRight = new VictorSPX(RIGHTMOTOR);
    private final VictorSPX motorLeft = new VictorSPX(LEFTMOTOR);
    private final Solenoid solenoid = new Solenoid(SOLENOID);

    private final static Gripper INSTANCE = new Gripper();

    public static Gripper getInstance() {
        return INSTANCE;
    }

    /**
     * Check if motor inverted
     */
    private Gripper() {
        motorRight.setInverted(RIGHT_MOTOR_INVERTED);
        motorLeft.setInverted(LEFT_MOTOR_INVERTED);
    }

    /**
     * Set power
     *
     * @param power power to give to the motor
     */
    public void setPower(double power) {
        motorRight.set(ControlMode.PercentOutput, power);
        motorLeft.follow(motorRight);
    }


    /**
     * Close solenoid
     */
    public void close() {
        solenoid.set(false);
    }

    /**
     * Open solenoid
     */
    public void open() {
        solenoid.set(true);
    }
}
