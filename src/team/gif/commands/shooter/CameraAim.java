package team.gif.commands.shooter;

import lib.gif.PIDCalculator;
import lib.gif.commands.Command;
import team.gif.Globals;
import team.gif.Robot;

public class CameraAim extends Command {
	
	private PIDCalculator turretPID;
	private double setpoint;
	private double error;

	public CameraAim() {
		requires(Robot.turret);
	}

	protected void initialize() {
		turretPID = new PIDCalculator(Globals.TURRET_P, Globals.TURRET_I, Globals.TURRET_D, Globals.TURRET_I_ZONE);
		setpoint = Robot.turret.getPosition() - Globals.TURRET_ANGLE_TO_TICK * Robot.vision.getXDegreeError();
	}

	protected void execute() {
		error = setpoint - Robot.turret.getPosition();
		Robot.turret.set(turretPID.getOutput(error));
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}

}
