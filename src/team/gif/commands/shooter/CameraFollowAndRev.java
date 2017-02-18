package team.gif.commands.shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team.gif.OI;

public class CameraFollowAndRev extends CommandGroup {

    public CameraFollowAndRev() {
    	addParallel(new CameraFollow());
    	addParallel(new RevFlywheel());
    }
    
}
