package org.usfirst.frc812.BB9.commands;

import org.usfirst.frc812.BB9.Robot;
import org.usfirst.frc812.BB9.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class PrintDiagnostics extends Command {

	boolean done = false;

    public PrintDiagnostics() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double IMUrate = Robot.imu.getQuaternionX();
		double IMUyaw = Robot.imu.getMagX();
		double IMUroll = Robot.imu.getAngleX();
		double IMUpitch = Robot.imu.getAccelX();

		System.out.println("  IMU rate =" +IMUrate);
		System.out.println("  Yaw =" +IMUyaw);
		System.out.println("  Roll =" +IMUroll);	
		System.out.println("  Pitch =" +IMUpitch);
		
        Robot.controlBoxSubsystem.printBits();
        
        System.out.println("Sensor Position = " + RobotMap.armMotor.getSelectedSensorPosition(0));

        done = true;
    }
    

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return done;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	this.end();
    }
}
