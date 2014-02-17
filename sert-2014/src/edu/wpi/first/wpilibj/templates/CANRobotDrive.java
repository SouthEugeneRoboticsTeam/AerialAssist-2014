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
 * @author Aubrey Anderson
 * 
 * Extends the RobotDrive to implement the CANJaguar position control functionality
 */
public class CANRobotDrive extends RobotDrive {

    static CANJaguarMaster m_frontLeftMotor, m_frontRightMotor;
    static CANJaguar.ControlMode positionControl = CANJaguar.ControlMode.kPosition;
    
    public CANRobotDrive(CANJaguarMaster frontLeftMotor, CANJaguarMaster frontRightMotor) throws CANTimeoutException {
        super(frontLeftMotor, frontRightMotor);
        m_frontLeftMotor = frontLeftMotor;
        m_frontRightMotor = frontRightMotor;
    }
    
    //changes the Jaguar's control mode
    public void changeControlMode(CANJaguar.ControlMode mode) throws CANTimeoutException {
        m_frontLeftMotor.changeControlMode(mode);
        m_frontRightMotor.changeControlMode(mode);
    }
    
    //moves the drivetrain to the given postion
    public void moveToPosition(double position) throws CANTimeoutException {
        m_frontLeftMotor.setX(position);
        m_frontRightMotor.setX(-position);
        if (m_safetyHelper != null) m_safetyHelper.feed();
    }
    
    //returns the value of the position reference
    public double getPosition() throws CANTimeoutException {
        return m_frontRightMotor.getPosition();
    }
    
    //sets the position reference used for the closed loop control on the Jaguar
    public void setPositionReference(CANJaguar.PositionReference reference) throws CANTimeoutException {
        m_frontLeftMotor.setPositionReference(reference);
        m_frontRightMotor.setPositionReference(reference); 
    }
    
    //sets the number of encoder codes for the encoder connected to the Jaguar
    public void configEncoderCodesPerRev(int codesPerRev) throws CANTimeoutException{
        m_frontLeftMotor.configEncoderCodesPerRev(codesPerRev);
        m_frontRightMotor.configEncoderCodesPerRev(codesPerRev);
    }
    
    //sets the PID coeffiecents for the closed loop control on the Jaguar
    public void setPID(double p, double i, double d) throws CANTimeoutException {
        m_frontLeftMotor.setPID(p, i, d);
        m_frontRightMotor.setPID(p, i, d);
    }
    
    //enables the closed loop control on the Jaguar with the position at 0
    public void enableControl() throws CANTimeoutException {
        m_frontLeftMotor.enableControl();
        m_frontRightMotor.enableControl();
    }
    
    //enables the closed loop control on the Jaguar with the position at position
    public void enableControl(double position) throws CANTimeoutException {
        m_frontLeftMotor.enableControl(position);
        m_frontRightMotor.enableControl(position);
    }
    
    //disables the closed loop control on the Jaguar
    public void disableControl() throws CANTimeoutException {
        m_frontLeftMotor.disableControl();
        m_frontRightMotor.disableControl();
    }
    
    //gets the average output voltage of the drive motors
    public double getOutputVoltage() throws CANTimeoutException {
        return (m_frontLeftMotor.getOutputVoltage() + m_frontRightMotor.getOutputVoltage())/2;
    }
}
