/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;

/**
 *
 * @author FIRST
 */
public class CANJaguarMaster extends CANJaguar {

    CANJaguar slave;
    
    public CANJaguarMaster(int deviceNumber, CANJaguar slave) throws CANTimeoutException {
        super(deviceNumber);
        this.slave = slave;
        slave.changeControlMode(ControlMode.kVoltage);
    }
    
    public void setX(double outputValue) {
        try {
            super.setX(outputValue);
            slave.setX(super.getOutputVoltage());
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
    
    public void set(double outputValue) {
        try {
            super.setX(outputValue);
            slave.setX(super.getOutputVoltage());
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
    
        public void setX(double outputValue, byte syncGroup) {
        try {
            super.setX(outputValue, syncGroup);
            slave.setX(super.getOutputVoltage(), syncGroup);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
    
    public void set(double outputValue, byte syncGroup) {
        try {
            super.setX(outputValue, syncGroup);
            slave.setX(super.getOutputVoltage(), syncGroup);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
}
