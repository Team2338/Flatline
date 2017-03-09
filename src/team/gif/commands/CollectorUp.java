package team.gif.commands;

import lib.gif.commands.CommandGroup;
import team.gif.commands.shooter.ResetTurret;

public class CollectorUp extends CommandGroup {

    public CollectorUp() {
    	addSequential(new ResetTurret());
    	addSequential(new CollectorIn(true));
    }
    
}
