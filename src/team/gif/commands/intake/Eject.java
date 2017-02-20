package team.gif.commands.intake;

import lib.gif.commands.CommandGroup;

public class Eject extends CommandGroup {

	public Eject() {
		addParallel(new CollectorDrive(-1));
		addParallel(new FeederDrive(false, -0.5)); //TODO: Make sure this works
	}
	
}
