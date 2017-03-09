package team.gif.commands.shooter;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.commands.Command;
import team.gif.Globals;
import team.gif.OI;
import team.gif.Robot;

public class ChangeRevSetpoint extends Command {

	private double setpoint;

	public ChangeRevSetpoint(double setpoint) {
//		requires(Robot.flywheel);
		this.setpoint = setpoint;
	}

	protected void initialize() {
		Robot.flywheel.setStandbySetpoint(setpoint);
	}

	protected void execute() {
	}

	protected boolean isFinished() {
		return true;
	}

	protected void end() {
	}

	protected void interrupted() {
	}

}
