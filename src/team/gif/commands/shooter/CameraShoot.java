package team.gif.commands.shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team.gif.OI;
import team.gif.commands.intake.FeederDrive;

/**
 *
 */
public class CameraShoot extends CommandGroup {

	public CameraShoot() {
		addParallel(new FeederDrive(true));
	}

}
