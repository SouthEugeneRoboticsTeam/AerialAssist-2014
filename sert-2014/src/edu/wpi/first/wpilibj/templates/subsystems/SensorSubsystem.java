/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.networktables2.type.NumberArray;


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
        //return (int) table.getNumber("BLOB_COUNT", 2);
        return 0;
    }
    
    public double getDistance() {       
        NumberArray blobs = (NumberArray) m_table.getValue("BLOB_TRACKING");
        double y_PixelDistance = Math.abs(((NumberArray) (blobs)).get(5) - ((NumberArray) (blobs)).get(2));
        double angularDist = 50.25 * y_PixelDistance / 480;
        double distance = .75*((11 / Math.tan(angularDist)) + (Math.sqrt(121 - 4920 * Math.tan(angularDist) * Math.tan(angularDist)) / Math.tan(angularDist)));
        return distance;
    }
    

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}
