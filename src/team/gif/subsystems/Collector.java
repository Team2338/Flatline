package team.gif.subsystems;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import lib.gif.commands.Subsystem;
import team.gif.RobotMap;
import team.gif.commands.intake.CollectorDrive;

public class Collector extends Subsystem {

	private static final CANTalon collector = new CANTalon(RobotMap.COLLECTOR);
	private static final Solenoid collectorSolA = new Solenoid(RobotMap.COLLECTORSOLA);
	private static final Solenoid collectorSolB = new Solenoid(RobotMap.COLLECTORSOLB);
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
			collectorSolA.set(false); // P: false // C: false
			collectorSolB.set(true); // P: true // C: true
		} else {
			collectorSolA.set(true); // P: true // C: true
			collectorSolB.set(false); // P: false // C: false
		}
	}
	
	public void retractHood(boolean isRetract) {
		collectorHoodSol.set(isRetract);
	}

	public void initDefaultCommand() {
		setDefaultCommand(new CollectorDrive(0));
	}

}
