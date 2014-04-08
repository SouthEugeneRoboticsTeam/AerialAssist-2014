/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.templates.RobotMap;


/**
 *
 * @author Aubrey
 */
public class Autonomous extends CommandGroup {
    
    public Autonomous() {
        
        addSequential(new TriggerIntake(), .5);
        addSequential(new MoveToDistance(RobotMap.AUTONOMOUS_DISTANCE), 3);
        addSequential(new TriggerEject(), 3);
    }
}
