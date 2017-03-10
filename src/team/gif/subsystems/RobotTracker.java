package team.gif.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import team.gif.Robot;

/**
 *
 */
public class RobotTracker extends Subsystem {
	
//	private double DISTANCE_BETWEEN_WHEELS = 26.596;
	private final double TICKS_PER_INCH = (512.0*3.0*(50.0/34.0))/(4.0*Math.PI);
	private double centerX;
	private double centerY;
	private double rightX;
	private double rightY;
	private double rightXLast = 26.596/2;
	private double rightYLast;
	private double leftX;
	private double leftY;
	private double leftXLast = -26.596/2;
	private double leftYLast;
	private double angdeg;
	private double right;
	private double left;
	private double rightLast;
	private double leftLast;
	private double deltaRight;
	private double deltaLeft;
	
    public RobotTracker() {
    	super();
    }
    
    public double getReferenceYAxis() {
    	angdeg = angdeg; //TODO: Get gyro heading here
    	if (angdeg > 180) {
    		angdeg = (360 - angdeg) * -1;
    	} else if (angdeg < -180) {
    		angdeg = 360 - angdeg * -1;
    	}
    	
    	if (Math.abs(angdeg) > 90) {
    		angdeg = angdeg > 0 ? 180 - angdeg : -1 * (180 + angdeg);
    	}
    	
    	return angdeg;
    }
    
    public void translate() {
    	right = Robot.drivetrain.getRightDist() / TICKS_PER_INCH;
    	left = Robot.drivetrain.getLeftDist() / TICKS_PER_INCH;
    	
    	deltaRight = right - rightLast;
    	deltaLeft = left - leftLast;
    	
    	rightX = rightXLast + (deltaRight * Math.sin(Math.toRadians(getReferenceYAxis())));
    	rightY = rightYLast + (deltaRight * Math.cos(Math.toRadians(getReferenceYAxis())));
    	
    	leftX = leftXLast + (deltaLeft * Math.sin(Math.toRadians(getReferenceYAxis())));
    	leftY = leftYLast + (deltaLeft * Math.cos(Math.toRadians(getReferenceYAxis())));
    	
    	centerX = (rightX + leftX) / 2;
    	centerY = (rightY + leftY) / 2;
    	
    	rightLast = right;
    	leftLast = left;
    	rightXLast = rightX;
    	rightYLast = rightY;
    	leftXLast = leftX;
    	leftYLast = leftY;
    }

    public double getX() {
    	return centerX;
    }
    
    public double getY() {
    	return centerY;
    }
    
    public void update() {
    	translate();
    	SmartDashboard.putNumber("X Coordinate", getX());
    	SmartDashboard.putNumber("Y Coordinate", getY());
    }
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

