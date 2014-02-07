
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.CANJaguarMaster;
import edu.wpi.first.wpilibj.templates.CANRobotDrive;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.TeleoperatedDrive;

/**
 *
 */
public class DriveSubsystem extends Subsystem {
    CANRobotDrive drive;
    CANJaguarMaster rightSide;
    private boolean isArcade = true;
    private boolean slowMode = false;
    
    public DriveSubsystem() {
        try{
           drive = new CANRobotDrive(new CANJaguarMaster(RobotMap.LEFT_FRONT_DRIVE_JAG, new CANJaguar(RobotMap.LEFT_REAR_DRIVE_JAG, CANJaguar.ControlMode.kVoltage)), new CANJaguarMaster(RobotMap.RIGHT_FRONT_DRIVE_JAG, new CANJaguar(RobotMap.RIGHT_REAR_DRIVE_JAG, CANJaguar.ControlMode.kVoltage)));
        } catch (CANTimeoutException ex) {
             ex.printStackTrace();
        }
    }

    public void teleoperatedDrive() {
        if (isArcade) {
            arcade();
        } else {
            tank();
        }
    }
    
    public void changeControlMode(CANJaguar.ControlMode mode) {
        try {
            drive.changeControlMode(mode);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
    
    public void moveToPosition(double position) {
        try {
            drive.moveToPosition(position);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }


    }
    
    public void enableControl() {
        try {
            drive.enableControl();
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
    
    public void enableControl(double position) {
        try {
            drive.enableControl(position);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
    
    public void disableControl() {
        try {
            drive.disableControl();
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
    
    public double getPosition() {
        try {
            return drive.getPosition();
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    public void changeTeleoperatedDriveMode() {
        isArcade = !isArcade;
    }
    
    public double getOutputVoltage() {
        try {
            return drive.getOutputVoltage();
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        return 0;
    }
   
    private void arcade(){
        if (slowMode) {
            drive.arcadeDrive(-OI.getInstance().getLeftDriveStick().getY()*.3, -OI.getInstance().getLeftDriveStick().getX()*.3, true);
        } else {
            drive.arcadeDrive(-OI.getInstance().getLeftDriveStick().getY(), -OI.getInstance().getLeftDriveStick().getX(), true);
        }
    }
    
    private void tank() {
        if (slowMode) {
            drive.tankDrive(-OI.getInstance().getLeftDriveStick().getY()*.3, -OI.getInstance().getRightDriveStick().getY()*.3, true);
        } else {
            drive.tankDrive(-OI.getInstance().getLeftDriveStick().getY(), -OI.getInstance().getRightDriveStick().getY(), true);
        }
    }
    
    public void slowMode() {
        slowMode = !slowMode;
    }
    
    public void initDefaultCommand() {
       setDefaultCommand(new TeleoperatedDrive());
    }

}
