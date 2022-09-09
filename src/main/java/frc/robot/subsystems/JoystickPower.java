package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.CommandBase;
<<<<<<< HEAD
import edu.wpi.first.wpilibj2.command.SubsystemBase;
=======
>>>>>>> parent of 86ddd8e... Merge pull request #5 from Galaxia5987/Jonathan

import java.util.function.DoubleSupplier;

public class JoystickPower extends CommandBase {
    private final Elevator elevator;
<<<<<<< HEAD
    private DoubleSupplier joystickinput;

    public JoystickPower(Elevator elevator, DoubleSupplier joystickinput) {
        this.elevator = elevator;
        this.joystickinput = joystickinput;
=======
    private final DoubleSupplier joystickinput;

    public JoystickPower(Elevator elevator, DoubleSupplier joystickinput) {
        this.elevator = elevator;
        this.joystickinput =  joystickinput;
>>>>>>> parent of 86ddd8e... Merge pull request #5 from Galaxia5987/Jonathan
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
<<<<<<< HEAD
=======
     *
>>>>>>> parent of 86ddd8e... Merge pull request #5 from Galaxia5987/Jonathan
     * @param interrupted whether the command was interrupted/canceled
     */
    @Override
    public void end(boolean interrupted) {
        elevator.setPower(0);
    }
}
