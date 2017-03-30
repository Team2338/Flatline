package team.gif.commands;

import lib.gif.commands.CommandGroup;
import team.gif.commands.shooter.ResetTurret;

public class RetractCollector extends CommandGroup {

    public RetractCollector() {
    	addSequential(new ResetTurret(true));
    	addSequential(new CollectorIn(true));
    }    
}
