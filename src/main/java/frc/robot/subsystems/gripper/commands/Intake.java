package frc.robot.subsystems.gripper.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.gripper.Gripper;

public class Intake extends CommandBase {
    private final Gripper gripper;
    private final double intakePower;

    public Intake(Gripper gripper, double intakePower) {
        this.gripper = gripper;
        this.intakePower = intakePower;
        addRequirements(gripper);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        gripper.close();
        gripper.setPower(intakePower);
    }

    @Override
    public void end(boolean interrupted) {
        gripper.setPower(0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
