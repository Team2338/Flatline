package team.gif.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.RobotMap;
import team.gif.commands.GearRelease;

public class GearHanger extends Subsystem {
	
	private static final Solenoid gearHanger = new Solenoid(RobotMap.GEAR_HANGER);
	
	public void release(boolean isOut) {
		gearHanger.set(isOut);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new GearRelease(false));
    }
}

