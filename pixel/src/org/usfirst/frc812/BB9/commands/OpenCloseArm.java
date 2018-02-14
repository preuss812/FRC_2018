package org.usfirst.frc812.BB9.commands;
import org.usfirst.frc812.BB9.Robot;
import org.usfirst.frc812.BB9.RobotMap;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;



public class OpenCloseArm extends CommandGroup {
	private boolean started = false;
		
	public boolean isRunning() {
		return started;
	}
		
	public void cancel() {
		Robot.pickerSubsystem.close();
		started = false;
	}
	public void start() {
		Robot.pickerSubsystem.open();
		started = true;
	}
}
