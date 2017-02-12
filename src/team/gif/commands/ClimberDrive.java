package team.gif.commands;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

/**
 *
 */
public class ClimberDrive extends Command {
	
	private double speed;

    public ClimberDrive(double speed) {
        requires(Robot.climber);
        this.speed = speed;
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.climber.drive(speed);
    }

    protected boolean isFinished() {
    	return false;
    }

    protected void end() {
    }
    protected void interrupted() {
    }
}
