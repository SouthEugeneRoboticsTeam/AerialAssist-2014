/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *
 * @author Aubrey
 */
public class SensorSubsystem extends Subsystem {
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
    //NetworkTable table;
    
    public SensorSubsystem() {
        //table = NetworkTable.getTable("SmartDashboard");
    }
    
    public int getBlobCount() {
        //TODO make sure this is the right key name
        //return (int) table.getNumber("BLOB_COUNT", 2);
        return 0;
    }
    
    public double getDistance() {
        //TODO add code to return the distance from the Ultrasonic sensor.
        return 0;
    }
    

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
