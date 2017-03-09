package team.gif.commands;

import lib.gif.commands.CommandGroup;
import team.gif.Globals;
import team.gif.commands.shooter.ResetTurret;
import team.gif.commands.shooter.TurretTurn;

public class RetractCollector extends CommandGroup {

    public RetractCollector() {
    	addSequential(new ResetTurret());
    	addSequential(new CollectorIn(true));
    }    
}
