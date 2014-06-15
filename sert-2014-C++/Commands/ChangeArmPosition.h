#ifndef CHANGE_ARM_POSITION_H
#define CHANGE_ARM_POSITION_H

#include "CommandBase.h"

class ChangeArmPosition : public CommandBase {
private:
    
protected:
	void Initialize();
	void Execute();
	bool IsFinished();
	void End();
	void Interrupted();

public:
	ChangeArmPosition();

};

#endif
