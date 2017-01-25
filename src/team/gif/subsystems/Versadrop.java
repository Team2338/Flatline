package team.gif.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.commands.drivetrain.ShiftTank;
import team.gif.commands.drivetrain.TankDrive;

/**
 *
 */
public class Versadrop extends Subsystem {

	private static final Solenoid versaDown = new Solenoid(0,1);
	private static final Solenoid versaUp = new Solenoid(0,6);
	
	public Versadrop() {
    	retractOmni();
	}
	
	public void releaseOmni() {
		versaUp.set(false);
		versaDown.set(true);
//		shifter.set(false);
	}
	
	public void retractOmni() {
		versaUp.set(true);
		versaDown.set(false);
//		shifter.set(true);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new ShiftTank());
    }
}

