#ifndef PRESSURIZE_H
#define PRESSURIZE_H

#include "CommandBase.h"

class Pressurize : public CommandBase {
private:
    
protected:
	void Initialize();
	void Execute();
	bool IsFinished();
	void End();
	void Interrupted();

public:
	Pressurize();

};

#endif
