package org.usfirst.frc812.BB9.subsystems;

import org.usfirst.frc812.BB9.Robot;
import org.usfirst.frc812.BB9.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class XboxControllerSubsystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    
    public Axis LeftStick = new Axis(0,0), RightStick = new Axis(0,0);
    public XboxController XBC;

	public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
	public class Axis {
		public double X, Y;
		public Axis(double x, double y) {
			X=x;
			Y=y;
		}
	}
	
	public XboxControllerSubsystem(XboxController xbc) {
		XBC = xbc;
		refresh();
	}

	private void leftStick() {
		LeftStick.X = XBC.getRawAxis(0);
		LeftStick.Y = XBC.getRawAxis(1);
	}
	private void rightStick() {
		RightStick.X = XBC.getRawAxis(4);
		RightStick.Y = XBC.getRawAxis(5);
	}
	
	public void refresh() {
		leftStick();
		rightStick();
	}
}
	


