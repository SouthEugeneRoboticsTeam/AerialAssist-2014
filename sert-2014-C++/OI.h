#ifndef OI_H
#define OI_H

#include "WPILib.h"
//#include "ChangeDriveMode.h"


class OI {
private:
    
    Joystick* leftDriveStick;
    Joystick* rightDriveStick;
    
    JoystickButton* leftChangeDriveMode;
    JoystickButton* rightChangeDriveMode;
    JoystickButton* slowMode;

	static OI* instance;
	
	void InitButtons(); 
    void TieButtons();
    

public:
	OI();

	static OI* GetInstance();
	Joystick* GetLeftDriveStick();
	Joystick* GetRightDriveStick();
	JoystickButton* GetLeftChangeDriveModeButton();
	JoystickButton* GetRightChangeDriveModeButton();
	JoystickButton* GetSlowModeButton();
};

#endif
