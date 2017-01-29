package team.gif.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.Globals;
import team.gif.RobotMap;
import team.gif.commands.GearOut;
import team.gif.commands.drivetrain.ShifterLow;
import team.gif.commands.drivetrain.TankDrive;

public class Geardrop extends Subsystem {
	
	private static final Solenoid geardrop = new Solenoid(RobotMap.geardrop);
	
	public void release(boolean isOut) {
		geardrop.set(isOut);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new GearOut());
    }
}

