package edu.wpi.first.wpilibj.templates;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static final int leftMotor = 1;
    // public static final int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static final int rangefinderPort = 1;
    // public static final int rangefinderModule = 1;
    
    public static final int LEFT_DRIVE_STICK_PORT = 1;
    public static final int RIGHT_DRIVE_STICK_PORT = 2;
    public static final int SHOOT_STICK_PORT = 3;
    public static final int LEFT_FRONT_DRIVE_JAG = 31;
    public static final int LEFT_REAR_DRIVE_JAG = 12;
    public static final int RIGHT_FRONT_DRIVE_JAG = 10;
    public static final int RIGHT_REAR_DRIVE_JAG = 32;
    public static final int INTAKE_JAG = 23;
    public static final int INTAKE_RAISE_CHANNEL = 1;
    public static final int INTAKE_LOWER_CHANNEL = 2;
    public static final int KICKER_RAISE_CHANNEL = 3;
    public static final int KICKER_LOWER_CHANNEL = 4;
    public static final int ONBOARD_COMPRESSOR_CHANNEL = 1;
    public static final int OFFBOARD_COMPRESSOR_CHANNEL = 2;
    public static final int PRESSURE_SWITCH_CHANNEL_1 = 1;
    public static final int PRESSURE_SWITCH_CHANNEL_2 = 2;
    public static final double AUTONOMOUS_DISTANCE = 175;
    public static final double K_P = 30;
    public static final double K_I = 0;
    public static final double K_D = 0;
}