#include "ArmSubsystem.h"

#include "../RobotMap.h"

ArmSubsystem::ArmSubsystem() :
b	Subsystem( "ArmSubsystem" )
{
	compressor = new Compressor(PRESSURE_SWITCH_CHANNEL, COMPRESSOR_CHANNEL);
	lifter = new DoubleSolenoid(SOLENOID_RAISE_CHANNEL, SOLENOID_LOWER_CHANNEL);
}

bool ArmSubsystem::IsUp() 
{
	return m_isUp;
}

void ArmSubsystem::RaiseArm() 
{
	lifter->Set( DoubleSolenoid::kForward );
	m_isUp = true;
}

void ArmSubsystem::LowerArm() 
{
	lifter->Set( DoubleSolenoid::kReverse );
	m_isUp = false;
}

void ArmSubsystem::ResetArmSolenoid() 
{
	lifter->Set( DoubleSolenoid::kOff );
}

void ArmSubsystem::StartCompressor() 
{
	compressor->Start();
} 
void ArmSubsystem::StopCompressor() 
{
	compressor->Stop();
}

void ArmSubsystem::InitDefaultCommand()
{
	//setDefaultCommand(new Pressurize());
}
