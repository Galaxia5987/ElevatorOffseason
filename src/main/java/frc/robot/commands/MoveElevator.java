package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ExampleSubsystem.Elevator;

import java.util.function.DoubleSupplier;

public class MoveElevator extends CommandBase {
    private final Elevator elevator;
    private final DoubleSupplier joystickValue;

    public MoveElevator(Elevator elevator, DoubleSupplier joystickValue) {
        this.elevator = elevator;
        this.joystickValue = joystickValue;
        addRequirements(elevator);
    }

    /**
     * sets the power of the elevator to the desired value with a joystick
     */
    @Override
    public void execute() {
        elevator.setPower(elevator.DeadZone(joystickValue.getAsDouble()));
    }

    /**
     * stops the elevator
     *
     * @param interrupted
     */
    @Override
    public void end(boolean interrupted) {
        elevator.setPower(0);
    }
}
