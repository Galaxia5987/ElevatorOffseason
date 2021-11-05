package frc.robot.subsystems.elevator.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Ports;
import frc.robot.subsystems.elevator.Elevator;

/**
 * Add parameter elevator.
 * Add field lsBottom.
 */
public class Calibrate extends CommandBase {
    private final Elevator elevator;
    private boolean lsBottom = false;

    public Calibrate(Elevator elevator) {
        this.elevator = elevator;
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        if (elevator.atBottom()){
            lsBottom = true;
            elevator.setPower(Constants.Elevator.LS_POWER);
        }
        else {
            elevator.setPower(-Constants.Elevator.LS_POWER);
        }
    }

    @Override
    public boolean isFinished() {
        return lsBottom && !elevator.atBottom();
    }

    @Override
    public void end(boolean interrupted) {
        elevator.setPower(0);
    }
}
