package team.gif.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.commands.drivetrain.ShifterLow;
import team.gif.commands.drivetrain.TankDrive;

/**
 *
 */
public class Shifter extends Subsystem {
	
	private static final Solenoid shifter = new Solenoid(7);
	
	public void shift(boolean isLow) {
		shifter.set(isLow);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new ShifterLow());
    }
}

