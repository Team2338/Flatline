package team.gif.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.RobotMap;
import team.gif.commands.drivetrain.ShiftTank;

public class Versadrop extends Subsystem {

	private static final Solenoid versadrop = new Solenoid(RobotMap.versadrop);
	
	public void drop(boolean isRetract) {
		versadrop.set(isRetract);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new ShiftTank());
    }
}

