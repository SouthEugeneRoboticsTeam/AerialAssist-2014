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
    NetworkTable m_table;
    
    public SensorSubsystem(NetworkTable table) {
        m_table = table;
    }
    
    public int getBlobCount() {
        //TODO make sure this is the right key name
        return (int) m_table.getNumber("BLOB_COUNT", -1);
    }
    
    public double getDistance() {
        return m_table.getNumber("DISTANCE");

    }
    

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
