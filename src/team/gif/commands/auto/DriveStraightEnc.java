package team.gif.commands.auto;

import com.ctre.CANTalon.TalonControlMode;

import lib.gif.PIDCalculator;
import lib.gif.commands.Command;
import team.gif.Globals;
import team.gif.Robot;

public class DriveStraightEnc extends Command {

	private double setpoint;
	private double angle;
	private double distLeftError;
	private double distRightError;
	private final double speedCap;
	private PIDCalculator distCalc;
	private PIDCalculator angleCalc;

	public DriveStraightEnc(double dist) {
		this(dist, 0.7);
	}
	
	public DriveStraightEnc(double dist, double speedCap) {
		requires(Robot.drivetrain);
		setpoint = dist;
		this.speedCap = Math.abs(speedCap);
		
		distCalc = new PIDCalculator(Globals.DRIVETRAIN_P, Globals.DRIVETRAIN_I, Globals.DRIVETRAIN_D);
		angleCalc = new PIDCalculator(Globals.DRIVE_ANGLE_P, Globals.DRIVE_ANGLE_I, Globals.DRIVE_ANGLE_D);
		Robot.drivetrain.setMode(TalonControlMode.PercentVbus);
	}

	protected void initialize() {
		Robot.drivetrain.resetEncoders();
		angle = Robot.drivetrain.getAngle();
		
//		Robot.drivetrain.setMode(TalonControlMode.Position);
//		Robot.drivetrain.setPID(Globals.DRIVETRAIN_P, Globals.DRIVETRAIN_I, Globals.DRIVETRAIN_D);
//		Robot.drivetrain.drive(-setpoint, -setpoint);
	}

	protected void execute() {
		distLeftError = setpoint - Robot.drivetrain.getLeftDist();
		distRightError = setpoint - Robot.drivetrain.getRightDist();
//		double angleError = angle - Robot.drivetrain.getAngle();

		double distLeftOutput = distCalc.getOutput(distLeftError);
		double distRightOutput = distCalc.getOutput(distRightError);
//		double angleOutput = angleCalc.getOutput(angleError);

//    	if (distOutput > speedCap) {
//    		Robot.drivetrain.drive(-(speedCap + angleOutput), -(speedCap - angleOutput));
//    	} else if (distOutput < -speedCap) {
//    		Robot.drivetrain.drive(-(-speedCap + distOutput), -(-speedCap - distOutput));
//    	} else {
//    		Robot.drivetrain.drive(-(distOutput + angleOutput), -(distOutput - angleOutput));
//    	}
    	
		Robot.drivetrain.drive(-distLeftOutput, -distRightOutput);
	}

	protected boolean isFinished() {
		return (Math.abs(distLeftError) <= Globals.DRIVE_DIST_TOLERANCE) && Math.abs(distRightError) <= Globals.DRIVE_DIST_TOLERANCE;
	}

	protected void end() {
		System.out.println("Done");
		Robot.drivetrain.drive(0, 0);
//		Robot.drivetrain.resetEncoders();
	}

	protected void interrupted() {
		Robot.drivetrain.drive(0, 0);
	}
	
}
