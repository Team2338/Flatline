package team.gif.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team.gif.commands.GearRelease;
import team.gif.commands.drivetrain.GyroDrive;

/**
 *
 */
public class AutoGearPlacement extends CommandGroup {

    public AutoGearPlacement() {
    	addSequential(new GyroDrive(0.1,0.1,5));
//    	addSequential(new WaitCommand(WAIT_TIME));
       	addSequential(new GearRelease(false));
    	// TODO: Turn 180 degrees
    	addSequential(new GyroDrive(-0.8,0,5));
    	addSequential(new GyroDrive(-0.1,-0.1,5));
    }
}
