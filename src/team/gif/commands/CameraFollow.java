package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

/**
 *
 */
public class CameraFollow extends Command {
	
	private double[] defaultCenterX = new double[0];
	private double[] defaultArea = new double[0];
	private double largestCenterX = 0.0;
	private int areaIndex = 0;
	private double currentLargest = 0;

    public CameraFollow() {
        requires(Robot.turret);
    }

    protected void initialize() {
    	
    }

    protected void execute() {
    	double[] areas = Robot.grip.getNumberArray("myContoursReport/area", defaultArea);
    	int i = 0;
    	currentLargest = 0;
    	areaIndex = 0;
    	for (double area : areas) {
    		if (area > currentLargest) {
    			currentLargest = area;
    			areaIndex = i;
    		}
    		i++;
    	}
    	double[] centerXs = Robot.grip.getNumberArray("myContoursReport/centerX", defaultCenterX);
    	largestCenterX = centerXs[areaIndex];
    	
    	double angle = largestCenterX / 480 * 60 - 30;
    	Robot.turret.setPosition((angle + (Robot.turret.getPosition() * (9/16)) * (16/9)));
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
