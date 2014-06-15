#include "Autonomous.h"
#include "CANJaguar.h"
#include "../RobotMap.h"

Autonomous::Autonomous()
{
	Requires( m_driveSub );
}

// Called just before this Command runs the first time
void Autonomous::Initialize()
{
}

// Called repeatedly when this Command is scheduled to run
void Autonomous::Execute() 
{
    if ( m_first ) 
    {
    	m_driveSub->ChangeControlMode( CANJaguar::kPosition );
        m_first = false;
    }
    m_driveSub->MoveDistance( AUTONOMOUS_DISTANCE );	
}

// Make this return true when this Command no longer needs to run execute()
bool Autonomous::IsFinished() 
{
	return false;
}

// Called once after isFinished returns true
void Autonomous::End() 
{
	m_driveSub->ChangeControlMode( CANJaguar::kVoltage );
}

// Called when another command which requires one or more of the same
// subsystems is scheduled to run
void Autonomous::Interrupted() 
{
}
