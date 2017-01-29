package team.gif.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team.gif.commands.GearIn;
import team.gif.commands.drivetrain.Drive;

/**
 *
 */
public class GearGrab extends CommandGroup {

    public GearGrab() {
    	double lorem = 0;
    	double ipsum = 0;
    	addSequential(new Drive(lorem, ipsum));
    	addSequential(new GearIn());
    	addSequential(new Drive(-lorem,-ipsum));
    }
}
