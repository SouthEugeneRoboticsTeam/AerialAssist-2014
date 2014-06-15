#include "Pressurize.h"

Pressurize::Pressurize()
{
	Requires( m_armSub );
}

// Called just before this Command runs the first time
void Pressurize::Initialize()
{
	m_armSub->StartCompressor();
}

// Called repeatedly when this Command is scheduled to run
void Pressurize::Execute() 
{
}

// Make this return true when this Command no longer needs to run execute()
bool Pressurize::IsFinished() 
{
	return false;
}

// Called once after isFinished returns true
void Pressurize::End() 
{
}

// Called when another command which requires one or more of the same
// subsystems is scheduled to run
void Pressurize::Interrupted() 
{
}
