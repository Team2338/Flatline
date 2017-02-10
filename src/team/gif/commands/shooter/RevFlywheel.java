package team.gif.commands.shooter;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team.gif.Globals;
import team.gif.Robot;

public class RevFlywheel extends Command {

	public final double setpoint;

	public RevFlywheel() {
		requires(Robot.flywheel);
		setpoint = SmartDashboard.getNumber("Flywheel RPM", Globals.FLYWHEEL_RPM);
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
			Robot.flywheel.flywheel.setIZone(Globals.FLYWHEEL_I_BELOW);
		} else {
			Robot.flywheel.flywheel.setIZone(Globals.FLYWHEEL_I_ABOVE);
		}

		Robot.flywheel.driveFlywheel(setpoint);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}
}
