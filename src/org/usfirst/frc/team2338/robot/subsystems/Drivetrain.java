package org.usfirst.frc.team2338.robot.subsystems;

import org.usfirst.frc.team2338.robot.commands.TankDrive;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Drivetrain extends Subsystem {

	private static final CANTalon frontLeft = new CANTalon(0);
	private static final CANTalon frontRight = new CANTalon(1);
	private static final CANTalon rearLeft = new CANTalon(2);
	private static final CANTalon rearRight = new CANTalon(3);
	
	public void drive(double leftOutput, double rightOutput){
		frontLeft.set(leftOutput);
		frontRight.set(rightOutput);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new TankDrive());
    }
}

