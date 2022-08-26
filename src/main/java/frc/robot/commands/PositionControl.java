package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ExampleSubsystem.Elevator;

public class PositionControl extends CommandBase {
    private final Elevator elevator;
    private final double height;

    public PositionControl(Elevator elevator, double height) {
        this.elevator = elevator;
        this.height=height;
        addRequirements(elevator);
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
        if(elevator.heightCheck(elevator.getPosition(), height)){
            return true;
        }
        else{
            return false;
        }
    }
}
