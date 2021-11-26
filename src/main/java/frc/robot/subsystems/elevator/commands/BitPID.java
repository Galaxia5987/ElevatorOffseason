package frc.robot.subsystems.elevator.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.elevator.Elevator;

public class BitPID extends CommandBase {
    private final Elevator elevator;

    public BitPID(Elevator elevator){
        this.elevator = elevator;
        addRequirements(elevator);

    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return isFinished();
    }
}
