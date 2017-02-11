package team.gif.commands.intake;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class Eject extends CommandGroup {

    public Eject() {
    	addParallel(new CollectorDrive(-1));
    	addParallel(new FeederDrive(false, -1));
    }
}
