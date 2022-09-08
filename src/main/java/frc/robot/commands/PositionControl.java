package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ExampleSubsystem.Elevator;

public class PositionControl extends CommandBase {
    private final Elevator elevator;
    private final double height;

    public PositionControl(Elevator elevator, double height) {
        this.elevator = elevator;
        this.height = height;
        addRequirements(elevator);
    }

    /**
     * sets the position of the elevator
     */
    @Override
    public void execute() {
        elevator.setPosition(height);
    }

    /**
     * stops the elevator
     *
     * @param interrupted
     */
    @Override
    public void end(boolean interrupted) {
        elevator.setPower(0);
    }

    /**
     * checks if the elevator reached the desired height
     *
     * @return
     */
    @Override
    public boolean isFinished() {
        if (elevator.heightCheck(elevator.getPosition(), height)) {
            return true;
        } else {
            return false;
        }
    }
}
