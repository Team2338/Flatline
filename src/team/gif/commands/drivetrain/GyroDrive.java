package team.gif.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

public class GyroDrive extends Command {

	private double left;
	private double right;

	double angle;

	
    public GyroDrive(double left, double right) {
        requires(Robot.drivetrain);
        this.left = left;
        this.right = right;
    }
    
    protected void initialize() {
    	angle = Robot.drivetrain.getAngle();
    }

    protected void execute() {
    	if (angle - Robot.drivetrain.getAngle() < -1) {
    		Robot.drivetrain.drive(left - .1, right + .1);  
    		
    	} else if (angle - Robot.drivetrain.getAngle() < 0) {	
    		Robot.drivetrain.drive(left + .1, right - .1);
    		
    	} else {
    		Robot.drivetrain.drive(left, right); 
    	}	
}

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
