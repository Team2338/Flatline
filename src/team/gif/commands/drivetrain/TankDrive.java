package team.gif.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
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
    	Robot.drivetrain.drive(-OI.leftJoy.getY(), OI.rightJoy.getY());
//    	Robot.drivetrain.drive(OI.xboxController.getRawAxis(1), -OI.xboxController.getRawAxis(5));
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
