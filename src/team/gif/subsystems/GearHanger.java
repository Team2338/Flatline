package team.gif.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.commands.Subsystem;
import team.gif.RobotMap;
import team.gif.commands.GearRelease;

public class GearHanger extends Subsystem {
	
	private static final DigitalInput pegSensor = new DigitalInput(RobotMap.PEGSENSOR); // Off is on, on is off
	private static final DigitalInput pegSensor2 = new DigitalInput(RobotMap.PEGSENSOR2);
	private static final DigitalOutput redStrip = new DigitalOutput(RobotMap.REDSTRIP);
	private static final DigitalOutput blueStrip = new DigitalOutput(RobotMap.BLUESTRIP);
	private static final Solenoid gearHanger1 = new Solenoid(RobotMap.GEAR_HANGER1);
	private static final Solenoid gearHanger2 = new Solenoid(RobotMap.GEAR_HANGER2);
	
	public GearHanger() {
		super();
		release(true);
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
	
	public void turnOnLed(boolean on) {
		redStrip.set(on);
		blueStrip.set(on);
	}
	
	public void toggleLight() {
		if (getFirstSense() || getSecondSense()) {
			blueStrip.set(true);
			redStrip.set(true);
		} else {
			blueStrip.set(false);
			redStrip.set(false);
		}
	}
	
	public boolean getBlue() {
		return blueStrip.get();
	}
	
	public boolean getRed() {
		return redStrip.get();
	}
	
	public boolean getFirstSense() {
		return !pegSensor.get();
	}
	
	public boolean getSecondSense() {
		return !pegSensor2.get();
	}
	
	public void update() {
		SmartDashboard.putBoolean("Blue On", getBlue());
		SmartDashboard.putBoolean("Red On", getRed());
		SmartDashboard.putBoolean("PegSensor", getFirstSense());
		SmartDashboard.putBoolean("PegSensor2", getSecondSense());
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new GearRelease(true));
    }
    
}