#include "CommandBase.h"
#include "Commands/Scheduler.h"

CommandBase::CommandBase(const char *name) : Command(name) 
{
}

CommandBase::CommandBase() : Command() 
{
}

// Initialize a single static instance of all of your subsystems to NULL

OI* CommandBase::m_oi = NULL;

void CommandBase::init() 
{
    // Create a single static instance of all of your subsystems. The following
	// line should be repeated for each subsystem in the project.

	m_armSub = new ArmSubsystem();
    m_driveSub = new DriveSubsystem();
    m_oi = new OI();
}
