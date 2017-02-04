package team.gif.commands.shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team.gif.Globals;
import team.gif.Robot;
import team.gif.commands.intake.FeederIn;

/**
 *
 */
public class TurretAndShoot extends CommandGroup {

	public TurretAndShoot() {
		addParallel(new RevFlywheel(Globals.flywheelRPM));
		addParallel(new CameraFollow());
		if (Robot.turret.getInTolerance()) {
			addParallel(new FeederIn());
		}

		// TODO: Use IR sensor to determine when shooting finishes
	}
}
