package team.gif.commands.shooter;

import lib.gif.commands.CommandGroup;
import team.gif.Globals;
import team.gif.commands.intake.FeederDrive;
import team.gif.commands.shooter.RevFlywheel;

public class SpewOut extends CommandGroup {

    public SpewOut() {
    	addParallel(new RevFlywheel(true));
    	addParallel(new FeederDrive(true, false, 1.0, Globals.POLYWHISK_FRPM));
    }
    
}