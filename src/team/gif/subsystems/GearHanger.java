package team.gif.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.commands.Subsystem;
import team.gif.RobotMap;
import team.gif.commands.GearRelease;

public class GearHanger extends Subsystem {
	
	private static final DigitalInput pegSensor = new DigitalInput(RobotMap.PEGSENSOR); // Off is on, on is off
	private static final DigitalOutput led = new DigitalOutput(RobotMap.LED);
	private static final Solenoid gearHanger1 = new Solenoid(RobotMap.GEAR_HANGER1);
	private static final Solenoid gearHanger2 = new Solenoid(RobotMap.GEAR_HANGER2);
	
	public GearHanger() {
		super();
	}
	
	public void release(boolean isReleased) {
		if(isReleased) {
			gearHanger1.set(true);
			gearHanger2.set(false);
		} else {
			gearHanger1.set(false);
			gearHanger2.set(true);
		}
	}
	
	public void toggleLight() {
		led.set(!getSense());
	}
	
	public boolean getLight() {
		return led.get();
	}
	
	public boolean getSense() {
		return !pegSensor.get();
	}
	
	public void update() {
		SmartDashboard.putBoolean("LED Trigger", getLight());
		SmartDashboard.putBoolean("PegSensor", getSense());
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new GearRelease(true));
    }
    
}