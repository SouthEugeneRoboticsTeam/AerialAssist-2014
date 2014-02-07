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
    Compressor compressor;
    
    public CompressorSubsystem() {
        compressor = new Compressor(RobotMap.PRESSURE_SWITCH_CHANNEL, RobotMap.COMPRESSOR_CHANNEL);
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
