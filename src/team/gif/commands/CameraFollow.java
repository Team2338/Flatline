package team.gif.commands;

import static team.gif.Robot.grip;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

/**
 *
 */
public class CameraFollow extends Command {
	
	double[] defaultCenterX = new double[0];
	double sum = 0.0;
	double averageCenterX = 0.0;

    public CameraFollow() {
        requires(Robot.turret);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double[] centerXs = Robot.grip.getNumberArray("myContoursReport/centerX", defaultCenterX);
    	for (double centerX : centerXs) {
    		sum += centerX;
    	}
    	averageCenterX = sum / centerXs.length;
    	sum = 0;
    	
    	double angle = averageCenterX / 960 * 60 - 30;
    	Robot.turret.setPosition((angle - (Robot.turret.getPosition() * (9/16)) * (16/9)));
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
