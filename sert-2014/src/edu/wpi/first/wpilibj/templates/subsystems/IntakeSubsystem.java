/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;
    
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.Pressurize;
import edu.wpi.first.wpilibj.templates.commands.Pressurize;
/**
 *
 * @author SERT
 */

public class IntakeSubsystem extends Subsystem {
    CANJaguar intake;
    DoubleSolenoid lifter;
    private boolean isUp = true;
        
    public IntakeSubsystem() {
        try {
            intake = new CANJaguar(RobotMap.INTAKE_JAG);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        lifter = new DoubleSolenoid(RobotMap.INTAKE_RAISE_CHANNEL, RobotMap.INTAKE_LOWER_CHANNEL);
    }
    
    public boolean isUp() {
        return isUp;
    }
    
    public void intake() throws CANTimeoutException {
        intake.setX(1);
    }
    
    public void eject() throws CANTimeoutException {
        intake.setX(-1);
    }
    
    public void raiseKicker() {
        lifter.set(DoubleSolenoid.Value.kForward);
        isUp = true;
    }
    
    public void lowerKicker() {
        lifter.set(DoubleSolenoid.Value.kReverse);
        isUp = false;
    }
    
    public void resetKickerSolenoid() {
        lifter.set(DoubleSolenoid.Value.kOff);
    }

    protected void initDefaultCommand() {
        
    }
}
