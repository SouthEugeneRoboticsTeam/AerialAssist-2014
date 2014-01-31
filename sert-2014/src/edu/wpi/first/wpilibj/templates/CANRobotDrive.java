/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.wpi.first.wpilibj.templates;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.communication.UsageReporting;

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
        m_frontLeftMotor.setPID(45, .01, .1);
        m_frontRightMotor.setPID(45, .01, .1);
        m_frontLeftMotor.changeControlMode(CANJaguar.ControlMode.kPercentVbus);
        m_frontRightMotor.changeControlMode(CANJaguar.ControlMode.kPercentVbus);
    }
    
    public void changeControlMode(CANJaguar.ControlMode mode) throws CANTimeoutException {
        m_frontLeftMotor.changeControlMode(mode);
        m_frontRightMotor.changeControlMode(mode);
    }
    
    public void moveToPosition(double position) throws CANTimeoutException {
        tankDrive(position, position);
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
    
    public void tankDrive(double leftValue, double rightValue, boolean squaredInputs) {
        
        if(!kTank_Reported){
            UsageReporting.report(UsageReporting.kResourceType_RobotDrive, getNumMotors(), UsageReporting.kRobotDrive_Tank);
            kTank_Reported = true;
        }

        // square the inputs (while preserving the sign) to increase fine control while permitting full power
        leftValue = limit(leftValue);
        rightValue = limit(rightValue);
        if(squaredInputs) {
            if (leftValue >= 0.0) {
                leftValue = (leftValue * leftValue);
            } else {
                leftValue = -(leftValue * leftValue);
            }
            if (rightValue >= 0.0) {
                rightValue = (rightValue * rightValue);
            } else {
                rightValue = -(rightValue * rightValue);
            }
        }
        setLeftRightMotorOutputs(leftValue, rightValue);
    }

    /**
     * Provide tank steering using the stored robot configuration.
     * This function lets you directly provide joystick values from any source.
     * @param leftValue The value of the left stick.
     * @param rightValue The value of the right stick.
     */
    public void tankDrive(double leftValue, double rightValue) {
        tankDrive(leftValue, rightValue, false);
    }
    
    protected static double limit(double num) {
        System.out.println("limiting");
        try {
            if (m_frontRightMotor.getControlMode() == positionControl) {
                return num;
            } else {
                if (num > 1.0) {
                    return 1.0;
                }
                if (num < -1.0) {
                    return -1.0;
                }
                return num;
            }
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        return 0;
    } 
}
