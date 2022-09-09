package frc.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Height extends CommandBase {
    private final double height;
    private Elevator elevator;

    public Height(double height, Elevator elevator) {
        this.height = height;
        this.elevator = elevator;
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
        return Math.abs(elevator.getPosition() - height) <= Constants.Elevator.OFFSET;
    }
}
