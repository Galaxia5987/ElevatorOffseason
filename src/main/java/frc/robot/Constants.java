/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.util.Units;
import frc.robot.utils.CommonSwerveConfig;
import frc.robot.utils.SwerveModuleConfig;
import frc.robot.utils.SwerveModuleConfigBase;
import frc.robot.valuetuner.WebConstant;

import static frc.robot.Ports.SwerveDrive.*;

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
    public static final double LOOP_PERIOD = 0.02; // [s]
    public static final boolean ENABLE_VOLTAGE_COMPENSATION = true;
    public static final boolean ENABLE_CURRENT_LIMIT = true;

    public enum Motor {
        TalonFX(12, 4.69, 257, 1.6, Units.rotationsPerMinuteToRadiansPerSecond(6380.0)),
        TalonSRX(12, 0.7, 130, 3.8, Units.rotationsPerMinuteToRadiansPerSecond(21020.0)),
        NEO(12, 2.6, 105, 1.8, Units.rotationsPerMinuteToRadiansPerSecond(5657.0)),
        NEO500(12, 0.97, 100, 1.4, Units.rotationsPerMinuteToRadiansPerSecond(1100));

        public final double nominalVoltage; // [volts]
        public final double stallTorque; // [N * m]
        public final double stallCurrent; // [amps]
        public final double freeCurrent; // [amps]
        public final double freeSpeed; // [rad/sec]
        public final double omega; // [ohms]
        public final double Kv; // [rad/(sec*Volt)]
        public final double Kt; // [n * m/ amps]

        Motor(double nominalVoltageVolts, double stallTorqueNewtonMeters, double stallCurrentAmps, double freeCurrentAmps, double freeSpeedRadPerSec) {
            this.nominalVoltage = nominalVoltageVolts;
            this.stallTorque = stallTorqueNewtonMeters;
            this.stallCurrent = stallCurrentAmps;
            this.freeCurrent = freeCurrentAmps;
            this.freeSpeed = freeSpeedRadPerSec;
            this.omega = nominalVoltageVolts / stallCurrentAmps;
            this.Kv = freeSpeedRadPerSec / (nominalVoltageVolts - omega * freeCurrentAmps);
            this.Kt = stallTorqueNewtonMeters / stallCurrentAmps;
        }
    }

    public static final class SwerveDrive {
        public static final int TICKS_PER_ROTATION_DRIVE_MOTOR = 2048;
        public static final int TICKS_PER_ROTATION_ANGLE_MOTOR = 1024;
        public static final double GEAR_RATIO_DRIVE_MOTOR = 7.5;
        public static final double GEAR_RATIO_ANGLE_MOTOR = 1;

        public static final int MAX_CURRENT = 15; // [amps]

        // State Space
        public static final double VELOCITY_TOLERANCE = 20; // [rps]
        public static final double MODEL_TOLERANCE = 4;
        public static final double ENCODER_TOLERANCE = 4; // [ticks]

        public static final double ALLOWABLE_ANGLE_ERROR = Math.toRadians(8); // [rad]
        public static final double WHEEL_RADIUS = 0.04688; // [m]

        public static final double KP_TURN = 0.05;
        public static final double KI_TURN = 0.02;
        public static final double KD_TURN = 0;

        public static final CommonSwerveConfig commonConfig = new CommonSwerveConfig.Builder()
                .configTicksPerUnit(GEAR_RATIO_DRIVE_MOTOR * TICKS_PER_ROTATION_DRIVE_MOTOR / (4 * 0.0254 * Math.PI),
                        GEAR_RATIO_ANGLE_MOTOR * TICKS_PER_ROTATION_ANGLE_MOTOR / (2 * Math.PI))
                .configConstraints(MAX_CURRENT, VELOCITY_TOLERANCE, MODEL_TOLERANCE, ENCODER_TOLERANCE)
                .configWheelRadius(WHEEL_RADIUS)
                .configDriveMotorGearRatio(GEAR_RATIO_DRIVE_MOTOR)
                .build();

        public static final double ROBOT_LENGTH = 0.5924; // [m]
        public static final double ROBOT_WIDTH = 0.5924; // [m]
        public static final double JOYSTICK_THRESHOLD = 0.1;
        public static final double VELOCITY_MULTIPLIER = 3 * 3.5; // 4 / Math.sqrt(2)

        // the rotational speed of the robot, this constant multiplies the rotation output of the joystick
        public static final double ROTATION_MULTIPLIER = Math.PI * 3.5;
        public static final double OUTER_JOYSTICK_THRESHOLD = 0.95;
        public static final double JOYSTICK_ANGLE_DEADZONE = 5; // [degrees]
    }

    public static final class SwerveModule {
        public static final int[] ZERO_POSITIONS = {1017, 496, 1327, 921}; // fr, fl, rr, rl
        public static final int TRIGGER_THRESHOLD_CURRENT = 2; // [amps]
        public static final double TRIGGER_THRESHOLD_TIME = 0.02; // [secs]
        public static final double RAMP_RATE = 2; // seconds from neutral to max

        private static final double magicSafety = 0.7;
        public static final SwerveModuleConfigBase frConfig = new SwerveModuleConfig.Builder(0)
                .configCommonConfig(SwerveDrive.commonConfig)
                .configPorts(DRIVE_MOTOR_FR, ANGLE_MOTOR_FR)
                .configInversions(DRIVE_INVERTED_FR, ANGLE_INVERTED_FR, DRIVE_SENSOR_PHASE_FR, ANGLE_SENSOR_PHASE_FR)
                .configAnglePID(4.5, 0.0045, 1, 0)
                .configZeroPosition(ZERO_POSITIONS[0])
                .configJ(0.03165)
                .configMotionMagic((int) (2800 * magicSafety), (int) (550 * magicSafety), 4)
                .build();
        public static final SwerveModuleConfigBase flConfig = new SwerveModuleConfig.Builder(1)
                .configCommonConfig(SwerveDrive.commonConfig)
                .configPorts(DRIVE_MOTOR_FL, ANGLE_MOTOR_FL)
                .configInversions(DRIVE_INVERTED_FL, ANGLE_INVERTED_FL, DRIVE_SENSOR_PHASE_FL, ANGLE_SENSOR_PHASE_FL)
                .configAnglePID(13, 0.0045, 0, 0)
                .configZeroPosition(ZERO_POSITIONS[1])
                .configJ(0.0322)
                .configMotionMagic((int) (2800 * magicSafety), (int) (550 * magicSafety), 4)
                .build();
        public static final SwerveModuleConfigBase rrConfig = new SwerveModuleConfig.Builder(2)
                .configCommonConfig(SwerveDrive.commonConfig)
                .configPorts(DRIVE_MOTOR_RR, ANGLE_MOTOR_RR)
                .configInversions(DRIVE_INVERTED_RR, ANGLE_INVERTED_RR, DRIVE_SENSOR_PHASE_RR, ANGLE_SENSOR_PHASE_RR)
                .configAnglePID(8, 0.004, 0, 0)
                .configZeroPosition(ZERO_POSITIONS[2])
                .configJ(0.03185)
                .configMotionMagic((int) (2800 * magicSafety), (int) (550 * magicSafety), 4)
                .build();
        public static final SwerveModuleConfigBase rlConfig = new SwerveModuleConfig.Builder(3)
                .configCommonConfig(SwerveDrive.commonConfig)
                .configPorts(DRIVE_MOTOR_RL, ANGLE_MOTOR_RL)
                .configInversions(DRIVE_INVERTED_RL, ANGLE_INVERTED_RL, DRIVE_SENSOR_PHASE_RL, ANGLE_SENSOR_PHASE_RL)
                .configAnglePID(10, 0.004, 0, 0)
                .configZeroPosition(ZERO_POSITIONS[3])
                .configJ(0.03165)
                .configMotionMagic((int) (2800 * magicSafety), (int) (550 * magicSafety), 4)
                .build();
    }
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
        public static final double MAX_HEIGHT = 1.38;
        public static final double MIN_HEIGHT = 0.0;
        public static final double HALF_METER_HEIGHT = 0.5;
        public static final double METER_HEIGHT = 1.0;


        public static final WebConstant PID_P = new WebConstant("k_p", 0.5);
        public static final WebConstant PID_I = new WebConstant("k_i", 0);
        public static final WebConstant PID_D = new WebConstant("k_d", 0);
        public static final WebConstant PID_F = new WebConstant("k_f", 0);
        public static final double JOYSTICK_DRIFT = 0.05;
    }

    public static final class Gripper {
    }

}
