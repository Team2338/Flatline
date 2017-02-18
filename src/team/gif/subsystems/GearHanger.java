package team.gif.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.RobotMap;
import team.gif.commands.GearRelease;

public class GearHanger extends Subsystem {
	
	private static final Solenoid gearHanger1 = new Solenoid(RobotMap.GEAR_HANGER1);
//	private static final Solenoid gearHanger2 = new Solenoid(RobotMap.GEAR_HANGER2);
	
	public void release(boolean isReleased) {
		gearHanger1.set(isReleased);
//		gearHanger2.set(isReleased);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new GearRelease(true));
    }
    
}
