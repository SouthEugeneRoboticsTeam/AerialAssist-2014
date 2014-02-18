/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.templates.commands.Autonomous;
import edu.wpi.first.wpilibj.templates.commands.AutonomousHotSecond;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends IterativeRobot {
    NetworkTable table;
    CommandGroup autonomous;
    CommandGroup autonomousHotSecond;

    boolean targeted;
    double autoStartTime;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        
        
        // Initialize all subsystems
        table = NetworkTable.getTable("SDash");
        CommandBase.init(table);
        
        autonomous = new Autonomous();
    }

    public void autonomousInit() {
        targeted = false;
        autoStartTime = Timer.getFPGATimestamp();
        System.out.println(table.getNumber("DISTANCE", 0));
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        int blobCount = (int) table.getNumber("BLOB_COUNT");
        
        if ((autoStartTime + 6) < Timer.getFPGATimestamp()) {
            blobCount = 2;
        }
        
        if (!targeted) {
            switch (blobCount) {
                case 1:
                    break;
                case 2:
                    targeted = true;
                    autonomous.start();
                    break;
            }
        }
        
        
        
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
	// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        autonomous.cancel();
        
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
