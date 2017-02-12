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
	private double xPixelError;
	private double yPixelError;

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
	
	public double getBetterDistance() {
		return 4 * 360 / (2 * height[height.length-1] * Math.tan(33.05/2));
	}
	
	public double getDistanceToBase() {
		return Math.sqrt(getBetterDistance() * getBetterDistance() - 67 * 67);
	}
	
	public double getXPixelError() {
    	try {
    		if (centerX.length > 0) {
    			xPixelError = Globals.CAMERA_CENTER_X - centerX[centerX.length - 1];
    		}
    	} catch (ArrayIndexOutOfBoundsException e) {}
    	return xPixelError;
    }
	
	public double getYPixelError() {
		try {
    		if (centerY.length > 0) {
    			yPixelError = Globals.CAMERA_CENTER_Y - centerY[centerY.length - 1];
    		}
    	} catch (ArrayIndexOutOfBoundsException e) {}
		return yPixelError;
	}
    
    public double getXDegreeError() {
    	return Math.toDegrees(Math.atan(getXPixelError() / (Globals.CAMERA_CENTER_X * Math.sqrt(3))));
    }
    
//  Works only if camera is directly horizontal
    public double getYDegreeError() {
    	return Math.toDegrees(Math.atan(getYPixelError() / 606.7130121509));
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
		SmartDashboard.putNumber("Distance", getDistance());
		SmartDashboard.putNumber("Better Distance", getBetterDistance());
		SmartDashboard.putNumber("Distance to Base", getDistanceToBase());
	}
}
