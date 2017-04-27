package team.gif.commands.drivetrain;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
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
	private boolean squaredInputs;

	public TankDrive(double maxAccel) {
		requires(Robot.drivetrain);
		this.maxAccel = maxAccel;
	}

	protected void initialize() {
		this.squaredInputs = SmartDashboard.getBoolean("Squared Inputs", true);
		Robot.drivetrain.setMode(TalonControlMode.PercentVbus);
	}

	protected void execute() {
		leftStick = OI.driverController.getRawAxis(1);
		rightStick = OI.driverController.getRawAxis(5);

		left = -(Math.abs(leftStick) > Globals.DEAD_ZONE ? leftStick : 0);
		right = -(Math.abs(rightStick) > Globals.DEAD_ZONE ? rightStick : 0);
		
		left = squaredInputs ? Math.pow(left, 3) : left;
		right = squaredInputs ? Math.pow(right, 3) : right;
		
//		left = OI.d_leftBumper.get() ? (left + right) : left;
//		right = OI.d_leftBumper.get() ? (left + right) : right;

		if (!Robot.shifter.isHigh()) { // P: Robot.shifter.isHigh() C: !Robot.shifter.isHigh()
			if (left > 0 && leftLast < 0 || left < 0 && leftLast > 0) {
				left = 0;
			} else if (left > 0) { //Forward Left
				if (left - leftLast > maxAccel)
					left = leftLast + maxAccel;
			} else if (left < 0){ //Reverse Left
				if (left - leftLast < -maxAccel)
					left = leftLast - maxAccel;
			}
			
			if (right > 0 && rightLast < 0 || right < 0 && rightLast > 0) {
				right = 0;
			} else if (right > 0) { // Forward right
				if (right - rightLast > maxAccel)
					right = rightLast + maxAccel;
			} else if (right < 0 ){ // Reverse right
				if (right - rightLast < -maxAccel)
					right = rightLast - maxAccel;
			}
			
			Robot.drivetrain.drive(-left - 0.45 * OI.driverController.getRawAxis(4), -left + 0.45 * OI.driverController.getRawAxis(4));
		} else {
			Robot.drivetrain.drive(-left, -right);
		}

		// TODO: Use velocity in place of left - leftLast

		leftLast = left;
		rightLast = right;
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
