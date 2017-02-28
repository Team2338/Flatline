package team.gif.commands.shooter;

import lib.gif.commands.CommandGroup;

public class CameraFollowAndRev extends CommandGroup {

    public CameraFollowAndRev() {
    	addParallel(new RevFlywheel());
    	addSequential(new CameraFollow());
    }
    
}
