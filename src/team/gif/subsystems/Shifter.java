package team.gif.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.commands.Subsystem;
import team.gif.RobotMap;
import team.gif.commands.drivetrain.ShifterLow;

public class Shifter extends Subsystem {
	
	private static final Solenoid shifter = new Solenoid(RobotMap.SHIFTER);
	
	public Shifter() {
		super();
		
		shifter.set(false); // P: false C: true
	}
	
	public void shift(boolean isLow) {
		shifter.set(!isLow); // P: !isLow C: isLow
	}
	
	public boolean isHigh() {
		return shifter.get();
	}

    public void initDefaultCommand() {
    }
    
}
