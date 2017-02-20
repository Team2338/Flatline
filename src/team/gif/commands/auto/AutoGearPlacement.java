package team.gif.commands.auto;

import lib.gif.commands.CommandGroup;
import team.gif.Globals;
import team.gif.commands.GearRelease;

public class AutoGearPlacement extends CommandGroup {

	public AutoGearPlacement() {
		addSequential(new DriveStraightEnc(Globals.DRIVE_DIST));
//    	addSequential(new WaitCommand(WAIT_TIME));
		addSequential(new GearRelease(true));
		addSequential(new GyroTurn(180));
		addSequential(new DriveStraightEnc(Globals.DRIVE_DIST));
	}
	
}
