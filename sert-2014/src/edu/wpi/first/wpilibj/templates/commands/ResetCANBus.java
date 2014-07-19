/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.can.CANTimeoutException;

/**
 *
 * @author SERT
 */
public class ResetCANBus extends CommandBase {
    
    public ResetCANBus() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(driveSub);
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
        try {
            driveSub.resetCANBus();
        } catch (CANTimeoutException ex) {
//            ex.printStackTrace();
        }
    }
    

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}