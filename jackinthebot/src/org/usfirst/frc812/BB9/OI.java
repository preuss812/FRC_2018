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

import org.usfirst.frc812.BB9.commands.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public Joystick leftJoystick;
    public Joystick rightJoystick;
    
    public Button gearShiftButton;
    public Button cameraFrontBackButton;
    public Button controlboxPrintData;
    public Button raiseLowerBallGathererButton;
    public Button gathererMotorStart;
    
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        rightJoystick = new Joystick(1);
        leftJoystick = new Joystick(0);
        
        // control Box buttons
        controlboxPrintData = new JoystickButton(rightJoystick,2);
        
        // right joystick buttons
        cameraFrontBackButton = new JoystickButton(rightJoystick,1);
        
        
        // Left Joystick buttons 
        gearShiftButton            = new JoystickButton(leftJoystick,3);
        raiseLowerBallGathererButton = new JoystickButton(leftJoystick,2);
        gathererMotorStart = new JoystickButton(leftJoystick,4);
         
        cameraFrontBackButton.toggleWhenPressed(new CameraFrontBack());
        gearShiftButton.whenPressed(new ShiftGearsCommand());
        raiseLowerBallGathererButton.toggleWhenPressed(new BallGatherer());
        controlboxPrintData.whenPressed(new ControlBoxCommand());
        
        // SmartDashboard Buttons
        SmartDashboard.putData("test drive: STOP", new DriveWithJoysticks());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getLeftJoystick() {
        return leftJoystick;
    }

    public Joystick getRightJoystick() {
        return rightJoystick;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

