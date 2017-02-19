package team.gif.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team.gif.Globals;
import team.gif.Robot;

public class Vision extends Subsystem {

	private Double[] area;
	private Double[] centerX;
	private Double[] centerY;
	private Double[] width;
	private Double[] height;
	private Double[] solidity;
	private double xPixelError;
	private double yPixelError;

	public double getXPixelError() {
		if (Robot.grip.getNumberArray("centerX", centerX) != null) {
			try {
				if (centerX.length > 0) {
					xPixelError = Globals.CAMERA_CENTER_X - centerX[centerX.length - 1];
				}
			} catch (ArrayIndexOutOfBoundsException e) {}
		}
		return xPixelError;
	}

	public double getYPixelError() {
		if (Robot.grip.getNumberArray("centerY", centerY) != null) {
			try {
				if (centerY.length > 0) {
					yPixelError = Globals.CAMERA_CENTER_Y - centerY[centerY.length - 1];
				}
			} catch (ArrayIndexOutOfBoundsException e) {}
		}
		return yPixelError;
	}

	public double getXDegreeError() {
		return Math.toDegrees(Math.atan(getXPixelError() / (Globals.CAMERA_CENTER_X / Math.tan(Globals.CAMERA_HFOV / 2))));
	}


	public double getYDegreeError() {
		return Math.toDegrees(Math.atan(getYPixelError() / (Globals.CAMERA_CENTER_Y / Math.tan(Globals.CAMERA_VFOV / 2)))) + (Globals.CAMERA_VFOV/2);
	}

	public double getDistance() {
		return 67d / Math.tan(getYDegreeError());
	}

	public boolean isAligned() {
		return Math.abs(getXDegreeError()) < Globals.VISION_TOLERANCE;
	}

	public void initDefaultCommand() {
	}

	public void update() {
		area = Robot.grip.getNumberArray("area", area);
		centerX = Robot.grip.getNumberArray("centerX", centerX);
		centerY = Robot.grip.getNumberArray("centerY", centerY);
		width = Robot.grip.getNumberArray("width", width);
		height = Robot.grip.getNumberArray("height", height);
		solidity = Robot.grip.getNumberArray("solidity", solidity);

		SmartDashboard.putNumber("Degree Error", getXDegreeError());
		SmartDashboard.putNumber("HPixelError", getXPixelError());
		SmartDashboard.putNumber("Y Pixel Error", getYPixelError());
		SmartDashboard.putNumber("Y Degree Error", getYDegreeError());
		SmartDashboard.putNumber("Distance", getDistance());
	}

}
