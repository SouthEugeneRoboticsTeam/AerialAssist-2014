package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.templates.OI;
import edu.wpi.first.wpilibj.templates.subsystems.CompressorSubsystem;
import edu.wpi.first.wpilibj.templates.subsystems.IntakeSubsystem;
import edu.wpi.first.wpilibj.templates.subsystems.DriveSubsystem;
import edu.wpi.first.wpilibj.templates.subsystems.KickerSubsystem;
import edu.wpi.first.wpilibj.templates.subsystems.SensorSubsystem;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    public static DriveSubsystem driveSub;
    public static CompressorSubsystem compressor;
    public static SensorSubsystem sensors;
    public static IntakeSubsystem intakeSub;
    public static KickerSubsystem kickerSub;
    public static NetworkTable m_table;
    // Create a single static instance of all of your subsystems

    public static void init(NetworkTable table) {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        m_table = table;
        driveSub = new DriveSubsystem();
        compressor = new CompressorSubsystem();
        sensors = new SensorSubsystem(table);
        intakeSub = new IntakeSubsystem();
        kickerSub = new KickerSubsystem();
        oi = OI.getInstance();
        
        // Show what command your subsystem is running on the SmartDashboard
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
