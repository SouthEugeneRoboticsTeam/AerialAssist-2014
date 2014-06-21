#ifndef CHANGE_KICKER_POSITION_H
#define CHANGE_KICKER_POSITION_H

#include "CommandBase.h"

class ChangeKickerPosition : public CommandBase {
private:
    
protected:
	void Initialize();
	void Execute();
	bool IsFinished();
	void End();
	void Interrupted();

public:
	ChangeKickerPosition();

};

#endif
