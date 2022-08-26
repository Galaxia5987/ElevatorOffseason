/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.gripper.Gripper;
import frc.robot.subsystems.gripper.commands.Intake;
import frc.robot.subsystems.gripper.commands.Outtake;

import static frc.robot.Ports.Controller.*;

public class RobotContainer {


    public RobotContainer() {
        configureButtonBindings();
    }
    //robot will intake when left trigger is held and outtake while right trigger is held
    private void configureButtonBindings() {

    }


    public Command getAutonomousCommand() {
        return null;
    }
}
