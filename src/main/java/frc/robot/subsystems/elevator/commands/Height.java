package frc.robot.subsystems.elevator.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.elevator.Elevator;
import webapp.FireLog;

/**
 * Add parameters elevator&height.
 */
public class Height extends CommandBase {
    private final Elevator elevator;
    private final double height;
    private Timer timer = new Timer();

    public Height(Elevator elevator, double height) {
        this.elevator = elevator;
        this.height = height;
        addRequirements(elevator);
    }

    @Override
    public void initialize() {
        timer.reset();
        timer.start();
    }

    @Override
    public void execute() {
        elevator.setPosition(height);
        FireLog.log("setpoint", height);
        System.out.println(Math.abs(height - elevator.getPosition()));
    }

    @Override
    public void end(boolean interrupted) {
        elevator.setPower(0);
    }

    @Override
    public boolean isFinished() {
        if (Math.abs(height - elevator.getPosition()) < Constants.Elevator.HEIGHT) {
            timer.start();
            elevator.setPower(0);


        }
         return isFinished();
    }

}

