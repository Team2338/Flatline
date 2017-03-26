package team.gif.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import lib.gif.commands.Subsystem;
import team.gif.RobotMap;
import team.gif.commands.intake.CollectorDrive;

public class Collector extends Subsystem {

	private static final CANTalon collector = new CANTalon(RobotMap.COLLECTOR);
	private static final Solenoid collectorSolA = new Solenoid(0, RobotMap.COLLECTORSOLA);
	private static final Solenoid collectorSolB = new Solenoid(0, RobotMap.COLLECTORSOLB);
	private static final Solenoid collectorHoodSol = new Solenoid(RobotMap.COLLECTORHOODSOL);
	
	public Collector() {
		super();
		retractHood(false);
	}

	public void drive(double speed) {
		collector.set(-speed);
	}
	
	public void retractCollector(boolean isRetract) {
		if (isRetract) {
			collectorSolA.set(true);
			collectorSolB.set(false);
		} else {
			collectorSolA.set(false);
			collectorSolB.set(true);
		}
	}
	
	public void retractHood(boolean isRetract) {
		collectorHoodSol.set(isRetract);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new CollectorDrive(0));
	}

}
