package team.gif.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team.gif.commands.GearRelease;
import team.gif.commands.drivetrain.GyroDrive;

//enan was here

public class GearGrab extends CommandGroup {

//	private final WAIT_TIME = 0.0;
	
    public GearGrab() {
    	addSequential(new GyroDrive(0.1,0.1));
//    	addSequential(new WaitCommand(WAIT_TIME));
    	addSequential(new GearRelease(true));
    	// TODO: Turn 180 degrees
    	addSequential(new GyroDrive(-0.1,-0.1));
    }
}
