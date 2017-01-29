package team.gif.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team.gif.commands.GearIn;
import team.gif.commands.drivetrain.Drive;
import team.gif.subsystems.Drivetrain;

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
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
