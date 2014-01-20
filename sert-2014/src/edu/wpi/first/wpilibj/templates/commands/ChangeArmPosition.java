/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;

/**
 *
 * @author SERT
 */
public class ChangeArmPosition extends CommandBase {
    

    public ChangeArmPosition() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(armSub);
        
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
        if (armSub.isUp()) {
            armSub.lowerArm();
        } else {
            armSub.raiseArm();          
        }
        Timer.delay(.01);               //minimum time for Solenoid to switch positions
        armSub.resetArmSolenoid();      //sets solenoid to off to prevent burning it out
    }
    
    protected void interrupted() {
    }
}
