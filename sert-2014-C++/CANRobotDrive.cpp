#include "CANRobotDrive.h"

CANRobotDrive::CANRobotDrive(CANJaguarMaster* frontLeftMotor, CANJaguarMaster* frontRightMotor) : 
	RobotDrive( frontLeftMotor, frontRightMotor )
{
	m_frontLeftMotor = frontLeftMotor;
	m_frontRightMotor = frontRightMotor;
	m_frontLeftMotor->ConfigEncoderCodesPerRev( 360 );
	m_frontRightMotor->ConfigEncoderCodesPerRev( 360 );
	m_frontLeftMotor->SetSpeedReference( CANJaguar::kSpeedRef_QuadEncoder );
	m_frontRightMotor->SetSpeedReference( CANJaguar::kSpeedRef_QuadEncoder );
}

void CANRobotDrive::ChangeControlMode( CANJaguar::ControlMode mode )
{
	m_frontLeftMotor->ChangeControlMode( mode );
	m_frontRightMotor->ChangeControlMode( mode );
}

void CANRobotDrive::MoveInches( double distance )
{
	int codes = (int) ( distance * 114.59155902616464175359630962821 );
	m_frontLeftMotor->SetX( codes );
	m_frontRightMotor->SetX( codes );
}

double CANRobotDrive::GetEncoders()
{
	return m_frontRightMotor->GetPosition();
}
