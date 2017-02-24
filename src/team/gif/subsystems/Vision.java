package team.gif.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.commands.Subsystem;
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
	private double xDegreeConstant;
	private double yDegreeConstant;
	private double halfVertFOV;

	public Vision() {
		super();
		xDegreeConstant = Globals.CAMERA_CENTER_X / Math.tan(Math.toRadians(Globals.CAMERA_HFOV / 2));
		yDegreeConstant = Globals.CAMERA_CENTER_Y / Math.tan(Math.toRadians(Globals.CAMERA_VFOV / 2));
		halfVertFOV = Globals.CAMERA_VFOV / 2;
	}

	public double getXPixelError() {
		try {
			if (centerX.length > 0)
				xPixelError = Globals.CAMERA_CENTER_X - centerX[centerX.length - 1];
		} catch (ArrayIndexOutOfBoundsException e) {}
		return xPixelError;
	}

	public double getYPixelError() {
		try {
			if (centerY.length > 0)
				yPixelError = Globals.CAMERA_CENTER_Y - centerY[centerY.length - 1];
		} catch (ArrayIndexOutOfBoundsException e) {}
		return yPixelError;
	}

	public double getXDegreeError() {
		return Math.toDegrees(Math.atan(getXPixelError() / xDegreeConstant));
	}

	public double getYDegreeError() {
		return Math.toDegrees(Math.atan(getYPixelError() / yDegreeConstant)) + halfVertFOV;
	}

	public double getDistance() {
		return (66.5 / Math.tan(Math.toRadians(getYDegreeError())));
	}

	public boolean isAligned() {
		return Math.abs(getXDegreeError()) < Globals.VISION_TOLERANCE;
	}

	public void initDefaultCommand() {
	}

	public void update() {
		try {
			if (Robot.grip.getNumberArray("centerX", centerX) != null) {
				area = Robot.grip.getNumberArray("area", area);
				centerX = Robot.grip.getNumberArray("centerX", centerX);
				centerY = Robot.grip.getNumberArray("centerY", centerY);
				width = Robot.grip.getNumberArray("width", width);
				height = Robot.grip.getNumberArray("height", height);
				solidity = Robot.grip.getNumberArray("solidity", solidity);
			}
		} catch (NullPointerException e) {}

		SmartDashboard.putNumber("X Degree Error", getXDegreeError());
		SmartDashboard.putNumber("X Pixel Error", getXPixelError());
		SmartDashboard.putNumber("Y Pixel Error", getYPixelError());
		SmartDashboard.putNumber("Y Degree Error", getYDegreeError());
		SmartDashboard.putNumber("Distance", getDistance());
	}

}
