/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;
    
import edu.wpi.first.wpilibj.templates.CANJaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.IntakeControl;
/**
 *
 * @author SERT
 */

public class IntakeSubsystem extends Subsystem {
    CANJaguar intake;
    DoubleSolenoid arm;
    private static boolean isUp = true;
        
    public IntakeSubsystem() {
        try {
            intake = new CANJaguar(RobotMap.INTAKE_JAG);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        arm = new DoubleSolenoid(RobotMap.INTAKE_RAISE_CHANNEL, RobotMap.INTAKE_LOWER_CHANNEL);
        raiseArm();
        
    }
    
    public static boolean isUp() {
        return isUp;
    }
    
    public void intake() throws CANTimeoutException {
        intake.setX(-.7);
    }
    
    public void eject() throws CANTimeoutException {
        intake.setX(.5);
    }
    
    public void stopIntake() throws CANTimeoutException {
        intake.setX(0);
    }
    
    public void intakeControl(double speed) throws CANTimeoutException {
        intake.setX(speed);
    }
    
    public void raiseArm() {
        isUp = true;
        arm.set(DoubleSolenoid.Value.kForward);
        Timer.delay(.01);
        resetArmSolenoid();
    }
    
    public void lowerArm() {
        isUp = false;
        arm.set(DoubleSolenoid.Value.kReverse);
        Timer.delay(.01);
        resetArmSolenoid();
    }
    
    public void resetArmSolenoid() {
        arm.set(DoubleSolenoid.Value.kOff);
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new IntakeControl());
    }
}
