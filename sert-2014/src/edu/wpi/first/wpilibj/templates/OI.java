package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.templates.commands.ChangeDriveMode;
import edu.wpi.first.wpilibj.templates.commands.ChangeArmPosition;
import edu.wpi.first.wpilibj.templates.commands.ChangeKickerPosition;
import edu.wpi.first.wpilibj.templates.commands.MoveToDistance;
import edu.wpi.first.wpilibj.templates.commands.PrintDistance;
import edu.wpi.first.wpilibj.templates.commands.ResetAutonomous;
import edu.wpi.first.wpilibj.templates.commands.ResetCANBus;
import edu.wpi.first.wpilibj.templates.commands.Score;
import edu.wpi.first.wpilibj.templates.commands.SlowDrive;
import edu.wpi.first.wpilibj.templates.commands.TriggerEject;
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
    Button shooterChangeArmPostion;
    Button shooterChangeKickerPosition;
    Button driverChangeArmPostion;
    Button driverChangeKickerPosition;
    Button offboardCompressor;
    Button intake;
    Button eject;
    Button score;
    Button autonomousReset;
    Button printDistance;
    Button updateSFX;
    Button moveForward;
    Button resetCANBus;
            
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
        //leftChangeDriveMode = new JoystickButton(leftDriveStick, 6);
        //rightChangeDriveMode = new JoystickButton(rightDriveStick, 6);
        rotationForward = new JoystickButton(leftDriveStick, 8);
        rotationReverse = new JoystickButton(leftDriveStick, 9);
        slowMode = new JoystickButton(leftDriveStick, 7);
        //shooterChangeArmPostion = new JoystickButton(shootStick, 3);
        shooterChangeKickerPosition = new JoystickButton(shootStick, 6);
        //driverChangeArmPostion = new JoystickButton(leftDriveStick, 3);
        //driverChangeKickerPosition = new JoystickButton(leftDriveStick, 2);
        intake = new JoystickButton(leftDriveStick, 1);
        eject = new JoystickButton(shootStick, 1);
        autonomousReset = new JoystickButton(shootStick, 10);
        printDistance = new JoystickButton(leftDriveStick, 10);
        //moveForward = new JoystickButton(leftDriveStick,7);
        //score = new JoystickButton(leftDriveStick, 5);
       //offboardCompressor = new JoystickButton(leftDriveStick, 10);
       //updateSFX = new JoystickButton(shootStick, 10);
        resetCANBus = new JoystickButton(shootStick, 7);
        
        tieButtons();
    }
    
    private void tieButtons() {
        //leftChangeDriveMode.whenPressed(new ChangeDriveMode());
        //rightChangeDriveMode.whenPressed(new ChangeDriveMode());
        //Change amount each button drives
        //rotationForward.whenPressed(new MoveToDistance(20));
        //rotationReverse.whenPressed(new MoveToDistance(-RobotMap.AUTONOMOUS_DISTANCE));
        //moveForward.whenPressed(new MoveToDistance(181));
        slowMode.whenPressed(new SlowDrive());
        //shooterChangeArmPostion.whenPressed(new ChangeArmPosition());
        shooterChangeKickerPosition.whenPressed(new ChangeKickerPosition());
        //driverChangeArmPostion.whenPressed(new ChangeArmPosition());
        //driverChangeKickerPosition.whenPressed(new ChangeKickerPosition());
        intake.whileHeld(new TriggerIntake());
        eject.whileHeld(new TriggerEject());
        autonomousReset.whenPressed(new ResetAutonomous());
        printDistance.whenPressed(new PrintDistance());
        //score.whenPressed(new Score());
        //updateSFX.whenPressed(new SmartPing());
        resetCANBus.whenPressed(new ResetCANBus());
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

