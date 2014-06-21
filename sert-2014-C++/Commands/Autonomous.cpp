#include "Autonomous.h"
#include "CANJaguar.h"
#include "../RobotMap.h"

Autonomous::Autonomous()
{
  AddSequential(new TriggerIntake(), .5);
  AddSequential(new MoveToDistance(RobotMap.AUTONOMOUS_DISTANCE), 3);
  AddSequential(new TriggerEject(), 3);
}

