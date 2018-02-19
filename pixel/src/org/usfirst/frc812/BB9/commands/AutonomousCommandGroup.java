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
		
			addSequential(new DriveByTime(0.0, 0.3, 3.5));
			addSequential(new MoveArmByTime(0.20, 2.0));
			addParallel(new MoveArmByTime(-0.15, 15.0));
			addParallel(new WinchAndRelease());
			
			RobotMap.runOnce = false;
		} else {
			System.out.println("runOnce is false and so I'm not running this again.");
		}
	}
}
