package team.gif.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.RobotMap;
import team.gif.commands.GearOut;

public class GearHanger extends Subsystem {
	
	private static final Solenoid gearHanger = new Solenoid(RobotMap.gearHanger);
	
	public void release(boolean isOut) {
		gearHanger.set(isOut);
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new GearOut());
    }
}

