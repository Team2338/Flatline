package team.gif.commands.auto;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.PIDCalculator;
import lib.gif.commands.Command;
import team.gif.Globals;
import team.gif.Robot;

// Check right encoder tolerance only, but use both encoders
public class DriveStraightEnc extends Command {

	private double setpoint;
	private double angle;
	private double distLeftError;
	private double distRightError;
	private double distError;
	private final double speedCap;
	private PIDCalculator distCalc;
	private PIDCalculator angleCalc;

	public DriveStraightEnc(double inches, double timeout) {
		this(inches, 0.45, timeout);
	}
	
	public DriveStraightEnc(double inches, double speedCap, double timeout) {
		super(timeout);
		requires(Robot.drivetrain);
		setpoint = inches * Globals.TICKS_PER_INCH;
		this.speedCap = Math.abs(speedCap);
		distCalc = new PIDCalculator(Globals.DRIVETRAIN_P, Globals.DRIVETRAIN_I, Globals.DRIVETRAIN_D);
		angleCalc = new PIDCalculator(Globals.DRIVE_STRAIGHT_ANGLE_P, 0, 0);
		Robot.drivetrain.setMode(TalonControlMode.PercentVbus);
	}

	protected void initialize() {
		Robot.drivetrain.resetEncoders();
		angle = Robot.drivetrain.getAngle();
	}

	protected void execute() {
		distLeftError = setpoint - Robot.drivetrain.getLeftDist();
		distRightError = setpoint - Robot.drivetrain.getRightDist();
//		distError = setpoint - Robot.drivetrain.getRightDist();
		double angleError = angle - Robot.drivetrain.getAngle();

		double distLeftOutput = distCalc.getOutput(distLeftError);
		double distRightOutput = distCalc.getOutput(distRightError);
//		double distOutput = distCalc.getOutput(distError);
		double angleOutput = angleCalc.getOutput(angleError);
		
		double left;
		double right;

    	if (distLeftOutput > speedCap) {
    		left = -speedCap + angleOutput;
    	} else if (distLeftOutput < -speedCap) {
    		left = speedCap + angleOutput;
    	} else {
    		left = -distLeftOutput + angleOutput;
    	}
    	
    	if (distRightOutput > speedCap) {
    		right = -speedCap - angleOutput;
    	} else if (distRightOutput < -speedCap) {
    		right = speedCap - angleOutput;
    	} else {
    		right = -distRightOutput - angleOutput;
    	}
    	
    	Robot.drivetrain.drive(left, right);
		
    	//FIXME: Tune angle PID
		SmartDashboard.putNumber("DriveStraight Angle Error", angleError);
		
		SmartDashboard.putNumber("distLeftError", distLeftError);
		SmartDashboard.putNumber("distRightError", distRightError);
		
//		Robot.drivetrain.drive(-distLeftOutput + angleOutput, -distRightOutput - angleOutput);
	}

	protected boolean isFinished() {
		return (Math.abs(distRightError) <= Globals.DRIVE_DIST_TOLERANCE) || isTimedOut();
//		return (Math.abs(distError) <= Globals.DRIVE_DIST_TOLERANCE);
	}

	protected void end() {
		Robot.drivetrain.drive(0, 0);
//		Robot.drivetrain.resetEncoders();
	}

	protected void interrupted() {
		Robot.drivetrain.drive(0, 0);
	}
	
}
