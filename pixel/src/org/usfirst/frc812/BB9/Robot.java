// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc812.BB9;

import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.I2C.Port;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
//import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionThread;
import edu.wpi.first.wpilibj.Timer;

import org.usfirst.frc812.BB9.commands.AutonomousCommand;
//import org.usfirst.frc812.BB9.commands.*;
//import org.usfirst.frc812.BB9.pipelines.MidGripPipeline;
import org.usfirst.frc812.BB9.subsystems.DriveTrain;
//import org.usfirst.frc812.BB9.sensors.*;

import com.analog.adis16448.frc.ADIS16448_IMU;

// Added to try and run GRIP from FRC Source Code - 1/21/17
//import java.io.IOException;
//import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	Command autonomousCommand;

	public static OI oi;
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public static DriveTrain driveTrain;
	public static ADIS16448_IMU imu;
	
	private static final int IMG_WIDTH = 320;
	private static final int IMG_HEIGHT = 240;

	private VisionThread visionThread;
	public static double centerX = 3.14;
//	private RobotDrive drive;

	private final Object imgLock = new Object();
	
	// GRIP network table
	// private final NetworkTable grip = NetworkTable.getTable("grip");

	// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		// SmartDashboard.putData("This is a test");
		RobotMap.init();
	
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		driveTrain = new DriveTrain();

		Timer.delay(0.1);
		
		// The following print statements come from the controlBoxSubsystem.. they're
		// only here for testing initial connection to the wheel  encoders while we have no
		// joysticks hooked up

		imu = new ADIS16448_IMU();
		 SmartDashboard.putData("IMU", imu);
		 Timer.delay(0.005);
		imu.calibrate();
		imu.reset();
		
		/*
		 * visionThread = new VisionThread(usbCamera, new MidGripPipeline(),
		 * pipeline -> { ArrayList<MatOfPoint> filterContoursOutput =
		 * pipeline.filterContoursOutput(); if (!filterContoursOutput.isEmpty())
		 * { int i = 0; for (MatOfPoint m : filterContoursOutput) {
		 * System.out.println("val for " + i++ + " is: " +
		 * Imgproc.boundingRect(m).x); } } }); visionThread.start();
		 */

		// drive = new RobotDrive(1, 2);

		/* Run GRIP in a new process */
		/*
		 * try{ new ProcessBuilder("/home/lvuser/grip").inheritIO().start(); }
		 * catch(IOException e){ e.printStackTrace(); }
		 */
		// cameraServer.startAutomaticCapture();

		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		// OI must be constructed after subsystems. If the OI creates Commands
		// (which it very likely will), subsystems are not guaranteed to be
		// constructed yet. Thus, their requires() statements may grab null
		// pointers. Bad news. Don't move it.
		oi = new OI();

		// instantiate the command used for the autonomous period
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS


		// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit() {

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	public void autonomousInit() {
		// schedule the autonomous command (example)
		autonomousCommand = new AutonomousCommand();
		System.out.println("auto init");
		if (autonomousCommand != null)
			autonomousCommand.start();
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic() {
		System.out.println("auto running");
		Scheduler.getInstance().run();
		//System.out.println("leftcount is " +LeftCount );
		//System.out.println("rightcount is " + RightCount );
	}

	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		// SmartDashboard.putData("IMU", imu); // TODO: remove me
		
		Scheduler.getInstance().run();
		//System.out.println("teleop periodic was called");
		
		//If switch (4) is up then regular speed 
		//else down then faster 
		/*
//		Joystick cb = RobotMap.controlBox; 		// initialize the black control box
		boolean on = cb.getRawButton(4);		// initialize the switch used in manual gear shifting
		boolean auto = cb.getRawButton(5);		// initialize the switch between automatic and manual gear shifting
*/


		double IMUrate = imu.getQuaternionX();
		double IMUyaw = imu.getMagX();
		double IMUroll = imu.getAngleX();
		double IMUpitch = imu.getAccelX();
		
/*		System.out.println("  IMU rate =" +IMUrate);
		System.out.println("  Yaw =" +IMUyaw);
		System.out.println("  Roll =" +IMUroll);	
		System.out.println("  Pitch =" +IMUpitch);
		*/
//		xboxControllerSubsystem.refresh();
//		System.out.println("  xboxright (x,y) = (" + xboxControllerSubsystem.RightStick.X + ", " +
//													xboxControllerSubsystem.RightStick.Y);
		RobotMap.armMotor.set(Robot.oi.leftJoystick.getY());
	}
		
	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
	//	LiveWindow.run();
	}

	public double getCenterX() {
		return centerX;
	}

	public void setCenterX(double centerX) {
		this.centerX = centerX;
	}

}
