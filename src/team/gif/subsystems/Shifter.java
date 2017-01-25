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
	
	private static final Solenoid shifter = new Solenoid(0);
	
	public void shiftLow() {
		shifter.set(true);
	}
	
	public void shiftHigh() {
		shifter.set(false);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new ShifterLow());
    }
}

