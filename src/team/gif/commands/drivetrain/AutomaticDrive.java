package team.gif.commands.drivetrain;

import lib.gif.commands.Command;
import team.gif.Globals;
import team.gif.OI;
import team.gif.Robot;

/**
 *
 */
public class AutomaticDrive extends Command {
	
	private double leftSpeed;
	private double rightSpeed;
	private double leftStick;
	private double rightStick;

    public AutomaticDrive() {
        requires(Robot.drivetrain);
        requires(Robot.shifter);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	leftStick = OI.driverController.getRawAxis(1);
    	rightStick = OI.driverController.getRawAxis(5);
    	
    	if (Math.abs(leftStick) + Math.abs(rightStick) / 2 < 0.5) {
    		Robot.shifter.shift(true);
    		
			leftSpeed = ((Math.abs(leftStick) > Globals.DEAD_ZONE) ? leftStick : 0);
			rightSpeed = ((Math.abs(rightStick) > Globals.DEAD_ZONE) ? rightStick : 0);
    	} else {
    		Robot.shifter.shift(false);
    		
    		leftSpeed = 1.5 * leftStick - 0.5;
			rightSpeed = 1.5 * rightStick - 0.5;
			//TODO: Tune these ratios to the real high gear ratio on the robot
    	}

		Robot.drivetrain.drive(leftSpeed, rightSpeed);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.drive(0, 0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
