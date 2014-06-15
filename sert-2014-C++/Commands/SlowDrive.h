#ifndef SLOW_DRIVE_H
#define SLOW_DRIVE_H

#include "CommandBase.h"

class SlowDrive : public CommandBase {
private:
    
protected:
	void Initialize();
	void Execute();
	bool IsFinished();
	void End();
	void Interrupted();

public:
	SlowDrive();

};

#endif
