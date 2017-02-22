package team.gif.commands.shooter;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.commands.Command;
import team.gif.Globals;
import team.gif.OI;
import team.gif.Robot;

public class CameraFollow extends Command {

//	private double degreeError;
//	private double largestCenterX;
//	private double pixelError;
//	private Double[] centerXs;

	public CameraFollow() {
		requires(Robot.turret);
	}

	protected void initialize() {
		Robot.turret.setMode(TalonControlMode.Position);
		Robot.turret.setPID(SmartDashboard.getNumber("Turret P", Globals.TURRET_P),
				SmartDashboard.getNumber("Turret I", Globals.TURRET_I),
				SmartDashboard.getNumber("Turret D", Globals.TURRET_D));
	}

	protected void execute() {
/*
		centerXs = Robot.grip.getNumberArray("myContoursReport/centerX", new Double[] { 0.0 });
		
		if(centerXs.length > 0) {
			largestCenterX = centerXs[centerXs.length - 1];
		} else {
			if (pixelError <= 0) {
				largestCenterX = 0; // TODO: Make it not always turn left it is cannot see target
			} else if (pixelError > 0) {
				largestCenterX = 480;
			}
		}
		
		pixelError = Globals.cameraCenterX - largestCenterX;
		degreeError = Math.toDegrees(Math.atan(pixelError / (Globals.cameraCenterX * Math.sqrt(3))));
		SmartDashboard.putNumber("Degree Error", degreeError);
*/
		Robot.turret.setPosition(Robot.turret.getPosition() - (Globals.TURRET_ANGLE_TO_TICK * Robot.vision.getXDegreeError()));
	}

	protected boolean isFinished() {
//		return Robot.turret.inTolerance;
		return false;
	}

	protected void end() {}

	protected void interrupted() {}

}
