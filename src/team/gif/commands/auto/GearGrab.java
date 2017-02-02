package team.gif.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team.gif.commands.GearIn;
import team.gif.commands.GearOut;
import team.gif.commands.drivetrain.Drive;

/**
 *wait command time out amount?
 *enan was here
 */

public class GearGrab extends CommandGroup {

//	private final WAIT_TIME = 0.0;
    public GearGrab() {
    	
    	addSequential(new Drive(0.1,0.1));
    	addSequential(new GearOut());
//    	addSequential(new WaitCommand(WAIT_TIME));
    	addSequential(new GearIn());
    	addSequential(new Drive(-0.1,-0.1));
   
    	   }
}
