#include "ChangeArmPosition.h"

ChangeArmPosition::ChangeArmPosition()
{
	Requires( m_armSub );
}

// Called just before this Command runs the first time
void ChangeArmPosition::Initialize()
{
}

// Called repeatedly when this Command is scheduled to run
void ChangeArmPosition::Execute() 
{
}

// Make this return true when this Command no longer needs to run execute()
bool ChangeArmPosition::IsFinished() 
{
	return true;
}

// Called once after isFinished returns true
void ChangeArmPosition::End() 
{
    if ( m_armSub->IsUp() ) 
    {
    	m_armSub->LowerArm();
    } 
    else 
    {
    	m_armSub->RaiseArm();          
    }
}

// Called when another command which requires one or more of the same
// subsystems is scheduled to run
void ChangeArmPosition::Interrupted() 
{
}

