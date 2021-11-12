package frc.robot.subsystems.elevator.Commands;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.subsystems.elevator.Elevator;

public class ManualClimb extends CommandBase {
    private final Elevator elevator;
    private final XboxController xboxController = RobotContainer.Xbox;

    public ManualClimb(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void execute() {
        elevator.setPower(deadband(-xboxController.getY(GenericHID.Hand.kLeft)));
    }

    /**
     * neglecting the joystick's drift if the drift is less than 0.1
     */
    private double deadband(double drift) {
        if (Math.abs(drift) < Constants.Elevator.JOYSTICK_DRIFT)
            return 0;
        return drift;
    }
}

