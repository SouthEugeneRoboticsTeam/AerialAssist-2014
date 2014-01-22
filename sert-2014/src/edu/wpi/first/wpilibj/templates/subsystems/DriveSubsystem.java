
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.DriverStationEnhancedIO;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.CANJaguarMaster;
import edu.wpi.first.wpilibj.templates.CANRobotDrive;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.SlowDrive;
import edu.wpi.first.wpilibj.templates.commands.TeleoperatedDrive;

/**
 *
 */
public class DriveSubsystem extends Subsystem {
    CANRobotDrive drive;
    private boolean isArcade = true;
    private boolean slowMode = false;
    
    public DriveSubsystem() {
        try{
           drive = new CANRobotDrive(new CANJaguarMaster(RobotMap.LEFT_FRONT_DRIVE_JAG, new CANJaguar(RobotMap.LEFT_REAR_DRIVE_JAG)), new CANJaguarMaster(RobotMap.RIGHT_FRONT_DRIVE_JAG, new CANJaguar(RobotMap.RIGHT_REAR_JAG_DRIVE)));
        } catch (Exception ex) {
             ex.printStackTrace();
        }
    }

    public void teleoperatedDrive() {
        if (isArcade) {
            arcade();
        } else {
            tank();
        }
        printEncoders();
    }
    
    public void changeControlMode(CANJaguar.ControlMode mode) {
        try {
            drive.changeControlMode(mode);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
    
    public void moveDistance(double inches) {
        try {
            drive.moveInches(inches);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }
    
    public void printEncoders() {
        try {
            DriverStationLCD.getInstance().println(DriverStationLCD.Line.kUser1, 1, String.valueOf(drive.getEncoders()));
            DriverStationLCD.getInstance().updateLCD();
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
    }

    public void changeTeleoperatedDriveMode() {
        isArcade = !isArcade;
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
        slowMode = true;
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new TeleoperatedDrive());
    }

}