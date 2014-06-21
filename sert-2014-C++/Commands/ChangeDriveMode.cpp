#include "ChangeDriveMode.h"

/**
 *
 * @author FIRST
 */
   
ChangeDriveMode::ChangeDriveMode() 
{
	requires(driveSub);
}

// Called just before this Command runs the first time
void ChangeDriveMode::Initialize() 
{
}

// Called repeatedly when this Command is scheduled to run
void ChangeDriveMode::Execute() 
{
}

// Make this return true when this Command no longer needs to run execute()
bool ChangeDriveMode::IsFinished() 
{
	return true;
}

// Called once after isFinished returns true
void ChangeDriveMode::End() 
{
	m_driveSub->ChangeTeleoperatedDriveMode();
}

// Called when another command which requires one or more of the same
// subsystems is scheduled to run
void ChangeDriveMode::Interrupted() 
{
}

