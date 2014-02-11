/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.RobotMap;

/**
 *
 * @author Aubrey
 */
public class CompressorSubsystem extends Subsystem {
    Compressor onboardCompressor;
    Compressor offboardCompressor;
    
    public CompressorSubsystem() {
        onboardCompressor = new Compressor(RobotMap.PRESSURE_SWITCH_CHANNEL_1, RobotMap.ONBOARD_COMPRESSOR_CHANNEL);
        offboardCompressor = new Compressor(RobotMap.PRESSURE_SWITCH_CHANNEL_2, RobotMap.OFFBOARD_COMPRESSOR_CHANNEL);
    }
    
    public void startOnboardCompressor() {
        onboardCompressor.start();
    } 
    public void stopOnboardCompressor() {
        onboardCompressor.stop();
    }
    
   public void startOffboardCompressor() {
        offboardCompressor.start();
    } 
    public void stopOffboardCompressor() {
        offboardCompressor.stop();
    }
    
    public void initDefaultCommand(){
        //setDefaultCommand(new Pressurize(1));
    }
}
