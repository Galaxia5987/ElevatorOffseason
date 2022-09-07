package frc.robot;

import com.ctre.phoenix.motorcontrol.TalonFXInvertType;

public class Ports {
    public static class Gripper {
        public static final int LEFTMOTOR = 0;
        public static final int RIGHTMOTOR = 0;
        public static final int SOLENOID = 0;

        public static final boolean RIGHT_MOTOR_INVERTED = false;
        public static final boolean LEFT_MOTOR_INVERTED = false;
    }

    public static class Controller {
        public static final int XBOX_CONTROLLER = 0;
    }

    public static class Elevator {
        public static final int MOTOR = 1;
        public static final TalonFXInvertType INVERT = TalonFXInvertType.Clockwise;
    }
}
