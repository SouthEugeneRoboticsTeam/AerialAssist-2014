#ifndef ROBOTMAP_H
#define ROBOTMAP_H


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
 
// For example to map the left and right motors, you could define the
// following variables to use with your drivetrain subsystem.
// #define LEFTMOTOR 1
// #define RIGHTMOTOR 2

// If you are using multiple modules, make sure to define both the port
// number and the module. For example you with a rangefinder:
// #define RANGE_FINDER_PORT 1
// #define RANGE_FINDER_MODULE 1

static const UINT8 LEFT_DRIVE_STICK_PORT = 1;
static const UINT8 RIGHT_DRIVE_STICK_PORT = 2;
static const UINT8 LEFT_FRONT_DRIVE_JAG = 31;
static const UINT8 LEFT_REAR_DRIVE_JAG = 20;
static const UINT8 RIGHT_FRONT_DRIVE_JAG = 10;
static const UINT8 RIGHT_REAR_JAG_DRIVE = 32;
static const UINT8 SOLENOID_RAISE_CHANNEL = 1;
static const UINT8 SOLENOID_LOWER_CHANNEL = 2;
static const UINT8 COMPRESSOR_CHANNEL = 1;
static const UINT8 PRESSURE_SWITCH_CHANNEL = 1;
static const float AUTONOMOUS_DISTANCE = 187;

#endif
