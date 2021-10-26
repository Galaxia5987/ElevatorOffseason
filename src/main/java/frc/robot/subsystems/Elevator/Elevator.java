package frc.robot.subsystems.Elevator;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.LimitSwitchNormal;
import com.ctre.phoenix.motorcontrol.LimitSwitchSource;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import frc.robot.subsystems.UnitModel;

import static frc.robot.Constants.Elevator.*;
import static frc.robot.Constants.TALON_TIMEOUT;
import static frc.robot.Ports.Elevator.*;

public class Elevator {
    private static final Elevator INSTANCE = new Elevator();
    public static final TalonFX motor = new TalonFX(ELE_MOTOR);
    private final UnitModel unitMan = new UnitModel(TICKS_PER_METER);
    private LimitSwitchNormal limitSwitchTop;

    /**
     * Configure the elevator motor.
     */
    private Elevator() {
        motor.setSensorPhase(SENSOR_PHASE);
        motor.setSelectedSensorPosition(SENSOR_POS);
        motor.setInverted(INVERTED);

        motor.configMotionAcceleration(unitMan.toTicks100ms(ACCELERATION));
        motor.configMotionCruiseVelocity(unitMan.toTicks100ms(MAX_VELOCITY));

        motor.config_kP(PID_X, kP);
        motor.config_kI(PID_X, kI);
        motor.config_kD(PID_X, kD);

        motor.configForwardLimitSwitchSource(
                LimitSwitchSource.FeedbackConnector,
                LimitSwitchNormal.NormallyOpen,
                TALON_TIMEOUT
        );

        motor.configReverseLimitSwitchSource(
                LimitSwitchSource.FeedbackConnector,
                LimitSwitchNormal.NormallyOpen,
                TALON_TIMEOUT
        );
    }

    public boolean atBottom(){
        return motor.getSensorCollection().isRevLimitSwitchClosed()
                == LimitSwitchNormal.NormallyClosed.value;
    }

    public boolean atTop() {
        return motor.getSensorCollection().isFwdLimitSwitchClosed()
                == LimitSwitchNormal.NormallyClosed.value;
    }

    public static Elevator getInstance() {
        return INSTANCE;
    }

    /**
     * Gets the position of the motor (used for debugging).
     *
     * @return the position of the motor. [m]
     */
    public double getPosition() {
        return unitMan.toUnits(motor.getSelectedSensorPosition());
    }

    /**
     * Set the position the motor needs to move using motion magic.
     *
     * @param position is the position of the elevator. [m]
     */
    public void setPosition(double position) {
        motor.set(ControlMode.MotionMagic, unitMan.toTicks(position), DemandType.ArbitraryFeedForward, kF);
    }

    public void setVelocity(double velocity){
        motor.set(ControlMode.Velocity, unitMan.toTicks100ms(velocity));
    }

    public void terminate() {
        motor.set(ControlMode.PercentOutput, 0);
    }

}
