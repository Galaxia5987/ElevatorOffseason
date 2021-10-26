package frc.robot.subsystems.Elevator.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator.Elevator;

import static frc.robot.Constants.Elevator.MAX_HEIGHT;

public class UpdateElevator extends CommandBase {
    private final Elevator elevator;
    private boolean elevatorMode; // True is up and false is down.

    /**
     * Constructor.
     *
     * @param elevatorMode is a boolean used to decide whether
     *                     the elevator is going up or down.
     */
    public UpdateElevator(Elevator elevator, boolean elevatorMode) {
        this.elevator = elevator;
        this.elevatorMode = elevatorMode;
    }

    public void setElevatorMode() {
        elevatorMode = (elevator.atTop() && elevator.atBottom());
    }

    @Override
    public void initialize() {
        setElevatorMode();
    }

    /**
     * Changes the position of the motor.
     */
    @Override
    public void execute() {
        if (elevatorMode) {
            elevator.setPosition(MAX_HEIGHT);
        } else {
            elevator.setPosition(-MAX_HEIGHT);
        }
    }

    @Override
    public void end(boolean interrupted) {
        elevator.terminate();
    }

    @Override
    public boolean isFinished() {
        return elevatorMode ? elevator.atTop() : elevator.atBottom();
    }
}
