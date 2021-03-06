package team.gif.commands.shooter;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.commands.Command;
import team.gif.Globals;
import team.gif.Robot;

public class RevFlywheel extends Command {

	private double setpoint;
	private boolean isSpew;
	private boolean isHopperAuto;

	public RevFlywheel() {
		this(false, false);
	}
	
	public RevFlywheel(boolean isSpew) {
		this(isSpew, false);
	}

	public RevFlywheel(boolean isSpew, boolean isHopperAuto) {
		requires(Robot.flywheel);
		this.isSpew = isSpew;
		this.isHopperAuto = isHopperAuto;
		setpoint = Globals.FLYWHEEL_RPM_SP;
		// this.isAssisted = isAssisted;
	}

	protected void initialize() {
		Robot.flywheel.setMode(TalonControlMode.Speed);
		
		if (isHopperAuto) {
			Robot.flywheel.setMeasurementPeriod(32);
		} else {
			Robot.flywheel.setMeasurementPeriod(64);
		}

		if (isSpew) {
			// PID doesn't matter in this case since we're just spewing balls out
			setpoint = Globals.FLYWHEEL_RPM_EJECT;
		} else {
			setpoint = Robot.flywheel.getStandbySetpoint();

			if (setpoint == Globals.FLYWHEEL_RPM_CP) {
				Robot.flywheel.setPID(Globals.FLYWHEEL_P_CP, Globals.FLYWHEEL_I_CP, Globals.FLYWHEEL_D_CP,
						Globals.FLYWHEEL_F_CP);
			} else if (setpoint == Globals.FLYWHEEL_RPM_FH) {
				Robot.flywheel.setPID(Globals.FLYWHEEL_P_FH, Globals.FLYWHEEL_I_FH, Globals.FLYWHEEL_D_FH,
						Globals.FLYWHEEL_F_FH);
			} else if (setpoint == Globals.FLYWHEEL_RPM_SP) {
				Robot.flywheel.setPID(Globals.FLYWHEEL_P_SP, Globals.FLYWHEEL_I_SP, Globals.FLYWHEEL_D_SP,
						Globals.FLYWHEEL_F_SP);
			}
//			} else if (setpoint == Globals.FLYWHEEL_RPM_FSP) {
//				Robot.flywheel.setPID(Globals.FLYWHEEL_P_FSP, Globals.FLYWHEEL_I_FSP, Globals.FLYWHEEL_D_FSP,
//						Globals.FLYWHEEL_F_FSP);
//			}

//			 Robot.flywheel.setPID(SmartDashboard.getNumber("Flywheel P",
//			 Globals.FLYWHEEL_P_CP),
//			 SmartDashboard.getNumber("Flywheel I", Globals.FLYWHEEL_I_CP),
//			 SmartDashboard.getNumber("Flywheel D", Globals.FLYWHEEL_D_CP),
//			 SmartDashboard.getNumber("Flywheel F", Globals.FLYWHEEL_F_CP));
		}
	}

	protected void execute() {
		if (Robot.flywheel.getError() >= 0) {
			Robot.flywheel.setIZone(Globals.FLYWHEEL_I_BELOW);
		} else {
			Robot.flywheel.setIZone(Globals.FLYWHEEL_I_ABOVE);
		}

		// Robot.flywheel.driveFlywheel(SmartDashboard.getNumber("Flywheel RPM",
		// Globals.FLYWHEEL_RPM_CP));
		Robot.flywheel.driveFlywheel(setpoint);

		if (Robot.flywheel.getVelocity() != 0) {
			Robot.flywheel.enableCompressor(false);
		}

	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.flywheel.enableCompressor(true);
	}

	protected void interrupted() {
		end();
	}

}
