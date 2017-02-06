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
    	centerX = Robot.grip.getNumberArray("myContoursReport/centerX", new Double[] {0.0});
    	if(centerX.length > 0) {
			return Globals.cameraCenterX - centerX[centerX.length - 1];
		} else {
			if (hPixelError <= 0) {
				return 240;
			} else {
				return -240;
			}
		}
    }
    
    public double getDegreeError() {
    	return Math.toDegrees(Math.atan(getPixelError() / (Globals.cameraCenterX * Math.sqrt(3))));
    }
    
    public boolean isAligned() {
    	return Math.abs(getDegreeError()) < Globals.turretTolerance;
    }

    public void initDefaultCommand() {

    }

	public void update() {
		SmartDashboard.putNumber("Degree Error", getDegreeError());
	}
}

