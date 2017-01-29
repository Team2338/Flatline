package team.gif.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.RobotMap;
import team.gif.commands.drivetrain.ShifterLow;

public class Shifter extends Subsystem {
	
	private static final Solenoid shifter = new Solenoid(RobotMap.shifter);
	
	public void shift(boolean isLow) {
		shifter.set(isLow);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new ShifterLow());
    }
}

