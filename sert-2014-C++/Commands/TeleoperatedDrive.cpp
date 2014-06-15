#include "TeleoperatedDrive.h"

TeleoperatedDrive::TeleoperatedDrive()
{
	Requires( m_driveSub );
}

// Called just before this Command runs the first time
void TeleoperatedDrive::Initialize()
{
}

// Called repeatedly when this Command is scheduled to run
void TeleoperatedDrive::Execute() 
{
	m_driveSub->SetTeleoperatedDrive();
}

// Make this return true when this Command no longer needs to run execute()
bool TeleoperatedDrive::IsFinished() 
{
	return false;
}

// Called once after isFinished returns true
void TeleoperatedDrive::End() 
{
}

// Called when another command which requires one or more of the same
// subsystems is scheduled to run
void TeleoperatedDrive::Interrupted() 
{
}
