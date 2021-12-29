/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.gripper.Gripper;
import frc.robot.subsystems.gripper.commands.Intake;
import frc.robot.subsystems.gripper.commands.Outtake;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.subsystems.elevator.Elevator;
import frc.robot.subsystems.elevator.commands.Height;
import frc.robot.subsystems.elevator.commands.ManualClimb;
import frc.robot.valuetuner.ValueTuner;
import webapp.Webserver;

import static frc.robot.Ports.Controller.*;

public class RobotContainer {
    public static XboxController xboxController = new XboxController(XBOX_CONTROLLER);
    public static JoystickButton x = new JoystickButton(xboxController, XboxController.Button.kX.value);
    public static JoystickButton y = new JoystickButton(xboxController, XboxController.Button.kY.value);
    public static JoystickButton b = new JoystickButton(xboxController, XboxController.Button.kB.value);
    public static JoystickButton a = new JoystickButton(xboxController, XboxController.Button.kA.value);
    public static JoystickButton start = new JoystickButton(xboxController, XboxController.Button.kStart.value);
    public static JoystickButton back = new JoystickButton(xboxController, XboxController.Button.kBack.value);
    private final Trigger lt = new Trigger(() -> xboxController.getTriggerAxis(GenericHID.Hand.kLeft) > 0.3);
    private final Trigger rt = new Trigger(() -> xboxController.getTriggerAxis(GenericHID.Hand.kRight) > 0.3);
    private final JoystickButton lb = new JoystickButton(xboxController, XboxController.Button.kBumperLeft.value);
    private final JoystickButton rb = new JoystickButton(xboxController, XboxController.Button.kBumperRight.value);
    private final Gripper gripper = Gripper.getInstance();
    public static Elevator elevator = Elevator.getInstance();


    // The robot's subsystems and commands are defined here...



    /**
     * The container for the robot.  Contains subsystems, OI devices, and commands.
     */
    public RobotContainer() {
        // Configure the button bindings
        configureButtonBindings();

        if (Robot.debug) {
            startValueTuner();
            startFireLog();
        }
        elevator.setDefaultCommand(new ManualClimb(elevator));
    }

    /**
     * Use this method to define your button->command mappings.  Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
     * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
     */
    private void configureButtonBindings() {
        a.whenPressed(new Height(elevator, Constants.Elevator.HALF_METER_HEIGHT));
        b.whenPressed(new Height(elevator, Constants.Elevator.METER_HEIGHT));
        y.whenPressed(new Height(elevator, Constants.Elevator.MAX_HEIGHT));
        x.whenPressed(new Height(elevator, Constants.Elevator.MIN_HEIGHT));
        start.whenPressed(() -> elevator.resetElevator());
        lt.whileActiveContinuous(new Intake(gripper, 1));
        rt.whileActiveContinuous(new Outtake(gripper, -1));
        back.whenPressed(gripper::open);
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

    /**
     * Initiates the value tuner.
     */
    private void startValueTuner() {
        new ValueTuner().start();
    }

    /**
     * Initiates the port of team 225s Fire-Logger.
     */
    private void startFireLog() {

        try {
            new Webserver();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
