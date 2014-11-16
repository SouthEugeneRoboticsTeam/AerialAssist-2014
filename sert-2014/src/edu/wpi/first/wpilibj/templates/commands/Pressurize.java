/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

/**
 *
 * @author SERT
 */
public class Pressurize extends CommandBase {
    
    int compressorChannel;
    
    public Pressurize(int compressorChannel) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
        requires(compressor);
        this.compressorChannel = compressorChannel;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
       
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        switch (compressorChannel) {
            case 1:
                compressor.startOnboardCompressor();
                break;
            case 2:
                compressor.startOffboardCompressor();
                break;
        }
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
        compressor.stopOffboardCompressor();
        
        // I wonder if it is an oversight to not stop the onboard compressor
        // should we:
        //compressor.stopOnboardCompressor();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
