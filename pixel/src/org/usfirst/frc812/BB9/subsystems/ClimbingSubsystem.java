package org.usfirst.frc812.BB9.subsystems;

import org.usfirst.frc812.BB9.RobotMap;
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
