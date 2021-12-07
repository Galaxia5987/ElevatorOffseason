package frc.robot.commandgroups;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.elevator.Elevator;
import frc.robot.subsystems.elevator.commands.Height;
import frc.robot.subsystems.gripper.Gripper;
import frc.robot.subsystems.gripper.commands.Outtake;

public class PlaceCube extends SequentialCommandGroup {
    public PlaceCube(Elevator elevator, Gripper gripper, double height, double power) {
        addCommands(
                new Height(elevator, height),
                new Outtake(gripper, power)
        );
    }
}
