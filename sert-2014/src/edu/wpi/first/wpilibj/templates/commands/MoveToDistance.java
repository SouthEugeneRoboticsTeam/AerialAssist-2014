/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.templates.CANJaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;

/**
 *
 * @author Aubrey
 */
public class MoveToDistance extends CommandBase {
    double position;
    boolean first = true;

    //moves to the given distance in inches
    public MoveToDistance(double distance) {
        requires(driveSub);
        this.position = distance /(4 * Math.PI);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        //System.out.println("In Execute");
        if (first) {
            System.out.println("In First Execute");
            try {
                driveSub.resetCANBus();
            } catch (CANTimeoutException ex) {
                ex.printStackTrace();
            }
            //driveSub.changeControlMode(CANJaguar.ControlMode.kPercentVbus);
            driveSub.changeControlMode(CANJaguar.ControlMode.kPosition);
            driveSub.enableControl();
            first = false;
            //DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser1, 1, "execute 1st pass." );
        } 
        // System.out.println("about to move");
        driveSub.moveToPosition(position);
        //driveSub.setX(.525);
        // System.out.println("finished sending moveToPosition");
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
        DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser1, 1, "Move to distance interrupted." );
        end();
    }
}
