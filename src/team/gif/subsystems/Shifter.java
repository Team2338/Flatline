package team.gif.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
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

    public void initDefaultCommand() {
//    	setDefaultCommand(new ShifterHigh(false));
    }
    
}
