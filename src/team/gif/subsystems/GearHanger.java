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
	private static final Relay led = new Relay(RobotMap.LED);
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
		if (getFirstSense() || getSecondSense()) {
			led.set(Relay.Value.kForward);
		} else {
			led.set(Relay.Value.kReverse);
		}
	}
	
	public boolean getLight() {
		return led.isAlive();
	}
	
	public boolean getFirstSense() {
		return !pegSensor.get();
	}
	
	public boolean getSecondSense() {
		return !pegSensor2.get();
	}
	
	public void update() {
		SmartDashboard.putBoolean("LED Trigger", getLight());
		SmartDashboard.putBoolean("PegSensor", getFirstSense());
		SmartDashboard.putBoolean("PegSensor2", getSecondSense());
	}
	
    public void initDefaultCommand() {
    	setDefaultCommand(new GearRelease(true));
    }
    
}