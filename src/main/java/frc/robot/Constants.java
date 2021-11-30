/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import frc.robot.valuetuner.WebConstant;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public static final int TALON_TIMEOUT = 10;
    public static final double NOMINAL_VOLTAGE = 12;

    public static final class Elevator {
        public static final double DIAMETER = 0.06; // [m]
        public static final double MAX_VELOCITY = 3; // [m/s]
        public static final double ACCELERATION = 1; // [m/s^2]
        public static final int F = 0;
        public static final int K = 0;
        public static final int POWER_UP = F + K;
        public static final int POWER_DOWN = F - K;
        public static final int TICKS = 2048;
        public static final double GEAR_RATIO = 1.0 / 10;
        public static final double TICKS_PER_METER = TICKS / (DIAMETER * Math.PI * GEAR_RATIO);
        public static final int UNIT_MODEL = 0;
        public static final int TOP = 0;
        public static final int BOTTOM = 0;
        public static final double LS_POWER = 0.05;
        public static final double HEIGHT = 0.05; //[m]

        public static final WebConstant PID_P = new WebConstant("k_p", 0.5);
        public static final WebConstant PID_I = new WebConstant("k_i", 0);
        public static final WebConstant PID_D = new WebConstant("k_d", 0);
        public static final WebConstant PID_F = new WebConstant("k_f", 0);
        public static final double JOYSTICK_DRIFT = 0.05;
    }
}
