/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.JoystickPower;
import frc.robot.subsystems.gripper.Gripper;
import frc.robot.subsystems.gripper.commands.Intake;
import frc.robot.subsystems.gripper.commands.Outtake;

import static frc.robot.Ports.Controller.XBOX_CONTROLLER;

public class RobotContainer {
    private final XboxController xbox = new XboxController(XBOX_CONTROLLER);
    private final Trigger lt = new Trigger(() -> xbox.getLeftTriggerAxis() > 0.3);
    private final Trigger rt = new Trigger(() -> xbox.getRightTriggerAxis() > 0.3);
    private final JoystickButton lb = new JoystickButton(xbox, XboxController.Button.kLeftBumper.value);
    private final JoystickButton rb = new JoystickButton(xbox, XboxController.Button.kRightBumper.value);
    private final Gripper gripper = Gripper.getInstance();
    private final Elevator elevator = Elevator.getInstance();


    public RobotContainer() {
        configureButtonBindings();

        elevator.setDefaultCommand(new JoystickPower(elevator, ()->xbox.getRightY()));
    }

    //robot will intake when left trigger is held and outtake while right trigger is held
    private void configureButtonBindings() {
        lt.whileActiveContinuous(new Intake(gripper, 1));
        rt.whileActiveContinuous(new Outtake(gripper, -1));
    }


    public Command getAutonomousCommand() {
        return null;
    }
}
