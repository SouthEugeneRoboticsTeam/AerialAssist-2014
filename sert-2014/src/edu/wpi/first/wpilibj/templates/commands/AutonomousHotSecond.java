/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;


/**
 *
 * @author Aubrey
 */
public class AutonomousHotSecond extends CommandGroup {
    
    public AutonomousHotSecond() {
        addSequential(new ChangeArmPosition());
        addParallel(new MoveToDistance(168));
        addSequential(new TriggerEject());
        
    }
}
