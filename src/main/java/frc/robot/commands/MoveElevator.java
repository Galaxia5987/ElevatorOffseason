package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ExampleSubsystem.Elevator;

import java.util.function.DoubleSupplier;

public class MoveElevator extends CommandBase {
        private final Elevator elevator;
        private final DoubleSupplier doubleSupplier;

        public MoveElevator(Elevator elevator, DoubleSupplier doubleSupplier){
            this.elevator=elevator;
            this.doubleSupplier=doubleSupplier;
            addRequirements(elevator);
        }

    @Override
    public void execute() {
        elevator.setPower();
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
