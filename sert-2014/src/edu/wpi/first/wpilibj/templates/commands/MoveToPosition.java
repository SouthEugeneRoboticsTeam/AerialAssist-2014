/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.CANJaguar;

/**
 *
 * @author Aubrey
 */
public class MoveToPosition extends CommandBase {
    double position;
    boolean first = true;
    
    public MoveToPosition(double position) {
        requires(driveSub);
        this.position = position;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        if (first) {
            driveSub.changeControlMode(CANJaguar.ControlMode.kPosition);
            driveSub.enableControl();
            first = false;
        } 
        driveSub.moveToPosition(position);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (Math.abs(driveSub.getPosition() - position)) < .05;
    }

    // Called once after isFinished returns true
    protected void end() {
        driveSub.disableControl();
        driveSub.changeControlMode(CANJaguar.ControlMode.kPercentVbus);
        first = true;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
