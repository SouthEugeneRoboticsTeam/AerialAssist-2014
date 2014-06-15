#ifndef CAN_ROBOT_DRIVE_H
#define CAN_ROBOT_DRIVE_H

#include "RobotDrive.h"
#include "CANJaguar.h"
#include "CANJaguarMaster.h"


class CANRobotDrive: public RobotDrive 
{
private:
    CANJaguarMaster* m_frontLeftMotor;
    CANJaguarMaster* m_frontRightMotor;
    
public:
    CANRobotDrive( CANJaguarMaster* frontLeftMotor, CANJaguarMaster* frontRightMotor );
    void ChangeControlMode( CANJaguar::ControlMode mode );
    void MoveInches( double distance );
    double GetEncoders();
};

#endif
