package frc.robot.subsystems.elevator.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.elevator.Elevator;

public class Height extends CommandBase {
    Elevator elevator;
    double height;

    public Height(Elevator elevator, double height) {
        this.height = height;
        this.elevator = elevator;
        addRequirements(elevator);
    }

    @Override
    public void initialize() {
        elevator.setHeight(height);
    }

    @Override
    public void end(boolean interrupted) {
        elevator.stop();
    }

    @Override
    public boolean isFinished() {
        return Math.abs( elevator.getheight() - height);
    }
}
