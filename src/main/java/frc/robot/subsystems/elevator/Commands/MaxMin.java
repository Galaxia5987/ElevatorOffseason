package frc.robot.subsystems.elevator.Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.elevator.Elevator;

public class MaxMin extends CommandBase {
    private Elevator elevator;
    private Elevator.Position position;

    public MaxMin(Elevator elevator, Elevator.Position position) {
        this.elevator = elevator;
        this.position = position;
        addRequirements(elevator);
    }


    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        elevator.goToJoe(position);
    }

    @Override
    public void end(boolean interrupted) {
        elevator.setPower(0);
    }

    /**
     * finishes the program if either the toplimitSwitch or the bottomlimitSwitch returns "true"
     */
    @Override
    public boolean isFinished() {
        if (position == Elevator.Position.highJoe) {
            return elevator.IsAtTop();
        }
        else {
            return elevator.IsAtBottom();
        }
    }

}
