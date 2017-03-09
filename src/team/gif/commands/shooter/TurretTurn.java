package team.gif.commands.shooter;

import com.ctre.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.commands.Command;
import team.gif.Globals;
import team.gif.Robot; 

public class TurretTurn extends Command {

	private final double setpoint;

	public TurretTurn(double setpoint) {
		requires(Robot.turret);
		this.setpoint = setpoint;
	}

	protected void initialize() {
		Robot.turret.setMode(TalonControlMode.Position);
		Robot.turret.setPID(SmartDashboard.getNumber("Turret P", Globals.TURRET_P),
				SmartDashboard.getNumber("Turret I", Globals.TURRET_I),
				SmartDashboard.getNumber("Turret D", Globals.TURRET_D));
	}

	protected void execute() {
		Robot.turret.setPosition(setpoint);
	}

	protected boolean isFinished() {
		return Robot.turret.isInTolerance();
	}

	protected void end() {
	}

	protected void interrupted() {
	}

}
