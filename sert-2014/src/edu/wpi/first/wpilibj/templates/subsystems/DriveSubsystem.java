
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
    boolean isArcade = true;
    
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

    public void changeTeleoperatedDriveMode() {
        isArcade = !isArcade;
    }
   
    private void arcade(){
       drive.arcadeDrive(-OI.getInstance().getLeftDriveStick().getY(), -OI.getInstance().getLeftDriveStick().getX(), true);
    }
    
    private void tank() {
        drive.tankDrive(-OI.getInstance().getLeftDriveStick().getY(), -OI.getInstance().getRightDriveStick().getY(), true);
    }
    
    public void initDefaultCommand() {
        setDefaultCommand(new TeleoperatedDrive());
    }

}