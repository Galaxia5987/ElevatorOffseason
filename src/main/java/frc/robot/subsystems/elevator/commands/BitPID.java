package frc.robot.subsystems.elevator.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.elevator.Elevator;

public class BitPID extends SequentialCommandGroup {

    public BitPID(Elevator elevator, int iter) {
        for (int i = 0; i < iter; i++) {
            addCommands(
                    new Height(elevator, 1),
                    new WaitCommand(1),
                    new Height(elevator, 0.5),
                    new WaitCommand(1)
            );
        }
    }
}

//
//    public BitPID(Elevator elevator, int doriftu){
//        this.elevator = elevator;
//        this.doriftu = doriftu;
//        addRequirements(elevator);
//    }
//
//    @Override
//    public void initialize() {
//    }
//
//    @Override
//    public void execute() {
//        for (int i = 0; i<30; i++){
//            elevator.setPosition(1);
//            elevator.getPosition();
//            doriftu = elevator.getPosition();
//           // elevator.setPosition(0.5);
//            // elevator.getPosition();
//        }
//        if ()
//    }
//
//    @Override
//    public void end(boolean interrupted) {
//    }
//
//    @Override
//    public boolean isFinished() {
//        return isFinished();
//    }
//}
