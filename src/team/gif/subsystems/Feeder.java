package team.gif.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import team.gif.RobotMap;
import team.gif.commands.intake.FeederDrive;

import com.ctre.CANTalon;

public class Feeder extends Subsystem {

	private static final CANTalon feeder = new CANTalon(RobotMap.FEEDER);
	private static final CANTalon polyWhisk = new CANTalon(RobotMap.POLY_WHISK);
	
	public void driveFeeder(double speed) {
		feeder.set(speed);
	}
	
	public void drivePolyWhisk(double speed) {
		polyWhisk.set(speed);
	}

    public void initDefaultCommand() {
    	setDefaultCommand(new FeederDrive(0));
    }
}

