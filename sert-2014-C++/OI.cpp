#include "OI.h"
#include "Robotmap.h"
#include "Commands/ChangeDriveMode.h"
#include "Commands/SlowDrive.h"

OI::OI()
{
    leftDriveStick = new Joystick(LEFT_DRIVE_STICK_PORT);
    rightDriveStick = new Joystick(RIGHT_DRIVE_STICK_PORT);
    InitButtons();
}

OI* OI::GetInstance() 
{
    if (instance == 0) 
    {
        instance = new OI();
    }
    
    return instance;
}
void OI::InitButtons() 
{
	leftChangeDriveMode = new JoystickButton(leftDriveStick, 1);
	rightChangeDriveMode = new JoystickButton(rightDriveStick, 1);
	slowMode = new JoystickButton(leftDriveStick, 7);
	TieButtons();
}

void OI::TieButtons() 
{
    leftChangeDriveMode->WhenPressed(new ChangeDriveMode());
    rightChangeDriveMode->WhenPressed(new ChangeDriveMode());
    slowMode->WhenPressed(new SlowDrive());
}

Joystick* OI::GetLeftDriveStick() 
{
    return leftDriveStick;
}

Joystick* OI::GetRightDriveStick() 
{
    return rightDriveStick;
}

JoystickButton* OI::GetLeftChangeDriveModeButton()
{
    return leftChangeDriveMode;
}
JoystickButton* OI::GetRightChangeDriveModeButton()
{
    return rightChangeDriveMode;
}
JoystickButton* OI::GetSlowModeButton()
{
    return slowMode;
}

