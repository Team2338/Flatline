package team.gif.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.RobotMap;
import team.gif.commands.intake.CollectorDrive;

/**
 *
 */
public class Collector extends Subsystem {

	private static final CANTalon collector = new CANTalon(RobotMap.COLLECTOR);
	private static final Solenoid collectorSol1 = new Solenoid(RobotMap.COLLECTORSOL1);
	private static final Solenoid collectorSol2 = new Solenoid(RobotMap.COLLECTORSOL2);
	
	public void drive(double speed) {
		collector.set(speed);
	}
	
	public void retract(boolean isRetract) {
		collectorSol1.set(isRetract);
		collectorSol2.set(isRetract);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new CollectorDrive(0));
    }
}

