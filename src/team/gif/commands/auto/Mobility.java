package team.gif.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team.gif.commands.drivetrain.Drive;

// enan was here
 
public class Mobility extends CommandGroup {

//	private final WAIT_TIME = 0.0;

public Mobility(double x, double y) {
//		addSequential(new WaitCommand(WAIT_TIME));
    	addSequential(new Drive(x,y));
//    	addSequential(new WaitCommand(WAIT_TIME));
        
    }
}
