package team.gif.commands.shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import team.gif.Globals;
import team.gif.Robot;
import team.gif.commands.intake.FeederDrive;

/**
 *
 */
public class ManualShoot extends CommandGroup {

	public ManualShoot() {
		addParallel(new RevFlywheel());
		// addSequential(new WaitCommand(Globals.revTime));
		if (Robot.flywheel.isInTolerance()) {
			addParallel(new FeederDrive(1));
			// TODO: Use IR sensor to determine when shooting finishes
			// ALTERNATIVE: Use velocity data to count shots
		}
	}
}
