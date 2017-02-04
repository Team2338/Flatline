package team.gif.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team.gif.commands.drivetrain.Drive;

// enan was here
 
public class Mobility extends CommandGroup {

public Mobility(double x, double y) {
    	
    	addSequential(new Drive(x,y));
        
    }
}
