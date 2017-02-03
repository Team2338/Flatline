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
	private double degreeError;

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
    	double pixelError = largestCenterX - 240;
    	
    	degreeError = Math.toDegrees(Math.atan(pixelError/(240 * Math.sqrt(3))));
    }

    protected void execute() {
        Robot.turret.setPosition(Robot.turret.getPosition() - (16/9 * degreeError));
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
