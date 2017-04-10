package team.gif.commands.shooter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.PIDCalculator;
import lib.gif.commands.Command;
import team.gif.Globals;
import team.gif.Robot;

public class CameraAim extends Command {
	
	private PIDCalculator turretPID;
	private double setpoint;
	private double turretActualP;
	private double error;

	public CameraAim() {
		requires(Robot.turret);
	}

	protected void initialize() {
//		turretPID = new PIDCalculator(SmartDashboard.getNumber("Turret P",
//				 Globals.TURRET_P),
//				 SmartDashboard.getNumber("Turret I", Globals.TURRET_I),
//				 SmartDashboard.getNumber("Turret D", Globals.TURRET_D), Globals.TURRET_I_ZONE);
		setpoint = Robot.turret.getPosition() + Globals.TURRET_ANGLE_TO_TICK * Robot.vision.getXDegreeError();
	}

	protected void execute() {
		error = setpoint - Robot.turret.getPosition();
		
		if (Math.abs(error) <= 0.0187) {
			turretActualP = 8;
		} else if (Math.abs(error) <= 0.055) {
			turretActualP = 4.3;
		} else {
			turretActualP = Globals.TURRET_P;
		}
		
		SmartDashboard.putNumber("Turret Error", error);
		SmartDashboard.putNumber("Turret Actual P", turretActualP);
		
		turretPID = new PIDCalculator(turretActualP,
				 SmartDashboard.getNumber("Turret I", Globals.TURRET_I),
				 SmartDashboard.getNumber("Turret D", Globals.TURRET_D), Globals.TURRET_I_ZONE);
		
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
