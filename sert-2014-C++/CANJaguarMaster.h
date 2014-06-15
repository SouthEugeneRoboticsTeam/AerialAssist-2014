#ifndef CAN_JAGUAR_MASTER_H
#define CAN_JAGUAR_MASTER_H

#include "CANJaguar.h"

class CANJaguarMaster : public CANJaguar
{
private:
	CANJaguar* m_slave;
	
public:
	CANJaguarMaster( int deviceNumber, CANJaguar* slave );
	void SetX( double outputValue );
	void Set( double outputValue );
	void SetX( double outputValue, uint8_t syncGroup );
	void Set( double outputValue, uint8_t syncGroup );
};

#endif
