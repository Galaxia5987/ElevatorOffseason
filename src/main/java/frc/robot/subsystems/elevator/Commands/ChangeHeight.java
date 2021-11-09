package frc.robot.subsystems.elevator.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.elevator.Elevator;

public class ChangeHeight extends CommandBase {
    private final Elevator elevator;
    private double requiredHeight;

    public ChangeHeight(Elevator elevator, double requiredHeight) {
        this.elevator = elevator;
        this.requiredHeight = requiredHeight;
        addRequirements(elevator);
    }


    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        elevator.setPosition(requiredHeight);
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {

    }

}
