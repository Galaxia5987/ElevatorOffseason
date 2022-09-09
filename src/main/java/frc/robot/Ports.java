package frc.robot;

import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

public class Ports {


    public static class Controller {
        public static final int XBOX_CONTROLLER = 0;
    }
    public static class Elevator{
        public static final int MOTOR = 1;
        public static final TalonFXInvertType INVERT = TalonFXInvertType.Clockwise;
    }
}
