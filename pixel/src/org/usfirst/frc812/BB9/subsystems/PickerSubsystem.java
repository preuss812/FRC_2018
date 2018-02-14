package org.usfirst.frc812.BB9.subsystems;

import org.usfirst.frc812.BB9.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class PickerSubsystem extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	private DoubleSolenoid picker = RobotMap.picker ;
	
	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    public void open(){	
    	picker.set(DoubleSolenoid.Value.kReverse);
    }
    public void close(){
    	picker.set(DoubleSolenoid.Value.kForward);
    }
}

