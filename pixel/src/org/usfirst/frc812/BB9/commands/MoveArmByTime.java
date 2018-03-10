package org.usfirst.frc812.BB9.commands;
import org.usfirst.frc812.BB9.Robot;
import org.usfirst.frc812.BB9.RobotMap;

import edu.wpi.first.wpilibj.command.Command;



public class MoveArmByTime extends Command {
	private double Y_Speed;
	private double Seconds;
	/*
	 * 
	 */
	public MoveArmByTime(double ySpeed, double seconds) {
		Y_Speed = ySpeed;
		Seconds = seconds;
	}
    protected void initialize() {
		System.out.println("MoveArmByTime ySpeed=" + Y_Speed + ", duration=" + Seconds + " seconds");
		this.setTimeout(Seconds);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	RobotMap.armMotor.set(Y_Speed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
		return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.armMotor.set(0.0);
		System.out.println("MoveArmByTime end() ySpeed=" + Y_Speed + ", duration=" + Seconds + " seconds");
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	System.out.println("MoveArmByTime interrupted()");
    	end();
    }
}