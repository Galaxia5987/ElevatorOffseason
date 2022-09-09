package frc.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Height extends SubsystemBase {
    private final double height;
    private Elevator elevator;

    public Height(double height, Elevator elevator) {
        this.height = height;
        this.elevator = elevator;
        
    }


}
