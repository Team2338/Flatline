package team.gif.commands.shooter;

import com.ctre.CANTalon.TalonControlMode;

import lib.gif.commands.Command;
import team.gif.Globals;
import team.gif.Robot;

public class CameraFollow extends Command {

	public CameraFollow() {
		requires(Robot.turret);
	}

	protected void initialize() {
		Robot.turret.setMode(TalonControlMode.Position);
//		Robot.turret.setPID(SmartDashboard.getNumber("Turret P", Globals.TURRET_P),
//				SmartDashboard.getNumber("Turret I", Globals.TURRET_I),
//				SmartDashboard.getNumber("Turret D", Globals.TURRET_D));
	}

	protected void execute() {
		Robot.turret.setPosition(Robot.turret.getPosition() - (Globals.TURRET_ANGLE_TO_TICK * Robot.vision.getXDegreeError()));
	}

	protected boolean isFinished() {
//		return Robot.vision.isAligned();
		return false;
	}

	protected void end() {}

	protected void interrupted() {}

}
