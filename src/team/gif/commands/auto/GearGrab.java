package team.gif.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team.gif.commands.GearRelease;
import team.gif.commands.drivetrain.Drive;

//enan was here

public class GearGrab extends CommandGroup {

//	private final WAIT_TIME = 0.0;
	
    public GearGrab() {
    	addSequential(new Drive(0.1,0.1));
    	addSequential(new GearRelease(false));
//    	addSequential(new WaitCommand(WAIT_TIME));
    	addSequential(new GearRelease(true));
    	addSequential(new Drive(-0.1,-0.1));
    }
}
