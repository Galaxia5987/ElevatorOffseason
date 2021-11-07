/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.Elevator.Elevator;
import frc.robot.subsystems.Elevator.commands.SlowMovement;
import frc.robot.subsystems.Elevator.commands.TestElevator;
import frc.robot.subsystems.Elevator.commands.UpdateElevator;

import static frc.robot.Ports.Elevator.XBOX;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    XboxController xboxController = new XboxController(XBOX);
    JoystickButton a = new JoystickButton(xboxController, XboxController.Button.kA.value);
    JoystickButton b = new JoystickButton(xboxController, XboxController.Button.kB.value);
    JoystickButton x = new JoystickButton(xboxController, XboxController.Button.kX.value);
    private boolean elevatorMode = true;
    private Elevator elevator = Elevator.getInstance();

    // The robot's subsystems and commands are defined here...

    /**
     * The container for the robot.  Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        // Configure the button bindings
        configureButtonBindings();
    }

    /**
     * Use this method to define your button->command mappings.  Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
     * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
        a.whenPressed(new UpdateElevator(elevator, elevatorMode));
        b.whenPressed(new TestElevator(elevator, elevatorMode));
        x.whenPressed(new SlowMovement(elevator, elevatorMode));
        elevatorMode = !elevatorMode;
    }


    /**
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {

        // An ExampleCommand will run in autonomous
        return null;
    }
}
