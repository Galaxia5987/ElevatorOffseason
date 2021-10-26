package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class Command extends CommandBase {
    private final Elevator elevator = Elevator.getInstance();
    private final double height;

    public Command(double height) {
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
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
