package frc.robot.subsystems.gripper;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import static frc.robot.Ports.Gripper.*;

public class Gripper extends SubsystemBase {
    private final VictorSPX motor = new VictorSPX(MOTOR);
    private final Solenoid solenoid = new Solenoid(SOLENOID);

    private final static Gripper INSTANCE = new Gripper();

    public static Gripper getInstance() {
        return INSTANCE;
    }

    /**
     * Check if motor inverted
     */
    private Gripper() {
        motor.setInverted(MOTOR_INVERTED);
    }

    /**
     * Set power
     * @param power power to give to the motor
     */
    public void setPower(double power) {
        motor.set(ControlMode.PercentOutput, power);
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
