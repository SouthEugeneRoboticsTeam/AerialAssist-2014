#ifndef CHANGEDRIVEMODE_H
#define CHANGEDRIVEMODE_H

#include "CommandBase.h"

class ChangeDriveMode : public CommandBase 
{
public:
    ChangeDriveMode();

protected:
    // Called just before this Command runs the first time
    void Initialize();

    // Called repeatedly when this Command is scheduled to run
    void Execute();

    // Make this return true when this Command no longer needs to run execute()
    bool IsFinished();

    // Called once after isFinished returns true
    void End();

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    void Interrupted();
};

#endif
