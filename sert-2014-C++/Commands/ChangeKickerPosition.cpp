#include "ChangeKickerPosition.h"

ChangeKickerPosition::ChangeKickerPosition() {
  Requires(m_kickerSub);
}

void ChangeKickerPosition::Initialize() {
}

void ChangeKickerPosition::Execute() {
}

void ChangeKickerPosition::IsFinished() {
  return true;
}

void ChangeKickerPosition::End() {
  if (m_kickerSub->IsUp()) {
    m_kickerSub->LowerKicker();
  } else {
    m_kickerSub->RaiseKicker();
  }
}

void ChangeKickerPosition::Interrupted() {
}
