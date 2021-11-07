package frc.robot.subsystems.elevator.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.elevator.Elevator;

/**
 * Add parameters elevator&height.
 */
public class Height extends CommandBase {
    private final Elevator elevator;
    private final double height;

    public Height(Elevator elevator, double height) {
        this.elevator = elevator;
        this.height = height;
        addRequirements(elevator);
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        elevator.setPosition(height);
    }

    @Override
    public void end(boolean interrupted) {
        elevator.setPower(0);
    }

    @Override
    public boolean isFinished() {
        return Math.abs(height - elevator.getPosition()) < Constants.Elevator.HEIGHT;
    }
}
