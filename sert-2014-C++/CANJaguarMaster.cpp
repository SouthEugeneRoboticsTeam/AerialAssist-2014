#include "CANJaguarMaster.h"
#include "stdio.h"
#include <iostream>

CANJaguarMaster::CANJaguarMaster(int deviceNumber, CANJaguar* slave) :
	CANJaguar( deviceNumber ) 
{
	m_slave = slave;
}

void CANJaguarMaster::SetX(double outputValue) 
{
	try 
	{
		CANJaguar::Set( outputValue );
		CANJaguar::Set( this->GetOutputVoltage() );
	} 
	catch ( int ex ) 
	{
		std::cerr << "An exception occurred. Exception Nr. " << ex << '\n';
	}
}

void CANJaguarMaster::Set(double outputValue) 
{
	try 
	{
		CANJaguar::Set( outputValue );
		m_slave->Set( this->GetOutputVoltage() );
	} 
	catch ( int ex ) 
	{
		std::cerr << "An exception occurred. Exception Nr. " << ex << '\n';
	}
}

void CANJaguarMaster::SetX( double outputValue, uint8_t syncGroup ) 
{
	try 
	{
		CANJaguar::Set( outputValue, syncGroup );
		m_slave->Set( this->GetOutputVoltage(), syncGroup );
	} 
	catch ( int ex )  
	{
		std::cerr << "An exception occurred. Exception Nr. " << ex << '\n';
	}
}

void CANJaguarMaster::Set( double outputValue, uint8_t syncGroup ) 
{
	try 
	{
		CANJaguar::Set( outputValue, syncGroup );
		m_slave->Set( this->GetOutputVoltage(), syncGroup );
	} 
	catch ( int ex ) 
	{
		std::cerr << "An exception occurred. Exception Nr. " << ex << '\n';
	}
}
