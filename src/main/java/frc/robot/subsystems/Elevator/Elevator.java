package frc.robot.subsystems.Elevator;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.controller.LinearQuadraticRegulator;
import edu.wpi.first.wpilibj.estimator.KalmanFilter;
import edu.wpi.first.wpilibj.system.LinearSystem;
import edu.wpi.first.wpilibj.system.LinearSystemLoop;
import edu.wpi.first.wpiutil.math.Matrix;
import edu.wpi.first.wpiutil.math.Nat;
import edu.wpi.first.wpiutil.math.numbers.N1;
import edu.wpi.first.wpiutil.math.numbers.N2;
import frc.robot.subsystems.UnitModel;

import static frc.robot.Constants.Elevator.*;
import static frc.robot.Constants.Falcon.*;
import static frc.robot.Constants.LOOP_PERIOD;
import static frc.robot.Ports.Elevator.*;

public class Elevator {
    public static final TalonFX motor = new TalonFX(ELE_MOTOR);
    private static final Elevator INSTANCE = new Elevator();
    private final UnitModel unitMan = new UnitModel(TICKS_PER_METER);
    DigitalInput limitSwitchTop = new DigitalInput(DIGITAL_INPUT);
    DigitalInput limitSwitchBottom = new DigitalInput(DIGITAL_INPUT);
    private Matrix<N2, N2> A;
    private Matrix<N2, N1> B;
    private Matrix<N1, N2> C;
    private Matrix<N1, N1> D;
    private KalmanFilter<N2, N1, N1> kalmanFilter;
    private LinearSystem<N2, N1, N1> elevator;
    private LinearQuadraticRegulator<N2, N1, N1> lqr;
    private LinearSystemLoop<N2, N1, N1> linearSystemLoop;

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

        A = Matrix.mat(Nat.N2(), Nat.N2()).fill(
                0,
                0,
                1,
                -(sqr(G) * Kt) / (R * sqr(radius) * mass * Kv)
        );

        B = Matrix.mat(Nat.N2(), Nat.N1()).fill(
                0,
                G * Kt / (R * radius * mass)
        );

        C = Matrix.mat(Nat.N1(), Nat.N2()).fill(
                1,
                0
        );

        D = Matrix.mat(Nat.N1(), Nat.N1()).fill(
                0
        );

        elevator = new LinearSystem<>(
            A,
            B,
            C,
            D
        );

        kalmanFilter = new KalmanFilter<>(
            Nat.N2(),
            Nat.N1(),
            elevator,
            MODEL_TOLERANCE,
            SENSOR_TOLERANCE,
            LOOP_PERIOD
        );

        lqr = new LinearQuadraticRegulator<>(
                elevator,
                qelms,
                relms,
                LOOP_PERIOD
        );

        linearSystemLoop = new LinearSystemLoop<>(
                elevator,
                lqr,
                kalmanFilter,
                nominalVoltage,
                LOOP_PERIOD
        );
    }

    public static Elevator getInstance() {
        return INSTANCE;
    }

    public double sqr(double d) {
        return Math.pow(d, 2);
    }

    public boolean atBottom() {
        return limitSwitchBottom.get();
    }

    public boolean atTop() {
        return limitSwitchTop.get();
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
//        motor.set(ControlMode.MotionMagic, unitMan.toTicks(position), DemandType.ArbitraryFeedForward, kF);
    }

    public void setPower(double position) {
        linearSystemLoop.getU();
    }

    public void setVelocity(double velocity) {
        motor.set(ControlMode.Velocity, unitMan.toTicks100ms(velocity));
    }

    public void terminate() {
        motor.set(ControlMode.PercentOutput, 0);
    }

}
