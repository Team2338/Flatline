package team.gif.commands.shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team.gif.OI;

public class CameraFollowAndRev extends CommandGroup {

    public CameraFollowAndRev() {

    }
    
    protected void execute() {
    	if (OI.auxController.getRawAxis(2) > 0.1) {
    		new CameraFollow();
    		new RevFlywheel();
    	}	
    }
    
}
