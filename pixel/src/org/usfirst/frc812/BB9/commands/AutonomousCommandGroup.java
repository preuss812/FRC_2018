package org.usfirst.frc812.BB9.commands;

import org.usfirst.frc812.BB9.Robot;
import org.usfirst.frc812.BB9.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousCommandGroup extends CommandGroup {
	AutonomousCommandGroup() {
		System.out.println("I'm in AutonomousCommandGroup");
		if( RobotMap.runOnce ) {
		//input parameters(xSpeed, ySpeed, time in seconds)
			addSequential(new DriveByTime(0.0, 0.3, 3.5));//drives ten feet 
			addSequential(new MoveArmByTime(0.20, 2.0));//moves arm down 
			addParallel(new MoveArmByTime(-0.18, 15.0));//parallel meaning arm moves to upward position and also runs winch for 
			addParallel(new WinchAndRelease());//eight seconds
			
			RobotMap.runOnce = false;
		} else {
			System.out.println("runOnce is false and so I'm not running this again.");
		}
	}
}
