package org.usfirst.frc812.BB9.subsystems;

import org.usfirst.frc812.BB9.Robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class ControlBoxSubsystem extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	public static final int CB1 = 2;
	public static final int CB2 = 4;
	public static final int CB3 = 8;
	public static final int CB4 = 16;
	public static final int CB5 = 32;
	public static final int CB6 = 64;
	public static final int CB7 = 128;

	public int flagBits = 0;
		
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    // This function reads each button on the control box and sets 
    // a corresponding single bit in the integer variable flagBits
    // using bit shifts; e.g., << operator
    public void readBits() {
    	flagBits = 0;
    	for (int i = 1; i<=7; i++) {
    		if(Robot.oi.controlBox.getRawButton(i)) {
    			flagBits |= 1 << i;
    		}
    	}
    }
    
    // Creates a mask by bit shifting to the flag number
    // to be inspected and then logically ands that against
    // the flagBits and if the mask set is equal to the value
    // returned, then the bit is set.
    public boolean isSet(int flag) {
    	int flagMask = 1 << flag;
    	if( (flagBits & flagMask) == flagMask ) {
    		return true;
    	} else {
    		return false;
    	}
    }
    public void printBits() {
    	readBits();
    	System.out.println("ControlBox bits: " + Integer.toBinaryString(flagBits));
    	String prespace = "";
    	System.out.print("Switches: ");
    	for (int i = 1; i<=7; i++) {
    		System.out.print(prespace + i + "=" + (isSet(i) ? "on":"off"));
    		prespace = " ";
    	}	

    	System.out.println("");
    	System.out.println("ControlBox pot 0:  " + getPotValue(0));
    	System.out.println("ControlBox pot 1:  " + getPotValue(1));
    	
    	System.out.println("Three position switch status:");
    	System.out.println("\tleft: " + (isSwitchLeft() ? "true":"false"));
    	System.out.println("\tcenter: " + (isSwitchCenter() ? "true":"false"));
    	System.out.println("\tright: " + (isSwitchRight() ? "true":"false"));
    }
    
    /*
    The three position switch on the external control box requires two bits
    The switches are 1 and 2

     1  |  2  | Position
    --------------------
     0     0    Left (or Out for FRC 2017)
     0     1    Center (or Off for FRC 2017)
     1     0    Don't care
     1     1    Right (or IN for FRC 2017)
     */
       
    public Boolean isSwitchLeft() {
    	return( ! isSet(1) && ! isSet(2) );
    }
       
    public Boolean isSwitchCenter() {
    	return( ! isSet(1) &&  isSet(2)) ;
    }
    
    public Boolean isSwitchRight() {
    	return( isSet(1) && isSet(2));
    }
       
    public double getPotValue(int axis) {
    	return Robot.oi.controlBox.getRawAxis(axis);
    }
}

