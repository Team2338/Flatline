package team.gif.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Globals;
import team.gif.OI;
import team.gif.Robot;
import team.gif.subsystems.Drivetrain;


public class TankDrive extends Command {
	
    public TankDrive() {
    	requires(Robot.drivetrain);
    }

    protected void initialize() {
    	
    }

    protected void execute() {
    	if (Math.abs(OI.xboxController.getRawAxis(1)) > Globals.deadzone) {
    		Robot.drivetrain.driveLeft(OI.xboxController.getRawAxis(1));
    	} else {
    		Robot.drivetrain.driveLeft(0);
    	}
    	
    	if(Math.abs(OI.xboxController.getRawAxis(5)) > Globals.deadzone) {
    		Robot.drivetrain.driveRight(OI.xboxController.getRawAxis(5));
    	} else {
    		Robot.drivetrain.driveRight(0);
    	}
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    	Robot.drivetrain.drive(0, 0);
    }

    protected void interrupted() {
    	
    }
}
