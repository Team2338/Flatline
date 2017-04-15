package team.gif.commands.shooter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.commands.Command;
import team.gif.Globals;
import team.gif.OI;
import team.gif.Robot;

public class TurretRamp extends Command {
	
	private double interval;
	
	public TurretRamp() {
		requires(Robot.turret);
	}

	protected void initialize() {
		interval = 0;
	}

	protected void execute() {
		interval = interval + 0.001;
		Robot.turret.set(interval);
		
		SmartDashboard.putNumber("Turret Interval", interval);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}

}
