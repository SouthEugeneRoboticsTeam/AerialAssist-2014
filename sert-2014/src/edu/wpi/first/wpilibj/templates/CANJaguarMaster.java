/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

import com.sun.squawk.GC;
import edu.wpi.first.wpilibj.templates.CANJaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.templates.subsystems.DriveSubsystem.*;

/**
 *
 * @author Aubrey Anderson
 * 
 * Extends CANJaguar such that one CANJagaurMaster object can control 2 physical Jaguars
 */
public class CANJaguarMaster extends CANJaguar {

    CANJaguar m_slave;
    CANJaguar.ControlMode currentMode = CANJaguar.ControlMode.kPercentVbus;
    int counter = 1;
    
    public CANJaguarMaster(int deviceNumber, CANJaguar slave) throws CANTimeoutException {
        super(deviceNumber);
        m_slave = slave;
    }
    
    //The following methods set the master to the given value
    //The slave copies by fetching the output voltage from the faster and setting that as its output
    
    public void setX(double outputValue) {
        System.out.println("Master:setX: " + outputValue);
        setX(outputValue, (byte) 0);
    }
    
    public void set(double outputValue) {
        System.out.println("Master:set1: " + outputValue);
        setX(outputValue, (byte) 0);
    }
    
    public void setX(double outputValue, byte syncGroup) {
//        try {
//            super.setX(outputValue, syncGroup);
//            m_slave.setX(super.getOutputVoltage(), syncGroup);
//        } catch (CANTimeoutException ex) {
//            ex.printStackTrace();
//        }
        try {
            
            if (currentMode == CANJaguar.ControlMode.kPercentVbus) {
                if (++counter == 2) {
                    try {
                        super.setX(outputValue, syncGroup);
                        m_slave.setX(outputValue, syncGroup);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    
                    counter = 0;     
                }
            } else {
               super.setX(outputValue, syncGroup);
               System.out.println("Master:SetXimpl: " + outputValue + "votls: " + super.getOutputVoltage());
               m_slave.setX(super.getOutputVoltage(), syncGroup);
                
            }
        } catch (Exception ex) {
            //CommandBase.driveSub = new DriveSubsystem();
            ex.printStackTrace();
        }
    }
    
    public void set(double outputValue, byte syncGroup) {
        System.out.println("Master:set: " + outputValue);
        setX(outputValue, syncGroup);
    }
    
    public void changeControlMode(CANJaguar.ControlMode mode) throws CANTimeoutException {
        currentMode = mode;
        super.changeControlMode(mode);
        if (mode == CANJaguar.ControlMode.kPercentVbus) {
            m_slave.changeControlMode(mode);
        } else {
            m_slave.changeControlMode(CANJaguar.ControlMode.kVoltage);
        }
    }
    
    public void setVoltageRampRate(double rampRate) throws CANTimeoutException {
        super.setVoltageRampRate(rampRate);
        m_slave.setVoltageRampRate(rampRate);
    }
}
