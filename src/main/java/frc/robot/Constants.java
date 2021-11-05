/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

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
    public static final class Elevator{
        public  static final int DIAMETER = 5;
        public static final int MAX_VELOCITY = 0;
        public static final int ACCELERATION = 0;
        public static final int F = 0;
        public static final int K = 0;
        public static final int POWER_UP = F+K;
        public static final int POWER_DOWN = F-K;
        public static final int MOTOR = 0;
        public static final int TICKS = 2048;
        public static final double CENTIMETER_PER_UNIT = DIAMETER*3.14;
        public static final int UNIT_MODEL = 0;
        public static final int TOP = 0;
        public static final int BOTTOM = 0;
        public static final double LS_POWER = 0.05;
    }
}
