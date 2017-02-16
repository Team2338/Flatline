package team.gif.commands.shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;
import team.gif.Globals;
import team.gif.OI;
import team.gif.Robot;
import team.gif.commands.intake.FeederDrive;

public class ManualShoot extends CommandGroup {

	public ManualShoot() {
		// addSequential(new WaitCommand(Globals.revTime));
		// TODO: Use IR sensor to determine when shooting finishes
		// ALTERNATIVE: Use velocity data to count shots
	}
	
	protected void execute() {
		if (OI.auxController.getRawAxis(3) > 0.1 && OI.auxController.getRawButton(5)) {
			new RevFlywheel();
			new FeederDrive();
		}
	}
	
}
