package frc.robot.subsystems.Elevator.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator.Elevator;

import static frc.robot.Constants.Elevator.SLOW_MOVEMENT;

public class SlowMovement extends CommandBase {
    private final Elevator elevator;
    private boolean elevatorMode; // True is up and false is down.

    public SlowMovement(Elevator elevator, boolean elevatorMode) {
        this.elevator = elevator;
        this.elevatorMode = elevatorMode;
    }

    public void setElevatorMode() {
        elevatorMode = elevator.atBottom();
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
            elevator.setVelocity(SLOW_MOVEMENT);
        } else {
            elevator.setVelocity(-SLOW_MOVEMENT);
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
