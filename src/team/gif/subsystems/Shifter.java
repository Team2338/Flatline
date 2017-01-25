package team.gif.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.commands.drivetrain.ShifterDown;
import team.gif.commands.drivetrain.TankDrive;

/**
 *
 */
public class Shifter extends Subsystem {
	
//	private static final Solenoid shiftUp = new Solenoid(0,0);
//	private static final Solenoid shiftDown = new Solenoid(0,7);
	
	private static final Solenoid shifter = new Solenoid(0);
	
	public Shifter() {
    	shiftDown();
	}
	
	public void shiftDown() {
//		shiftDown.set(true);
//		shiftUp.set(false);
		
		shifter.set(true);
	}
	
	public void shiftUp() {
//		shiftDown.set(false);
//		shiftUp.set(true);
		
		shifter.set(false);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new ShifterDown());
    }
}

