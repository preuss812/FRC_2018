package org.usfirst.frc812.BB9.commands;
import org.usfirst.frc812.BB9.Robot;
import org.usfirst.frc812.BB9.RobotMap;

import edu.wpi.first.wpilibj.command.Command;



public class WinchByTime extends Command {
	private double Y_Speed;
	private double Seconds;
	/*
	 * 
	 */
	public WinchByTime(double ySpeed, double seconds) {
		Y_Speed=ySpeed;
		Seconds = seconds;
		setTimeout(Seconds);
		System.out.println("WinchByTime yspeed=" + ySpeed + ", duration=" + seconds + " seconds");
	}
    protected void initialize() {
    
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.winch.set(Y_Speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
		return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.winch.stopMotor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}