package frc.robot.subsystems.elevator.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.elevator.Elevator;

public class TopBottom extends CommandBase {
    private final Elevator elevator;
    private final int Top;
    private final int Bottom;

    public TopBottom(Elevator elevator, int Top, int Bottom) {
        this.elevator = elevator;
        this.Bottom = Bottom;
        this.Top = Top;
        addRequirements(elevator);
    }

    @Override
    public void initialize() {
    if (elevator.atTop()== true){
        elevator.topLimitSwitch(0);
    }
    }

    @Override
    public void execute() {

    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public void end(boolean interrupted) {
    }
}
