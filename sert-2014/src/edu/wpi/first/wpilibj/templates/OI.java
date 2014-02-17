package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.ChangeDriveMode;
import edu.wpi.first.wpilibj.templates.commands.ChangeArmPosition;
import edu.wpi.first.wpilibj.templates.commands.ChangeKickerPosition;
import edu.wpi.first.wpilibj.templates.commands.MoveToDistance;
import edu.wpi.first.wpilibj.templates.commands.MoveToPosition;
import edu.wpi.first.wpilibj.templates.commands.Pressurize;
import edu.wpi.first.wpilibj.templates.commands.SlowDrive;
import edu.wpi.first.wpilibj.templates.commands.SmartPing;
import edu.wpi.first.wpilibj.templates.commands.TriggerIntake;

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
    
    // Another type of button you can create is a DigitalIOButton, which is
    // a button or switch hooked up to the cypress module. These are useful if
    // you want to build a customized operator interface.
    // Button button = new DigitalIOButton(1);
    
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
    
    Joystick leftDriveStick;
    Joystick rightDriveStick;
    Joystick shootStick;
    
    Button leftChangeDriveMode;
    Button rightChangeDriveMode;
    Button rotationForward;
    Button rotationReverse;
    Button slowMode;
    Button changeArmPostion;
    Button changeKickerPosition;
    Button offboardCompressor;
    Button intake;
    Button updateSFX;
            
    public static OI instance;
    
    public OI() {
        leftDriveStick = new Joystick(RobotMap.LEFT_DRIVE_STICK_PORT);
        rightDriveStick = new Joystick(RobotMap.RIGHT_DRIVE_STICK_PORT);
        shootStick = new Joystick(RobotMap.SHOOT_STICK_PORT);
        initButtons();
    }
    
    public static OI getInstance() {
        if (instance == null) {
            instance = new OI();
        }
        
        return instance;
    }
    
    private void initButtons() {
        leftChangeDriveMode = new JoystickButton(leftDriveStick, 6);
        rightChangeDriveMode = new JoystickButton(rightDriveStick, 6);
        rotationForward = new JoystickButton(leftDriveStick, 8);
        rotationReverse = new JoystickButton(leftDriveStick, 9);
        slowMode = new JoystickButton(leftDriveStick, 7);
        changeArmPostion = new JoystickButton(shootStick, 3);
        changeKickerPosition = new JoystickButton(shootStick, 2);
        intake = new JoystickButton(leftDriveStick, 1);
       // offboardCompressor = new JoystickButton(leftDriveStick, 10);
        updateSFX = new JoystickButton(shootStick, 10);
        
        tieButtons();
    }
    
    private void tieButtons() {
        leftChangeDriveMode.whenPressed(new ChangeDriveMode());
        rightChangeDriveMode.whenPressed(new ChangeDriveMode());
        //Change amount each button drives
        rotationForward.whenPressed(new MoveToPosition(10));
        rotationReverse.whenPressed(new MoveToDistance(-20));
        slowMode.whenPressed(new SlowDrive());
        changeArmPostion.whenPressed(new ChangeArmPosition());
        changeKickerPosition.whenPressed(new ChangeKickerPosition());
        intake.whileHeld(new TriggerIntake());
        //offboardCompressor.whileHeld(new Pressurize(2));
        updateSFX.whenPressed(new SmartPing());
    }
    
    public Joystick getLeftDriveStick() {
        return leftDriveStick;
    }
    
    public Joystick getRightDriveStick() {
        return rightDriveStick;
    }
    public Joystick getShootStick() {
        return shootStick;
    }
}

