#ifndef TELEOPERATED_DRIVE_H
#define TELEOPERATED_DRIVE_H

#include "CommandBase.h"

class TeleoperatedDrive : public CommandBase {
private:
    
protected:
	void Initialize();
	void Execute();
	bool IsFinished();
	void End();
	void Interrupted();

public:
	TeleoperatedDrive();

};

#endif
