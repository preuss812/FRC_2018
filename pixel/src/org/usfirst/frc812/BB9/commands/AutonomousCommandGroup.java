package org.usfirst.frc812.BB9.commands;

import org.usfirst.frc812.BB9.Robot;
import org.usfirst.frc812.BB9.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 * We have enabled the three position switch on the external control box
 * The autonomous CommandGroup can operate three different autonomous
 * sequences depending on where the switch is set.
 * - Robot.controlBoxSubsystem.isSwitchleft()
 * - Robot.controlBoxSubsystem.isSwitchCenter()
 * - Robot.controlBoxSubsystem.isSwitchRight()
 */
public class AutonomousCommandGroup extends CommandGroup {
	AutonomousCommandGroup() {
		System.out.println("I'm in AutonomousCommandGroup");
		if( RobotMap.runOnce ) {
			if( Robot.controlBoxSubsystem.isSwitchLeft()) {
		//input parameters(xSpeed, ySpeed, time in seconds)
				addSequential(new DriveByTime(0.0, 0.3, 3.5));//drives ten feet 
				addSequential(new MoveArmByTime(0.20, 2.0));//moves arm down 
				addParallel(new MoveArmByTime(-0.18, 15.0));//parallel meaning arm moves to upward position and also runs winch for 
				addParallel(new WinchAndRelease());//eight seconds

			} else if( Robot.controlBoxSubsystem.isSwitchCenter()) {
				//if the switch is center, the arm motors will run twice as fast
				addSequential(new DriveByTime(0.0, 0.3, 3.5));//drives ten feet 
				addSequential(new MoveArmByTime(0.40, 2.0));//moves arm down 
				addParallel(new MoveArmByTime(-0.36, 15.0));//parallel meaning arm moves to upward position and also runs winch for 
				addParallel(new WinchAndRelease());//eight seconds
//				addSequential(new DriveByTime(0.0, Robot.controlBoxSubsystem.getPotValue(0), 3.5));
			} else if( Robot.controlBoxSubsystem.isSwitchRight()) {
				//if the switch is center, the arm motors will run twice as fast
				addSequential(new DriveByTime(0.0, 0.3, 3.5));//drives ten feet 
				addSequential(new MoveArmByTime(0.40, 2.0));//moves arm down 
				addParallel(new MoveArmByTime(-0.36, 15.0));//parallel meaning arm moves to upward position and also runs winch for 
				addParallel(new WinchAndRelease());//eight seconds
				// Perform a sequence
			}
			
			RobotMap.runOnce = false;
		} else {
			System.out.println("runOnce is false and so I'm not running this again.");
		}
	}
}
