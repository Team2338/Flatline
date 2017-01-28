package team.gif.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.commands.drivetrain.ShiftTank;
import team.gif.commands.drivetrain.TankDrive;

public class Versadrop extends Subsystem {

	private static final Solenoid versadrop = new Solenoid(6);
	
	public void drop(boolean isRetract) {
		versadrop.set(isRetract);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new ShiftTank());
    }
}

