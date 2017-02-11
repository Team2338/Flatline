package team.gif.commands.shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CameraFollowAndRev extends CommandGroup {

    public CameraFollowAndRev() {
		addParallel(new CameraFollow());
		addParallel(new RevFlywheel());
    }
}
