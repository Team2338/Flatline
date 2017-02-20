package team.gif.commands.auto;

import com.ctre.CANTalon.TalonControlMode;

import lib.gif.PIDCalculator;
import lib.gif.commands.Command;
import team.gif.Globals;
import team.gif.Robot;

public class GyroTurn extends Command {

	private double angle;
	private double angleError;
	private PIDCalculator angleCalc;
    
	public GyroTurn() {
		this(Robot.drivetrain.getAngle());
	}
	
	public GyroTurn(double angle) {
        requires(Robot.drivetrain);
        this.angle = angle;
        angleCalc = new PIDCalculator(Globals.DRIVE_ANGLE_P, 
        		Globals.DRIVE_ANGLE_I, Globals.DRIVE_ANGLE_D);
        Robot.drivetrain.setMode(TalonControlMode.PercentVbus);
    }

	protected void initialize() {}

	protected void execute() {
		angleError = angle - Robot.drivetrain.getAngle();
		double angleOutput = angleCalc.getOutput(angleError);

		Robot.drivetrain.drive(angleOutput, -angleOutput);
	}

	protected boolean isFinished() {
		return Math.abs(angleError) <= Globals.DRIVE_ANGLE_TOLERANCE;
	}

	protected void end() {}

	protected void interrupted() {}

}
