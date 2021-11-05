package frc.robot.subsystems.elevator.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.elevator.Elevator;

/**
 * Add parameters elevator&Top.
 */
public class TopBottom extends CommandBase {
    private final Elevator elevator;
    private final boolean Top;

    /**
     * @param Top boolean, the top limit switch.
     */
    public TopBottom(Elevator elevator, boolean Top) {
        this.elevator = elevator;
        this.Top = Top;
        addRequirements(elevator);
    }

    /**
     * If elevator is in top, go to the bottom, if elevator at bottom, go to the top.
     */
    @Override
    public void initialize() {
        if (Top){
            elevator.setPosition(Constants.Elevator.TOP);
        }
        else {
            elevator.setPosition(Constants.Elevator.BOTTOM);
        }
    }

    @Override
    public void execute() {

    }


    @Override
    public boolean isFinished() {
        if (Top) {
            return elevator.atTop();
        }
        else {
            return elevator.atBottom();
        }
    }

    @Override
    public void end(boolean interrupted) {
        elevator.setPower(0);
    }
}
