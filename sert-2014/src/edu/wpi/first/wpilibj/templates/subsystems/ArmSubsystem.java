/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;
    
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.Pressurize;
import edu.wpi.first.wpilibj.templates.commands.Pressurize;
/**
 *
 * @author SERT
 */

public class ArmSubsystem extends Subsystem {

    Compressor compressor;
    DoubleSolenoid lifter;

    private boolean isUp = true;
        
    public ArmSubsystem() {
        compressor = new Compressor(RobotMap.PRESSURE_SWITCH_CHANNEL, RobotMap.COMPRESSOR_CHANNEL);
        lifter = new DoubleSolenoid(RobotMap.SOLENOID_RAISE_CHANNEL, RobotMap.SOLENOID_LOWER_CHANNEL);
    }
    
    public boolean isUp() {
        return isUp;
    }
    
    public void raiseArm() {
        lifter.set(DoubleSolenoid.Value.kForward);
        isUp = true;
    }
    
    public void lowerArm() {
        lifter.set(DoubleSolenoid.Value.kReverse);
        isUp = false;
    }
    
    public void resetArmSolenoid() {
        lifter.set(DoubleSolenoid.Value.kOff);
    }
    
    public void startCompressor() {
        compressor.start();
    } 
    public void stopCompressor() {
        compressor.stop();
    }
    
    public void initDefaultCommand(){
        //setDefaultCommand(new Pressurize());
    }
}
