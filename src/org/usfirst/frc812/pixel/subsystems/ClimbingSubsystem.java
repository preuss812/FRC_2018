package org.usfirst.frc812.pixel.subsystems;

import org.usfirst.frc812.pixel.Robot;
import org.usfirst.frc812.pixel.RobotMap;
import org.usfirst.frc812.pixel.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;



	
	 
public class ClimbingSubsystem extends Subsystem {
	public DifferentialDrive robotDrive = RobotMap.dtProductionRobotDrive;
	
	public void initDefaultCommand(){
//	 limit switches default at false, becomes true when limit switch is pushed -- stops driving robot 
//	 when limit switch = true,  delay so it does not stop immediately otherwise keep driving 
//	 if (RobotMap.climberSensor.get() == true){
//		 stop();
//	 	}
		

	}
	
    public void stop() {
    	robotDrive.stopMotor();
//    	robotDrive.drive(0,0);
    }
}
