#ifndef AUTONOMOUS_H
#define AUTONOMOUS_H

#include "CommandBase.h"

class Autonomous : public CommandBase {
private:
    bool m_first;
    
protected:
	void Initialize();
	void Execute();
	bool IsFinished();
	void End();
	void Interrupted();

public:
	Autonomous();

};

#endif
