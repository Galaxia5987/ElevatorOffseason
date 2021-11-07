/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpiutil.math.Matrix;
import edu.wpi.first.wpiutil.math.Nat;
import edu.wpi.first.wpiutil.math.VecBuilder;
import edu.wpi.first.wpiutil.math.Vector;
import edu.wpi.first.wpiutil.math.numbers.N1;
import edu.wpi.first.wpiutil.math.numbers.N2;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final int TALON_TIMEOUT = 10; // The timeout of talon. [ms]
    public static final double LOOP_PERIOD = 0.02; // [s]

    public static class Elevator {
        public static final boolean INVERTED = false; // Whether the motor is inverted.
        public static final double kP = 0.2; // Proportional constant.
        public static final double kI = 0; // Integral constant.
        public static final double kD = 0.02; // Derivative constant.
        public static final double kF = 0.4; // Takes into account the force that gravity applies (feed forward).
        public static final double MAX_HEIGHT = 1.8; // Maximum height of the elevator. [m]
        public static final double DRUM_RADIUS = 0.03; // Radius of the elevator drum. [m]
        public static final double SLOW_MOVEMENT = MAX_HEIGHT / 5; // Makes the elevator finish moving at 5s. [m/s]
        public static final double TICKS_PER_METER = 2 * Math.PI * DRUM_RADIUS / 4096; // [tick]
        public static final int ACCELERATION = 2; // The acceleration for the trapezoid control mode. [m/s^2]
        public static final int MAX_VELOCITY = 1; // The cruise velocity. [m/s]
        public static final double G = 1 / 10.0;
        public static final double radius = 0; // [m]
        public static final double mass = 0; // [kg]

        public static final Matrix<N2, N1> MODEL_TOLERANCE = Matrix.mat(Nat.N2(), Nat.N1()).fill(
                0.0508,
                1.016
        );
        public static final Matrix<N1, N1> SENSOR_TOLERANCE = Matrix.mat(Nat.N1(), Nat.N1()).fill(
                0.001
        );

        public static final Vector<N2> qelms = VecBuilder.fill(
                0.0254,
                0.254
        );
        public static final Vector<N1> relms = VecBuilder.fill(
                0.3048
        );
    }

    public static class Falcon {
        public static final double nominalVoltage = 12; // [volt]
        public static final double stallTorque = 4.69; // [N*m]
        public static final double stallCurrent = 257; // [amps]
        public static final double freeCurrent = 1.5; // [amps]
        public static final double freeSpeed = 6380 * Math.PI * 2 / 60.0; // [rad/s]

        public static final double R = nominalVoltage / stallCurrent; // [ohms]
        public static final double Kv = freeSpeed / (nominalVoltage - R * freeCurrent); // [rad/s*volt]
        public static final double Kt = stallTorque / stallCurrent; // [N*m/amps]
    }
}
