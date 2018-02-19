package org.usfirst.frc812.BB9.commands;

import org.usfirst.frc812.BB9.Robot;
import org.usfirst.frc812.BB9.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class WinchAndRelease extends CommandGroup {
	WinchAndRelease() {
			addSequential(new WinchByTime(1.0, 8.0));
			addSequential(new OpenArms());
	}
}
