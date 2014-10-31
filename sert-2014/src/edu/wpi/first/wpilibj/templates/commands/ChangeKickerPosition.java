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
public class ChangeKickerPosition extends CommandBase {
    

    public ChangeKickerPosition() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(kickerSub);
        
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
        if (kickerSub.isUp()) {
            kickerSub.lowerKicker();
        } else {
            kickerSub.raiseKicker();
        }
    }
    
    protected void interrupted() {
    }
}
