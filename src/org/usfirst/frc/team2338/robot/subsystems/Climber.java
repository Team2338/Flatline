package org.usfirst.frc.team2338.robot.subsystems;

import org.usfirst.frc.team2338.robot.commands.ClimberJoy;
import org.usfirst.frc.team2338.robot.commands.ClimberNeutral;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

	private static final CANTalon climber = new CANTalon(2);

	public void drive(double output){
		climber.set(output);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new ClimberJoy());
    }
}

