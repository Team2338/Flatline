package team.gif.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.commands.Subsystem;
import team.gif.RobotMap;
import team.gif.commands.GearRelease;

public class GearHanger extends Subsystem {
	
//	private static final DigitalInput pegSensor = new DigitalInput(RobotMap.PEGSENSOR);
	private static final Solenoid gearHanger1 = new Solenoid(RobotMap.GEAR_HANGER1);
//	private static final Solenoid gearHanger2 = new Solenoid(RobotMap.GEAR_HANGER2);
	
	public void release(boolean isReleased) {
		gearHanger1.set(isReleased);
//		gearHanger2.set(isReleased);
	}
	
//	public boolean getSense() {
//		return pegSensor.get();
//	}
	
	public void update() {
//		SmartDashboard.putBoolean("PegSensor", getSense());
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new GearRelease(true));
    }
    
}