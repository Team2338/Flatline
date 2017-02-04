package team.gif.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.RobotMap;

/**
 *
 */
public class Collector extends Subsystem {

	private static final CANTalon collector = new CANTalon(RobotMap.collector);
	
	public void drive(double speed) {
		collector.set(speed);
	}

    public void initDefaultCommand() {
    	setDefaultCommand()
    }
}
