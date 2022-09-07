package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;

import java.util.function.DoubleSupplier;

public class JoystickPower extends CommandBase {
    private final Elevator elevator;
    private final DoubleSupplier joystickinput;

    public JoystickPower(Elevator elevator, DoubleSupplier joystickinput) {
        this.elevator = elevator;
        this.joystickinput =  joystickinput;
        addRequirements(elevator);
    }

    @Override
    public void initialize() {
    }

    /**
     * set power to power%
     */
    @Override
    public void execute() {
        elevator.setPower(elevator.getDeadband(joystickinput.getAsDouble()));
    }

    /**
     * set power to 0%
     *
     * @param interrupted whether the command was interrupted/canceled
     */
    @Override
    public void end(boolean interrupted) {
        elevator.setPower(0);
    }
}
