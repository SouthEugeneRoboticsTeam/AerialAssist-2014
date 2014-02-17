/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.can.CANTimeoutException;

/**
 *
 * @author SERT
 */
public class TriggerEject extends CommandBase {
    boolean first = true;
    
    public TriggerEject() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(intakeSub);
        requires(kickerSub);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (first) {
            if(intakeSub.isUp()) {
                intakeSub.lowerArm();
                Timer.delay(.01);               //minimum time for Solenoid to switch positions
                intakeSub.resetArmSolenoid();      //sets solenoid to off to prevent burning it out
            }
            
            first = false;
        }
            if (!kickerSub.isUp()) {
                kickerSub.raiseKicker();
                Timer.delay(.01);
                kickerSub.resetKickerSolenoid();
            }
        
        try {
            intakeSub.intakeControl(.75);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        first = true;
        try {
            intakeSub.stopIntake();
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        
        kickerSub.lowerKicker();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
