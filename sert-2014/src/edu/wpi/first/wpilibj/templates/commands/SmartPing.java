/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 * @author SERT
 */
public class SmartPing extends CommandBase {
    NetworkTable table;
    public SmartPing() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
        table = NetworkTable.getTable("SDash");
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        table.putNumber("o", table.getNumber("o")+1);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
