#ifndef DRIVE_SUBSYSTEM_H
#define DRIVE_SUBSYSTEM_H
#include "Commands/Subsystem.h"
#include "WPILib.h"
#include "../CANRobotDrive.h"

#include "../CANJaguarMaster.h"
#include "CANJaguar.h"

/**
 *
 *
 * @author ExampleAuthor
 */
class DriveSubsystem: public Subsystem {
private:
	// It's desirable that everything possible under private except
	// for methods that implement subsystem capabilities
	CANRobotDrive* m_drive; // = new CANRobotDrive();
	bool m_isArcade;
	bool m_slowMode;
	
public:
	DriveSubsystem();
	void InitDefaultCommand();
	
	void SetTeleoperatedDrive();
	void ChangeControlMode(CANJaguar::ControlMode mode);
	void MoveDistance(double inches);
	void PrintEncoders();
	void ChangeTeleoperatedDriveMode();
 	void SlowMode();
	
private:
 	void Arcade();	
 	void Tank();
};

#endif
