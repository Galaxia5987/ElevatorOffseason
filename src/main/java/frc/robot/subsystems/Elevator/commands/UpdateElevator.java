package frc.robot.subsystems.Elevator.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Elevator.Elevator;

import static frc.robot.Constants.Elevator.*;

public class UpdateElevator extends CommandBase {
    private Elevator elevator = new Elevator();
    private boolean elevatorMode; // true is up and false is down

    public UpdateElevator(boolean elevatorMode) {
        this.elevatorMode = elevatorMode;
    }

    @Override
    public void execute() {
        if(elevatorMode){
            elevator.setPosition(MAX_HEIGHT);
        }else{
            elevator.setPosition(-MAX_HEIGHT);
        }
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return super.isFinished();
    }
}
