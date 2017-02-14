package team.gif.commands.drivetrain;

import edu.wpi.first.wpilibj.command.Command;
import team.gif.Robot;

public class ShiftOmni extends Command {
	
	private boolean isOmni;

	public ShiftOmni(boolean isOmni) {
		requires(Robot.versadrop);
		this.isOmni = isOmni;
	}

	protected void initialize() {
		Robot.versadrop.drop(!isOmni);
	}

	protected void execute() {}

	protected boolean isFinished() {
        return false;
    }
	
	protected void end() {}

	protected void interrupted() {}
	
}
