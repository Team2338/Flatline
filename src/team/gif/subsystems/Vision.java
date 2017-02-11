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
	
	public Vision() {
		area = Robot.grip.getNumberArray("myContoursReport/area", area);
		centerX = Robot.grip.getNumberArray("myContoursReport/centerX", centerX);
		centerY = Robot.grip.getNumberArray("myContoursReport/centerY", centerY);
		width = Robot.grip.getNumberArray("myContoursReport/width", width);
	}

	public Double[] getHeight() {
		height = Robot.grip.getNumberArray("myContoursReport/height", height);
		return height;
	}

	public Double[] getSolidity() {
		solidity = Robot.grip.getNumberArray("myContoursReport/solidity", solidity);
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
	public double getXPixelError() {
    	try {
    		if (centerX.length > 0) {
    			xPixelError = Globals.CAMERA_CENTER_X - centerX[centerX.length - 1];
    		}
    		return xPixelError;
    	} catch (ArrayIndexOutOfBoundsException e) {
			return xPixelError;
		}
    }
	
	public double getYPixelError() {
		try {
    		if (centerX.length > 0) {
    			yPixelError = Globals.CAMERA_CENTER_Y - centerY[centerY.length - 1];
    		}
    		return yPixelError;
    	} catch (ArrayIndexOutOfBoundsException e) {
			return yPixelError;
		}
	}
    
    public double getXDegreeError() {
    	return Math.toDegrees(Math.atan(getXPixelError() / (Globals.CAMERA_CENTER_X * Math.sqrt(3))));
    }
    
    public double getYDegreeError() {
    	return Math.toDegrees(Math.atan(getYPixelError() / 606.71));
    }
    
    public double getDistance() {
    	return 67 / Math.tan(getYDegreeError());
    }
    
    public boolean isAligned() {
    	return Math.abs(getXDegreeError()) < Globals.VISION_TOLERANCE;
    }

	public void initDefaultCommand() {

	}

	public void update() {
		SmartDashboard.putNumber("Degree Error", getXDegreeError());
		SmartDashboard.putNumber("HPixelError", getXPixelError());
	}
}
