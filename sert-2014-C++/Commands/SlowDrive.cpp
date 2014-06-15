#include "SlowDrive.h"

SlowDrive::SlowDrive()
{
	Requires( m_driveSub );
}

// Called just before this Command runs the first time
void SlowDrive::Initialize()
{
}

// Called repeatedly when this Command is scheduled to run
void SlowDrive::Execute() 
{
}

// Make this return true when this Command no longer needs to run execute()
bool SlowDrive::IsFinished() 
{
	return true;
}

// Called once after isFinished returns true
void SlowDrive::End() 
{
	m_driveSub->SlowMode();
}

// Called when another command which requires one or more of the same
// subsystems is scheduled to run
void SlowDrive::Interrupted() 
{
}
