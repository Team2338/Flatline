package team.gif.commands.intake;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

/**
 *
 */
public class FeederDrive extends Command {
	
	private double speed;

    public FeederDrive(double speed) {
        requires(Robot.feeder);
        this.speed = speed;
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.feeder.driveFeeder(speed);
    	Robot.feeder.drivePolyWhisk(speed);
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
