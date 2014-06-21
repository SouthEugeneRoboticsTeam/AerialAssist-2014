#ifndef ARM_SUBSYSTEM_H
#define ARM_SUBSYSTEM_H

#include "Commands/Subsystem.h"
#include "WPILib.h"

/**
 *
 *
 * @author ExampleAuthor
 */
class ArmSubsystem: public Subsystem {
private:
	// It's desirable that everything possible under private except
	// for methods that implement subsystem capabilities
	
    DoubleSolenoid* lifter;

    bool m_isUp;
        
        
public:
	ArmSubsystem();
	bool IsUp();
	void RaiseArm();
	void LowerArm();
	void ResetArmSolenoid();
	void InitDefaultCommand();
};

#endif
