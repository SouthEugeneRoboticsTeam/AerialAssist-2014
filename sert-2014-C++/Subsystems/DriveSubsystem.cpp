// swapping ostringstream objects
#include <string>       // std::string
#include <iostream>     // std::cout
#include <sstream>      // std::stringstream

#include "DriveSubsystem.h"
#include "../RobotMap.h"
#include "../OI.h"
#include "../Commands/TeleoperatedDrive.h"

DriveSubsystem::DriveSubsystem() :
	Subsystem( "DriveSubsystem" )
{
	try
	{
	   m_drive = new CANRobotDrive( new CANJaguarMaster( LEFT_FRONT_DRIVE_JAG, new CANJaguar(LEFT_REAR_DRIVE_JAG)), new CANJaguarMaster(RIGHT_FRONT_DRIVE_JAG, new CANJaguar(RIGHT_REAR_JAG_DRIVE)));
	} 
	catch ( int ex ) 
	{
		std::cerr << "An exception occurred. Exception Nr. " << ex << '\n';
	}
}

void DriveSubsystem::SetTeleoperatedDrive() 
{
	if ( m_isArcade ) 
	{
		Arcade();
	} 
	else 
	{
		Tank();
	}
	PrintEncoders();
}

void DriveSubsystem::ChangeControlMode( CANJaguar::ControlMode mode ) 
{
	try 
	{
		m_drive->ChangeControlMode( mode );
	} 
	catch ( int ex ) 
	{
		std::cerr << "An exception occurred. Exception Nr. " << ex << '\n';
	}
}

void DriveSubsystem::MoveDistance( double inches ) 
{
	try 
	{
		m_drive->MoveInches( inches );
	} 
	catch ( int ex ) 
	{
		std::cerr << "An exception occurred. Exception Nr. " << ex << '\n';
	}
}

string int2str(int inp) { stringstream str; str << inp; return str.str(); }
string double2str(double in) { stringstream str; str << in; return str.str(); }

void DriveSubsystem::PrintEncoders() 
{
	try 
	{
		DriverStationLCD::GetInstance()->PrintfLine( DriverStationLCD::kUser_Line1, double2str( m_drive->GetEncoders() ).c_str() );
		DriverStationLCD::GetInstance()->UpdateLCD();
	} 
	catch ( int ex ) 
	{
		std::cerr << "An exception occurred. Exception Nr. " << ex << '\n';
	}
}

void DriveSubsystem::ChangeTeleoperatedDriveMode() 
{
	m_isArcade = !m_isArcade;
}

void DriveSubsystem::Arcade()
{
	if ( m_slowMode ) 
	{
		m_drive->ArcadeDrive(-OI::GetInstance()->GetLeftDriveStick()->GetY()*.3, -OI::GetInstance()->GetLeftDriveStick()->GetX()*.3, true);
	} 
	else 
	{
		m_drive->ArcadeDrive(-OI::GetInstance()->GetLeftDriveStick()->GetY(), -OI::GetInstance()->GetLeftDriveStick()->GetX(), true);
	}
}

void DriveSubsystem::Tank() 
{
	if ( m_slowMode ) 
	{
		m_drive->TankDrive(-OI::GetInstance()->GetLeftDriveStick()->GetY()*.3, -OI::GetInstance()->GetRightDriveStick()->GetY()*.3, true);
	} 
	else 
	{
		m_drive->TankDrive(-OI::GetInstance()->GetLeftDriveStick()->GetY(), -OI::GetInstance()->GetRightDriveStick()->GetY(), true);
	}
}

void DriveSubsystem::SlowMode() 
{
	m_slowMode = true;
}

void DriveSubsystem::InitDefaultCommand() 
{
	SetDefaultCommand( new TeleoperatedDrive() );
}
