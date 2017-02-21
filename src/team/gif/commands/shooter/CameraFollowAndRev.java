package team.gif.commands.shooter;

import lib.gif.commands.CommandGroup;
import team.gif.OI;

public class CameraFollowAndRev extends CommandGroup {

    public CameraFollowAndRev() {
    	addParallel(new CameraFollow());
    	addParallel(new RevFlywheel(true));
    }
    
}
