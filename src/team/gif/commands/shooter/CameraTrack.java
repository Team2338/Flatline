package team.gif.commands.shooter;

import edu.wpi.first.wpilibj.Timer;
import lib.gif.commands.Command;
import lib.gif.PIDCalculator;
import team.gif.Globals;
import team.gif.Robot;

/**
 *
 */
public class CameraTrack extends Command {
	
	private PIDCalculator turretPID;

	public CameraTrack() {
		requires(Robot.turret);
	}

	protected void initialize() {
		turretPID = new PIDCalculator(Globals.TURRET_P, Globals.TURRET_I, Globals.TURRET_D, Globals.TURRET_I_ZONE);
	}

	protected void execute() {
		Robot.turret.set(turretPID.getOutput(Globals.TURRET_ANGLE_TO_TICK * Robot.vision.getXDegreeError()));  
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}

}
