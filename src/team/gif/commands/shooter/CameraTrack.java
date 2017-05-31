package team.gif.commands.shooter;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.commands.Command;
import lib.gif.PIDCalculator;
import team.gif.Globals;
import team.gif.Robot;

/**
 *
 */
public class CameraTrack extends Command {
	
	private PIDCalculator turretPID;
	private double setpoint;
	private double turretActualP;
	private double error;

	public CameraTrack() {
		requires(Robot.turret);
	}

	protected void initialize() {
		setpoint = Robot.turret.getPosition() + Globals.TURRET_ANGLE_TO_TICK * Robot.vision.getXDegreeError();
	}

	protected void execute() {
		if (Math.abs(Robot.turret.getSpeed()) < 5) {
			setpoint = Robot.turret.getPosition() + Globals.TURRET_ANGLE_TO_TICK * (Robot.vision.getXDegreeError());
		}
		
		error = setpoint - Robot.turret.getPosition();
		
		SmartDashboard.putNumber("Turret Error", error);
		SmartDashboard.putNumber("Turret Actual P", turretActualP);
		
		turretPID = new PIDCalculator(SmartDashboard.getNumber("Turret P", Globals.TURRET_P),
				 SmartDashboard.getNumber("Turret I", Globals.TURRET_I),
				 SmartDashboard.getNumber("Turret D", Globals.TURRET_D));
		
		SmartDashboard.putNumber("Turret Motor Output", turretPID.getOutput(error));
		
		if (turretPID.getOutput(error) > 0.025 && turretPID.getOutput(error) < 0.05) {
			Robot.turret.set(turretPID.getOutput(error) + 0.04);
		} else if (turretPID.getOutput(error) < -0.025 && turretPID.getOutput(error) > -0.05) {
			Robot.turret.set(turretPID.getOutput(error) - 0.04);
		} else if (turretPID.getOutput(error) > 0.21) {
			Robot.turret.set(0.21);
		} else if (turretPID.getOutput(error) < -0.21) {
			Robot.turret.set(-0.21);
		} else {
			Robot.turret.set(turretPID.getOutput(error));
		}
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
	}

	protected void interrupted() {
	}

}
