package team.gif.commands.shooter;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team.gif.Globals;
import team.gif.OI;
import team.gif.Robot;

public class TurretTurn extends Command {

	private final double setpoint;

	public TurretTurn(double setpoint) {
		requires(Robot.turret);
		this.setpoint = setpoint;
	}

	protected void initialize() {
		Robot.turret.setPID(Globals.TURRET_P, Globals.TURRET_I, Globals.TURRET_D);
		Robot.turret.setMode(TalonControlMode.Position);
	}

	protected void execute() {
		Robot.turret.setPosition(setpoint);

		if (OI.auxController.getPOV() == 0 || OI.auxController.getPOV() == 45 || OI.auxController.getPOV() == 315) {
			Robot.turret.setPosition((Double) Robot.turretPosChooser.getSelected());
		}
	}

	protected boolean isFinished() {
		return Robot.turret.isInTolerance();
	}

	protected void end() {
	}

	protected void interrupted() {
	}

}
