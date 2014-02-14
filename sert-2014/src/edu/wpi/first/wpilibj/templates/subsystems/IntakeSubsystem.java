/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;
    
import edu.wpi.first.wpilibj.CANJaguar;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.can.CANTimeoutException;
import edu.wpi.first.wpilibj.templates.RobotMap;
import edu.wpi.first.wpilibj.templates.commands.Intake;
/**
 *
 * @author SERT
 */

public class IntakeSubsystem extends Subsystem {
    CANJaguar intake;
    DoubleSolenoid arm;
    private boolean isUp = true;
        
    public IntakeSubsystem() {
        try {
            intake = new CANJaguar(RobotMap.INTAKE_JAG);
        } catch (CANTimeoutException ex) {
            ex.printStackTrace();
        }
        arm = new DoubleSolenoid(RobotMap.INTAKE_RAISE_CHANNEL, RobotMap.INTAKE_LOWER_CHANNEL);
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
    
    public void intakeControl(double speed) throws CANTimeoutException {
        intake.setX(speed);
    }
    
    public void raiseArm() {
        arm.set(DoubleSolenoid.Value.kForward);
        isUp = true;
    }
    
    public void lowerArm() {
        arm.set(DoubleSolenoid.Value.kReverse);
        isUp = false;
    }
    
    public void resetArmSolenoid() {
        arm.set(DoubleSolenoid.Value.kOff);
    }

    protected void initDefaultCommand() {
        setDefaultCommand(new Intake());
    }
}
