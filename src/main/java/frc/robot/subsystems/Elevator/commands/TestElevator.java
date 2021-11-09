package frc.robot.subsystems.Elevator.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator.Elevator;

public class TestElevator extends CommandBase {
    private double lastTime = 0, currTime;
    private Timer timer = new Timer();
    private final Elevator elevator;
    private boolean elevatorMode; // True is up and false is down.

    /**
     * Constructor.
     *
     * @param elevatorMode is a boolean used to decide whether
     *                     the elevator is going up or down.
     */
    public TestElevator(Elevator elevator) {
        this.elevator = elevator;
    }

    public void setElevatorMode() {
        elevatorMode = elevator.atBottom();
    }


    @Override
    public void initialize() {
        timer.start();
        setElevatorMode();
    }

    /**
     * Changes the position of the motor.
     */
    @Override
    public void execute() {
        currTime = timer.get();

        if (elevatorMode) {
            elevator.setPosition((currTime - lastTime));
        } else {
            elevator.setPosition((currTime - lastTime));
        }

        lastTime = currTime;
    }

    @Override
    public void end(boolean interrupted) {
        elevator.terminate();
    }

    @Override
    public boolean isFinished() {
        return elevatorMode ? (elevator.atTop()) : (elevator.atBottom());
    }
}
