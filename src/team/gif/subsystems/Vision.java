package team.gif.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team.gif.Globals;
import team.gif.Robot;

/**
 *
 */
public class Vision extends Subsystem {

	private Double[] area;
	private Double[] centerX;
	private Double[] centerY;
	private Double[] width;
	private Double[] height;
	private Double[] solidity;
	private double hPixelError;

	public Double[] getArea() {
		area = Robot.grip.getNumberArray("myContoursReport/area", area);
		return area;
	}

	public Double[] getCenterX() {
		centerX = Robot.grip.getNumberArray("myContoursReport/centerX", centerX);
		return centerX;
	}

	public Double[] getCenterY() {
		centerY = Robot.grip.getNumberArray("myContoursReport/centerY", centerY);
		return centerY;
	}

	public Double[] getWidth() {
		width = Robot.grip.getNumberArray("myContoursReport/width", width);
		return width;
	}

	public Double[] getHeight() {
		width = Robot.grip.getNumberArray("myContoursReport/height", height);
		return height;
	}

	public Double[] getSolidity() {
		width = Robot.grip.getNumberArray("myContoursReport/solidity", solidity);
		return solidity;
	}

//	public double getPixelError() {
//		try {
//			centerX = Robot.grip.getNumberArray("myContoursReport/centerX", new Double[] { 0.0 });
//			if (centerX.length > 0) {
//				hPixelError = Globals.cameraCenterX - centerX[centerX.length - 1];
//			} else {
//				if (hPixelError <= 0) {
//					hPixelError = -240;
//				} else {
//					hPixelError = 240;
//				}
//			}
//			return hPixelError;
//		} catch (ArrayIndexOutOfBoundsException e) {
//			return hPixelError;
//		}
//	}

	public double getHPixelError() {
    	try {
    		if (getCenterX().length > 0) {
    			hPixelError = Globals.cameraCenterX - centerX[centerX.length - 1];
    		}
    		return hPixelError;
    	} catch (ArrayIndexOutOfBoundsException e) {
			return hPixelError;
		}
    }

	public double getHDegreeError() {
		return Math.toDegrees(Math.atan(getHPixelError() / (Globals.cameraCenterX * Math.sqrt(3))));
	}

	public boolean isAligned() {
		return Math.abs(getHDegreeError()) < Globals.visionTolerance;
	}

	public void initDefaultCommand() {

	}

	public void update() {
		SmartDashboard.putNumber("Degree Error", getHDegreeError());
		SmartDashboard.putNumber("HPixelError", getHPixelError());
	}
}
