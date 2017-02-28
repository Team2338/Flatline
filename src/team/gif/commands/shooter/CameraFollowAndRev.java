package team.gif.commands.shooter;

import lib.gif.commands.CommandGroup;

/**
 *
 */
public class CameraFollowAndRev extends CommandGroup {

    public CameraFollowAndRev() {
    	addParallel(new CameraFollow());
    	addParallel(new RevFlywheel());
    }
}
