/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.can.CANTimeoutException;

/**
 *
 * @author FIRST
 */
public class CANRobotDrive extends RobotDrive {

    static CANJaguarMaster m_frontLeftMotor, m_frontRightMotor;
    static CANJaguar.ControlMode positionControl = CANJaguar.ControlMode.kPosition;
    
    public CANRobotDrive(CANJaguarMaster frontLeftMotor, CANJaguarMaster frontRightMotor) throws CANTimeoutException {
        super(frontLeftMotor, frontRightMotor);
        m_frontLeftMotor = frontLeftMotor;
        m_frontRightMotor = frontRightMotor;
        m_frontLeftMotor.changeControlMode(CANJaguar.ControlMode.kPosition);
        m_frontRightMotor.changeControlMode(CANJaguar.ControlMode.kPosition);
        m_frontLeftMotor.configEncoderCodesPerRev(360);
        m_frontRightMotor.configEncoderCodesPerRev(360);
        m_frontLeftMotor.setPositionReference(CANJaguar.PositionReference.kQuadEncoder);
        m_frontRightMotor.setPositionReference(CANJaguar.PositionReference.kQuadEncoder);
        m_frontLeftMotor.setPID(55, .005, .002);
        m_frontRightMotor.setPID(55, .005, .002);
        m_frontLeftMotor.changeControlMode(CANJaguar.ControlMode.kPercentVbus);
        m_frontRightMotor.changeControlMode(CANJaguar.ControlMode.kPercentVbus);
    }
    
    public void changeControlMode(CANJaguar.ControlMode mode) throws CANTimeoutException {
        m_frontLeftMotor.changeControlMode(mode);
        m_frontRightMotor.changeControlMode(mode);
    }
    
    public void moveToPosition(double position) throws CANTimeoutException {
        m_frontLeftMotor.setX(-position);
        m_frontRightMotor.setX(position);
        if (m_safetyHelper != null) m_safetyHelper.feed();
    }
    
    public double getPosition() throws CANTimeoutException {
        return m_frontRightMotor.getPosition();
    }
    
    public void enableControl() throws CANTimeoutException {
        m_frontLeftMotor.enableControl();
        m_frontRightMotor.enableControl();
    }
    
    public void enableControl(double position) throws CANTimeoutException {
        m_frontLeftMotor.enableControl(position);
        m_frontRightMotor.enableControl(position);
    }
    
    public void disableControl() throws CANTimeoutException {
        m_frontLeftMotor.disableControl();
        m_frontRightMotor.disableControl();
    }
    
    public double getOutputVoltage() throws CANTimeoutException {
        return (m_frontLeftMotor.getOutputVoltage() + m_frontRightMotor.getOutputVoltage())/2;
    }
}
