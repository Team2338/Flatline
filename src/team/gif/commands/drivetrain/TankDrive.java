package team.gif.commands.drivetrain;

import com.ctre.CANTalon.TalonControlMode;

import lib.gif.commands.Command;
import team.gif.Globals;
import team.gif.OI;
import team.gif.Robot;

public class TankDrive extends Command {

	private double left;
	private double right;
	private double leftLast;
	private double rightLast;
	private double leftStick;
	private double rightStick;
	private double maxAccel;
	private double secondsHigh;

	public TankDrive(double maxAccel) {
		requires(Robot.drivetrain);
		this.maxAccel = maxAccel;
	}

	protected void initialize() {
		Robot.drivetrain.setMode(TalonControlMode.PercentVbus);
	}

	protected void execute() {
		leftStick = OI.driverController.getRawAxis(1);
		rightStick = OI.driverController.getRawAxis(5);

		left = (Math.abs(leftStick) > Globals.DEAD_ZONE ? leftStick : 0);

		right = (Math.abs(rightStick) > Globals.DEAD_ZONE ? rightStick : 0);

//		if (Robot.shifter.isHigh()) {
//			if (leftStick > 0) {
//				if (left - leftLast > maxAccel) {
//					left = leftLast + maxAccel;
//				}
//			} else if (leftStick < 0) {
//				if (left - leftLast < -maxAccel) {
//					left = leftLast - maxAccel;
//				}
//			}
//	
//			if (rightStick > 0) {
//				if (right - rightLast > maxAccel) {
//					right = rightLast + maxAccel;
//				}
//			} else if (rightStick < 0) {
//				if (right - rightLast < -maxAccel) {
//					right = rightLast - maxAccel;
//				}
//			}
//		}

		// TODO: Use velocity in place of left - leftLast

		Robot.drivetrain.drive(left, right);

//		leftLast = left;
//		rightLast = right;

		// if (Robot.shifter.isHigh()) {
		// Robot.drivetrain.compensateVoltage();
		// }
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
