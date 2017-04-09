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
			setpoint = Robot.turret.getPosition() + Globals.TURRET_ANGLE_TO_TICK * (Robot.vision.getXDegreeError() + Robot.vision.getCameraOffset());
		}
		
		error = setpoint - Robot.turret.getPosition();
		
		if (Math.abs(error) <= 0.032) { // for tuning: pixel at 220
			turretActualP = 5.0;
		} else if (Math.abs(error) <= 0.07) { // for tuning: pixel at 200
			turretActualP = 2.85;
		} else if (Math.abs(error) <= 0.11) { // for tuning: pixel at 160
			turretActualP = 1.78;
		} else { // for tuning: pixel at 20
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
