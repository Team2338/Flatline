package team.gif.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.commands.Subsystem;
import team.gif.RobotMap;
import team.gif.commands.drivetrain.ShifterHigh;

public class Shifter extends Subsystem {
	
	private static final Solenoid shifter = new Solenoid(RobotMap.SHIFTER);
	
	public Shifter() {
		super();
		
		shifter.set(true);
	}
	
	public void shift(boolean isLow) {
		shifter.set(isLow);
	}
	
	public boolean isHigh() {
		return shifter.get();
	}
	
	public void update() {
		SmartDashboard.putBoolean("Shifter Mode", isHigh());
	}

    public void initDefaultCommand() {
//    	setDefaultCommand(new ShifterHigh(false));
    }
    
}
