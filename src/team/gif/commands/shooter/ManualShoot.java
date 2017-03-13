package team.gif.commands.shooter;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import lib.gif.commands.CommandGroup;
import team.gif.Globals;
import team.gif.commands.intake.FeederDrive;

public class ManualShoot extends CommandGroup {

	public ManualShoot() {
		// TODO: Use IR sensor to determine when shooting finishes
		// ALTERNATIVE: Use velocity data to count shots
		addParallel(new RevFlywheel());
		addParallel(new FeederDrive(false, 1.0, SmartDashboard.getNumber("PolyWhisk RPM", Globals.POLYWHISK_FRPM)));
	}

}
