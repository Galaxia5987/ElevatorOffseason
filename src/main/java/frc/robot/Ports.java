package frc.robot;

public class Ports {
    public static class Elevator{
        public static final boolean SENSOR_PHASE = false;
        public static final boolean MOTOR_INVERTED = false;

        public static final int TOP_LIMIT_SWITCH = 0;
        public static final int BOTTOM_LIMIT_SWITCH = 1;
        public static final int MOTOR = 31;
    }
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
}
