package team.gif.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.RobotMap;
import team.gif.commands.CollectorStandby;
import com.ctre.CANTalon;

public class Feeder extends Subsystem {

	private static final CANTalon feeder = new CANTalon(RobotMap.feeder);
	private static final CANTalon polyWhisk = new CANTalon(RobotMap.polyWhisk);
	
	public void driveFeeder(double speed) {
		feeder.set(speed);
	}
	
	public void drivePolyWhisk(double speed) {
		polyWhisk.set(speed);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new CollectorStandby());
    }
}

