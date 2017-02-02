package team.gif.commands.shooter;

import java.awt.image.AreaAveragingScaleFilter;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Globals;
import team.gif.Robot;

/**
 *
 */
public class CameraFollow extends Command {
	
	private double[] defaultCenterX = {240.0};
	private double[] defaultArea = {100.0};
	private double largestCenterX;
	private double angle;

    public CameraFollow() {
        requires(Robot.turret);
    }

    protected void initialize() {
    	double[] areas = Robot.grip.getNumberArray("myContoursReport/area", defaultArea);
    	double currentLargest = 0;
    	int areaIndex = 0;
    	int i = 0;
    	for (double area : areas) {
    		if (area > currentLargest) {
    			currentLargest = area;
    			areaIndex = i;
    		}
    		i++;
    	}
    	double[] centerXs = Robot.grip.getNumberArray("myContoursReport/centerX", defaultCenterX);
    	largestCenterX = centerXs[areaIndex];
	centeredCenterX = largestCenterX - 240;
    	
    	angle = Math.toDegrees(Math.atan(cPixels/(240 * Math.sqrt(3)))); //left of center is negative, right positive
    }

    protected void execute() {
        Robot.turret.setPosition(((Robot.turret.getPosition() * (9/16) - angle)) * (16/9));
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
