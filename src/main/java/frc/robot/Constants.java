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
    public static class Elevator{
        public static final boolean inverted = false;
        public static final double kP = 0.2;
        public static final double kI = 0;
        public static final double kD = 0.02;
        public static final double kF = 0;
        public static final int ACCELERATION = 0;
        public static final int MAX_VELOCITY = 0;
        public static final double MAX_HEIGHT = 0; // maximum height of the elevator [ticks]
        public static final double DRUM_RADIUS = 0;
        public static final double TICKS_PER_METER = 2 * Math.PI * DRUM_RADIUS / 4096;
    }
}
