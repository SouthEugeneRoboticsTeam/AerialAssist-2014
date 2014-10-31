/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.templates.OI;

/**
 *
 * @author Aubrey
 */
public class IntakeControl extends CommandBase {
    
    public IntakeControl() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(intakeSub);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        try {
            //negative to reverse direction of control
            double speed = -OI.getInstance().getShootStick().getY();    
            intakeSub.intakeControl(speed);
        } catch (CANTimeoutException ex) {
//            ex.printStackTrace();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        try {
            intakeSub.stopIntake();
        } catch (CANTimeoutException ex) {
//            ex.printStackTrace();
        }
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
