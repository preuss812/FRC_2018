package org.usfirst.frc812.BB9.commands;

import org.usfirst.frc812.BB9.Robot;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousCommandGroup extends CommandGroup {
	AutonomousCommandGroup() {
		System.out.println("I'm in AutonomousCommandGroup");
		
//		addSequential(new DriveByTime(0.0, 0.3, 3.5));
		addSequential(new MoveArmByTime(0.20, 0.1));
		addSequential(new MoveArmByTime(-0.15, 0.2));
	}

}
