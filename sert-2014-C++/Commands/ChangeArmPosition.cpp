#include "ChangeArmPosition.h"
#include "Timer.h"

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
    
    // Using a timer is not ideal.
    // We need some type of limit switch input to tell us when we are done.
    
    Wait( 1 );
    
    m_armSub->ResetArmSolenoid();      //sets solenoid to off to prevent burning it out	
}

// Called when another command which requires one or more of the same
// subsystems is scheduled to run
void ChangeArmPosition::Interrupted() 
{
}

