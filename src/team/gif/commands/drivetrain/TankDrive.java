package team.gif.commands.drivetrain;

import com.ctre.CANTalon.TalonControlMode;

import lib.gif.commands.Command;
import team.gif.Globals;
import team.gif.OI;
import team.gif.Robot;

public class TankDrive extends Command {

	private double left;
	private double right;

	public TankDrive() {
		requires(Robot.drivetrain);
	}

	protected void initialize() {
		Robot.drivetrain.setMode(TalonControlMode.PercentVbus);
	}

	protected void execute() {
		if (Math.abs(OI.driverController.getRawAxis(1)) > Globals.DEAD_ZONE) {
			left = OI.driverController.getRawAxis(1);
		} else {
			left = 0;
		}

		if (Math.abs(OI.driverController.getRawAxis(5)) > Globals.DEAD_ZONE) {
			right = OI.driverController.getRawAxis(5);
		} else {
			right = 0;
		}

		Robot.drivetrain.drive(left, right);
		
//		if (Robot.shifter.isHigh()) {
//			Robot.drivetrain.compensateVoltage();
//		}

		// if (Math.abs(OI.leftStick.getY()) > Globals.DEAD_ZONE) {
		// left = OI.leftStick.getY();
		// } else {
		// left = 0;
		// }
		//
		// if(Math.abs(OI.rightStick.getY()) > Globals.DEAD_ZONE) {
		// right = OI.rightStick.getY();
		// } else {
		// right = 0;
		// }
		//
		// Robot.drivetrain.drive(left, right);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		Robot.drivetrain.drive(0, 0);
	}

	protected void interrupted() {
		end();
	}

}
