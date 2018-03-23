package org.usfirst.frc812.BB9.commands;

import org.usfirst.frc812.BB9.Robot;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AutonomousOpenArms extends Command {
	public AutonomousOpenArms() {
		System.out.println("AutonomousOpenArms: executing");
	}
    protected void initialize() {
        
    }
    protected void execute() {
		if( Robot.gameData.length() > 0 && 
				! Robot.controlBoxSubsystem.isSet(6)) {
				
			System.out.println("AutonomousOpenArms:gameData is present and isSet(6) is FALSE, gameData = >" + Robot.gameData + "<");
				
			if( Robot.gameData.charAt(0) == 'L' && 
				Robot.controlBoxSubsystem.isSet(5) )    // switch 5 set == left side of field
					Robot.pickerSubsystem.open();;      // Open the arms to drop the payload
				
			if( Robot.gameData.charAt(0) == 'R' &&
				! Robot.controlBoxSubsystem.isSet(5) )  // switch 5 NOT set == right side of field
					Robot.pickerSubsystem.open();
		}
		end();
    }

	protected boolean isFinished() {
		return true;
	}

// Called once after isFinished returns true
	protected void end() {
	}

// Called when another command which requires one or more of the same
// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}

}
