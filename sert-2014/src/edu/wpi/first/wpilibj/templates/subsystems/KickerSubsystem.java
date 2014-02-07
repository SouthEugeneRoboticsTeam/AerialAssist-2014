/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Aubrey
 */
public class KickerSubsystem extends Subsystem {
    DoubleSolenoid kicker;
    private boolean isUp = true;
        
    public KickerSubsystem() {
        kicker = new DoubleSolenoid(RobotMap.KICKER_RAISE_CHANNEL, RobotMap.KICKER_LOWER_CHANNEL);
    }
    
    public boolean isUp() {
        return isUp;
    }
    
    public void raiseArm() {
        kicker.set(DoubleSolenoid.Value.kForward);
        isUp = true;
    }
    
    public void lowerArm() {
        kicker.set(DoubleSolenoid.Value.kReverse);
        isUp = false;
    }
    
    public void resetArmSolenoid() {
        kicker.set(DoubleSolenoid.Value.kOff);
    }

    protected void initDefaultCommand() {
    }
}
