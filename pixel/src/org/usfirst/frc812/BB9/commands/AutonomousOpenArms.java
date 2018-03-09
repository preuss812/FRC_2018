package org.usfirst.frc812.BB9.commands;

import org.usfirst.frc812.BB9.Robot;
import org.usfirst.frc812.BB9.RobotMap;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutonomousOpenArms extends CommandGroup {
	AutonomousOpenArms() {
		if( Robot.gameData.length() > 0 && 
			! Robot.controlBoxSubsystem.isSet(6)) {
			
			System.out.println("gameData string = >" + Robot.gameData + "<");
			
			if( Robot.gameData.charAt(0) == 'L' && 
				Robot.controlBoxSubsystem.isSet(5) )    // switch 5 set == left side of field
					addSequential(new OpenArms());      // Open the arms to drop the payload
			
			if( Robot.gameData.charAt(0) == 'R' &&
				! Robot.controlBoxSubsystem.isSet(5) )  // switch 5 NOT set == right side of field
					addSequential(new OpenArms());
		}
	}
}
