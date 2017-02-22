package team.gif.commands.shooter;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.commands.Command;
import team.gif.Globals;
import team.gif.OI;
import team.gif.Robot;

public class RevFlywheel extends Command {

	private final double setpoint;
	private double assistedRPM;
//	private boolean isAssisted;
	private boolean isStable = false;

//	public RevFlywheel() {
//		this(false);
//	}

	public RevFlywheel() {
		requires(Robot.flywheel);
		setpoint = SmartDashboard.getNumber("Flywheel RPM", Globals.FLYWHEEL_RPM);
//		this.isAssisted = isAssisted;
	}

	protected void initialize() {
		Robot.flywheel.setMode(TalonControlMode.Speed);
		Robot.flywheel.setPID(SmartDashboard.getNumber("Flywheel P", Globals.FLYWHEEL_P),
				SmartDashboard.getNumber("Flywheel I", Globals.FLYWHEEL_I),
				SmartDashboard.getNumber("Flywheel D", Globals.FLYWHEEL_D),
				SmartDashboard.getNumber("Flywheel F", Globals.FLYWHEEL_F));
	}

	protected void execute() {
		if (Robot.flywheel.getError() >= 0) {
			Robot.flywheel.setIZone(Globals.FLYWHEEL_I_BELOW);
		} else {
			Robot.flywheel.setIZone(Globals.FLYWHEEL_I_ABOVE);
		}

//		if (isAssisted) {
//			if (Robot.vision.isAligned()) {
//				assistedRPM = (Robot.vision.getDistance() * Globals.RPM_PER_INCH) + 17600;
//				Robot.flywheel.driveFlywheel(assistedRPM);
//				isStable = true;
//			} else {
//				Robot.flywheel.driveFlywheel(0);
//			}
//		} else {
//			Robot.flywheel.driveFlywheel(Globals.FLYWHEEL_RPM); // TODO: Should be defaulted to straight peg RPM
//		}
		
		 Robot.flywheel.driveFlywheel(SmartDashboard.getNumber("Flywheel RPM", Globals.FLYWHEEL_RPM));

	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		// TODO: The if statement is likely not necessary
//		if (isAssisted) {
			// RPM won't change after we detect the target so if robots move in front of us, we can still shoot
			// TODO: What if we get pushed?
//			Robot.flywheel.driveFlywheel(assistedRPM);
		}


	protected void interrupted() {
	}

}
