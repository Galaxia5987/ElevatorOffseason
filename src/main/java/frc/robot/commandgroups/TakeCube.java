package frc.robot.commandgroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.elevator.Elevator;
import frc.robot.subsystems.elevator.commands.Height;
import frc.robot.subsystems.gripper.Gripper;
import frc.robot.subsystems.gripper.commands.Intake;

public class TakeCube extends SequentialCommandGroup {
    public TakeCube(double height, double power, Elevator elevator, Gripper gripper) {
        addCommands(
            new Height(elevator, height),
            new Intake(gripper, power)
        );
    }
}
