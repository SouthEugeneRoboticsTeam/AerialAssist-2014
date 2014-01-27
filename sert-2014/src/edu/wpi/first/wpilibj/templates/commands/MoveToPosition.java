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
    boolean finish = false;
    
    public MoveToPosition(double position) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
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
            driveSub.moveToPosition(position);
            first = false;
            System.out.println(driveSub.getPosition());            
        }
        if (driveSub.getOutputVoltage() < 1) {
            finish = true;
        }
        
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return finish;
    }

    // Called once after isFinished returns true
    protected void end() {
        driveSub.disableControl();
        driveSub.changeControlMode(CANJaguar.ControlMode.kPercentVbus);
        first = true;
        finish = false;
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        finish = true;
    }
}
