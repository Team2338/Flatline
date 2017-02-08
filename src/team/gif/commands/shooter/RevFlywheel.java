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
		setpoint = SmartDashboard.getNumber("Flywheel RPM", Globals.flywheelRPM);
	}

	protected void initialize() {
		Robot.flywheel.setMode(TalonControlMode.Speed);
		Robot.flywheel.setPID(SmartDashboard.getNumber("Flywheel P", Globals.flywheelP),
		SmartDashboard.getNumber("Flywheel I", Globals.flywheelI),
		SmartDashboard.getNumber("Flywheel D", Globals.flywheelD),
		SmartDashboard.getNumber("Flywheel F", Globals.flywheelF));
	}

	protected void execute() {
		if (Robot.flywheel.getError() >= 0) {
			Robot.flywheel.flywheel.setIZone(Globals.flywheelIZoneBelow);
		} else {
			Robot.flywheel.flywheel.setIZone(Globals.flywheelIZoneAbove);
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
