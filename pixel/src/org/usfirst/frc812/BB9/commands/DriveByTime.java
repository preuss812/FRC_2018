package org.usfirst.frc812.BB9.commands;
import org.usfirst.frc812.BB9.Robot;
import org.usfirst.frc812.BB9.RobotMap;

import edu.wpi.first.wpilibj.command.Command;



public class DriveByTime extends Command {
	private double Y_Speed;
	private double X_Speed;
	private double Rotation;
	private double Seconds;
	/*
	 * 
	 */
	public DriveByTime(double ySpeed, double xSpeed, double rotation, double seconds) {
		requires(Robot.driveTrain);
		Y_Speed=ySpeed;
		X_Speed = xSpeed;
		Rotation = rotation;
		Seconds = seconds;
		setTimeout(Seconds);
//		System.out.println("DriveByTime " + ySpeed + " " + xSpeed + " " + seconds );
	}
    protected void initialize() {
    
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	System.out.println("DriveByTime:execute " + Y_Speed + " " + X_Speed);
    	RobotMap.dtMecanumDrive.driveCartesian(Y_Speed, X_Speed, Rotation);
  //  	RobotMap.dtMecanumDrive.driveCartesian(ySpeed, xSpeed, zRotation);
    	//RobotMap.dtProductionRobotDrive.curvatureDrive(Speed, Direction,true);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
		return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	RobotMap.dtMecanumDrive.stopMotor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}