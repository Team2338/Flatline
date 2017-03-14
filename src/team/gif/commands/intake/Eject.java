package team.gif.commands.intake;

import lib.gif.commands.CommandGroup;
import team.gif.Globals;

public class Eject extends CommandGroup {

	public Eject() {
		addParallel(new CollectorDrive(-1));
		addParallel(new FeederDrive(false, false, -0.4, Globals.POLYWHISK_RRPM));
	}	
}
