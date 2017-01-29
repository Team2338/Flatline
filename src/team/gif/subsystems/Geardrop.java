package team.gif.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.RobotMap;
import team.gif.commands.GearOut;

public class Geardrop extends Subsystem {
	
	private static final Solenoid geardrop = new Solenoid(RobotMap.geardrop);
	
	public void release(boolean isOut) {
		geardrop.set(isOut);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new GearOut());
    }
}

