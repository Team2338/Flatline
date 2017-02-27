package team.gif.commands.drivetrain;

import edu.wpi.first.wpilibj.Timer;
import lib.gif.commands.Command;
import team.gif.Globals;
import team.gif.OI;
import team.gif.Robot;

public class ShifterHigh extends Command {

	private boolean isHigh;
	private boolean isShifted;
	private double left;
	private double right;
	private double initTime;

	public ShifterHigh(boolean isHigh) {
//		requires(Robot.drivetrain);
		requires(Robot.shifter);
		this.isHigh = isHigh;
	}

	protected void initialize() {
//		initTime = Timer.getFPGATimestamp();
//		isShifted = false;
		
		Robot.shifter.shift(!isHigh);
	}

	protected void execute() {
//		if (Math.abs(OI.driverController.getRawAxis(1)) > Globals.DEAD_ZONE) {
//			left = 0.25 * OI.driverController.getRawAxis(1);
//		} else {
//			left = 0;
//		}
//
//		if (Math.abs(OI.driverController.getRawAxis(5)) > Globals.DEAD_ZONE) {
//			right = 0.25 * OI.driverController.getRawAxis(5);
//		} else {
//			right = 0;
//		}
//		
//		Robot.drivetrain.drive(left, right);
//		
//		if (Timer.getFPGATimestamp() - initTime > 0.3) {
//			Robot.shifter.shift(!isHigh); // P: isHigh C: !isHigh
//			isShifted = true;
//		}
	}

	protected boolean isFinished() {
//		return isShifted;
		return false;
	}

	protected void end() {
//		new TankDrive().start();
	}

	protected void interrupted() {
	}

}
