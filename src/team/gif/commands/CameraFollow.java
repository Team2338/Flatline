package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

/**
 *
 */
public class CameraFollow extends Command {
	
	double[] defaultCenterX = new double[0];
	double[] defaultArea = new double[0];
	double sum = 0.0;
	double largeCenterX = 0.0;
	int areaIndex = 0;
	int i = 0;
	double currentLargest = 0;

    public CameraFollow() {
        requires(Robot.turret);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double[] areas = Robot.grip.getNumberArray("myContoursReport/area", defaultArea);
    	i = 0;
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
    	largeCenterX = centerXs[areaIndex];
    	
    	double angle = largeCenterX / 960 * 60 - 30;
    	Robot.turret.setPosition((angle + (Robot.turret.getPosition() * (9/16)) * (16/9)));
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
