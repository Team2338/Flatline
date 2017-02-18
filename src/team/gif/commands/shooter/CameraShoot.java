package team.gif.commands.shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team.gif.OI;
import team.gif.commands.intake.FeederDrive;

/**
 *
 */
public class CameraShoot extends CommandGroup {

	public CameraShoot() {
	}

	protected void execute() {
		if (OI.auxController.getRawAxis(3) > 0.1 && !OI.auxController.getRawButton(5)) {
			new FeederDrive(true);
		}
	}
}
