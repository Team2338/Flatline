package team.gif.commands.shooter;

import com.ctre.CANTalon.TalonControlMode;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team.gif.Globals;
import team.gif.Robot;

/**
 *
 */
public class CameraFollow extends Command {

	private double degreeError;
	private double largestCenterX;
	private double pixelError;
	private Double[] centerXs;

	public CameraFollow() {
		requires(Robot.turret);
	}

	protected void initialize() {
		Robot.turret.setMode(TalonControlMode.Position);
	}

	protected void execute() {
//		Double[] areas = Robot.grip.getNumberArray("myContoursReport/area", new Double[] { 0.0 });
		centerXs = Robot.grip.getNumberArray("myContoursReport/centerX", new Double[] { 0.0 });
		
//		double currentLargest = 0;
//		int areaIndex = 0;
//		int i = 0;

//		if (areas.length > 0 && centerXs.length > 0) {
//			for (double area : areas) {
//				if (area > currentLargest) {
//					currentLargest = area;
//					areaIndex = i;
//				}
//				i++;
//			}
//			largestCenterX = centerXs[Math.max(areaIndex, 0)];
//		} else {
//			largestCenterX = 0; // TODO: Make it not always turn left if it
//								// cannot see target
//		}

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

		Robot.turret.setPosition(Robot.turret.getPosition() + (Globals.turretAngleToTick * degreeError));
	}

	protected boolean isFinished() {
//		return Robot.turret.inTolerance;
		return false;
	}

	protected void end() {
		
	}

	protected void interrupted() {
	}
}
