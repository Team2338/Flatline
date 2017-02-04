package team.gif.commands.shooter;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.Arrays;

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
	private boolean inTolerance;

	public CameraFollow() {
		requires(Robot.turret);
	}

	protected void initialize() {
		Robot.turret.setMode(TalonControlMode.Position);
	}

	protected void execute() {
		Double[] areas = Robot.grip.getNumberArray("myContoursReport/area", new Double[] { 0.0 });
		Double[] centerXs = Robot.grip.getNumberArray("myContoursReport/centerX", new Double[] { 0.0 });
		
		double currentLargest = 0;
		int areaIndex = 0;
		int i = 0;

		if (areas.length > 0 && centerXs.length > 0) {
			for (double area : areas) {
				if (area > currentLargest) {
					currentLargest = area;
					areaIndex = i;
				}
				i++;
			}
			largestCenterX = centerXs[areaIndex];
		} else {
			largestCenterX = 0; // TODO: Make it not always turn left if it
								// cannot see target
		}

		double pixelError = 240 - largestCenterX;
		degreeError = Math.toDegrees(Math.atan(pixelError / (240 * Math.sqrt(3))));
		SmartDashboard.putNumber("Degree Error", degreeError);

		Robot.turret.setPosition(Robot.turret.getPosition() + (16 / 9 * degreeError));

		if (Math.abs(degreeError) < Globals.pixelTolerance) {
			inTolerance = true;
		} else {
			inTolerance = false;
		}
		SmartDashboard.putBoolean("InTolerance", inTolerance);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		
	}

	protected void interrupted() {
	}
	
	public boolean getInTolerance() {
		return inTolerance;
	}
}
