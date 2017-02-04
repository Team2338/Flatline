package team.gif.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team.gif.commands.shooter.TurretAndShoot;

//enan was here
public class GearShootMobility extends CommandGroup {

//	private final WAIT_TIME = 0.0;

    public GearShootMobility() {
//    	addSequential(new WaitCommand(WAIT_TIME));
    	addSequential(new Mobility(0.25,0.25));
//    	addSequential(new WaitCommand(WAIT_TIME));
        addSequential(new GearGrab());
//    	addSequential(new WaitCommand(WAIT_TIME));
        addSequential(new TurretAndShoot());
//    	addSequential(new WaitCommand(WAIT_TIME));
    }
}
