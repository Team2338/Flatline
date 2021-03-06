package team.gif.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.commands.Subsystem;
import team.gif.Globals;
import team.gif.Robot;

public class Vision extends Subsystem {

	private Double[] area = new Double[0];
	private Double[] centerX = new Double[0];
	private Double[] centerY = new Double[0];
	private Double[] width = new Double[0];
	private Double[] height = new Double[0];
	private Double[] solidity = new Double[0];
	private double xPixelError;
	private double yPixelError;
	private double xDegreeConstant;
	private double yDegreeConstant;
	private double cameraOffset;

	public Vision() {
		super();
		cameraOffset = Globals.CAMERA_OFFSET_CP_RED;
		xDegreeConstant = Globals.CAMERA_CENTER_X / Math.tan(Math.toRadians(Globals.CAMERA_HFOV / 2));
		yDegreeConstant = Globals.CAMERA_CENTER_Y / Math.tan(Math.toRadians(Globals.CAMERA_VFOV / 2));
	}
	
	public void setAngleOffset(double cameraOffset) {
		this.cameraOffset = cameraOffset;
	}
	
	public double getCameraOffset() {
		return cameraOffset;
	}

	public double getXPixelError() {
		try {
			if (centerX.length > 0)
				xPixelError = (Globals.CAMERA_CENTER_X) - centerX[centerX.length - 1];
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		return xPixelError;
	}

	public double getYPixelError() {
		try {
			if (centerY.length > 0)
				yPixelError = Globals.CAMERA_CENTER_Y - centerY[centerY.length - 1];
		} catch (ArrayIndexOutOfBoundsException e) {
		}
		return yPixelError;
	}

	public double getXDegreeError() {
		return Math.toDegrees(Math.atan((getXPixelError()) / xDegreeConstant)) + getCameraOffset();
	}

	public double getYDegreeError() {
		return Math.toDegrees(Math.atan(getYPixelError() / yDegreeConstant)) + 19.77;
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
		} catch (NullPointerException e) {
		}

		SmartDashboard.putNumber("Camera Offset", getCameraOffset());
		SmartDashboard.putNumber("X Degree Error", getXDegreeError());
		SmartDashboard.putNumber("X Pixel Error", getXPixelError());
		SmartDashboard.putNumber("Y Pixel Error", getYPixelError());
		SmartDashboard.putNumber("Y Degree Error", getYDegreeError());
		SmartDashboard.putNumber("Distance", getDistance());
	}

}
