package frc.robot.subsystems.gripper.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.gripper.Gripper;

public class Outtake extends CommandBase {
    private final Gripper gripper;
    private final double outtakePower;

    public Outtake(Gripper gripper, double outtakePower) {
        this.gripper = gripper;
        this.outtakePower = outtakePower;
        addRequirements(gripper);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        gripper.setPower(outtakePower);

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
