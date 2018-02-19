package org.usfirst.frc812.BB9.commands;

import org.usfirst.frc812.BB9.Robot;
import org.usfirst.frc812.BB9.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class WinchAndRelease extends CommandGroup {
	WinchAndRelease() {
			addSequential(new WinchByTime(1.0, 5.85));//(power, time in seconds)
			addSequential(new OpenArms());//opens arm after running top part
	}
}
