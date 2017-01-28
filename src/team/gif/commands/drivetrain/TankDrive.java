package team.gif.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.OI;
import team.gif.Robot;
import team.gif.subsystems.Drivetrain;

/**
 *
 */
public class TankDrive extends Command {
	
    public TankDrive() {
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
//    	Robot.drivetrain.drive(-OI.leftJoy.getY(), OI.rightJoy.getY());
//    	Robot.drivetrain.drive(-OI.xboxController.getRawAxis(1), OI.xboxController.getRawAxis(5));
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
