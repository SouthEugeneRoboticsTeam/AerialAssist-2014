/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.can.CANTimeoutException;

/**
 *
 * @author FIRST
 */
public class CANRobotDrive extends RobotDrive {

    CANJaguarMaster m_frontLeftMotor, m_frontRightMotor;
    
    public CANRobotDrive(CANJaguarMaster m_frontLeftMotor, CANJaguarMaster m_frontRightMotor) throws CANTimeoutException {
        super(m_frontLeftMotor, m_frontRightMotor);
        this.m_frontLeftMotor = m_frontLeftMotor;
        this.m_frontRightMotor = m_frontRightMotor;
        this.m_frontLeftMotor.configEncoderCodesPerRev(360);
        this.m_frontRightMotor.configEncoderCodesPerRev(360);
        this.m_frontLeftMotor.setSpeedReference(CANJaguar.SpeedReference.kQuadEncoder);
        this.m_frontRightMotor.setSpeedReference(CANJaguar.SpeedReference.kQuadEncoder);
    }
    
    public void changeControlMode(CANJaguar.ControlMode mode) throws CANTimeoutException {
        m_frontLeftMotor.changeControlMode(mode);
        m_frontRightMotor.changeControlMode(mode);
    }
    
    public void moveInches(double distance) throws CANTimeoutException {
        int codes = (int) (distance * 114.59155902616464175359630962821);
        m_frontLeftMotor.setX(codes);
        m_frontRightMotor.setX(codes);
    }
}
