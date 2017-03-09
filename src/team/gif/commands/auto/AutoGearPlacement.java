package team.gif.commands.auto;

import lib.gif.commands.CommandGroup;
import team.gif.commands.GearRelease;
import team.gif.commands.WaitCommand;
import team.gif.commands.drivetrain.ShifterLow;
import team.gif.commands.shooter.ResetTurret;

public class AutoGearPlacement extends CommandGroup {

	public AutoGearPlacement() {
		addSequential(new ResetTurret());
		addParallel(new ShifterLow(false));
		addSequential(new DriveStraightEnc(-14100));
    	addParallel(new WaitCommand(0.3));
		addSequential(new GearRelease(true));
		addSequential(new DriveStraightEnc(2157));
		addSequential(new GyroTurn(180));
	}
	
}
