package team.gif.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team.gif.Globals;
import team.gif.Robot;

/**
 *
 */
public class Vision extends Subsystem {
	
	private Double[] centerX;
	private double hPixelError;

    public double getPixelError() {
    	try {
        	centerX = Robot.grip.getNumberArray("myContoursReport/centerX", new Double[] {0.0});
        	if(centerX.length > 0) {
        		hPixelError = Globals.CAMERA_CENTER_X - centerX[centerX.length - 1];
    		} else {
    			if (hPixelError <= 0) {
    				hPixelError = -240;
    			} else {
    				hPixelError = 240;
    			}
    		}
    		return hPixelError;
    	} catch (ArrayIndexOutOfBoundsException e) {
    		return hPixelError;
    	}
    }
    
    public double getDegreeError() {
    	return Math.toDegrees(Math.atan(getPixelError() / (Globals.CAMERA_CENTER_X * Math.sqrt(3))));
    }
    
    public boolean isAligned() {
    	return Math.abs(getDegreeError()) < Globals.VISION_TOLERANCE;
    }

    public void initDefaultCommand() {

    }

	public void update() {
		SmartDashboard.putNumber("Degree Error", getDegreeError());
		SmartDashboard.putNumber("HPixelError", getPixelError());
	}
}

