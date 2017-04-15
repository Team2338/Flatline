package team.gif.commands.shooter;

import edu.wpi.first.wpilibj.Timer;
import lib.gif.PIDCalculator;
import lib.gif.commands.Command;
import team.gif.Globals;
import team.gif.Robot; 

// Note that this command is not being called/used anywhere.
public class TurretTurn extends Command {

	private double setpoint;
	private double error;
	private PIDCalculator turretPID;

	public TurretTurn(double setpoint) {
		requires(Robot.turret);
		this.setpoint = setpoint;
	}

	protected void initialize() {
		turretPID = new PIDCalculator(Globals.TURRET_P, Globals.TURRET_I, Globals.TURRET_D, Globals.TURRET_I_ZONE);
	}

	protected void execute() {
		error = setpoint - Robot.turret.getPosition();
		Robot.turret.set(turretPID.getOutput(error));
	}

	protected boolean isFinished() {
		return Math.abs(error) < Globals.TURRET_TOLERANCE;
	}

	protected void end() {
	}

	protected void interrupted() {
	}

}
