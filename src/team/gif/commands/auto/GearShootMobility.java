package team.gif.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team.gif.commands.shooter.TurretAndShoot;

//enan was here
public class GearShootMobility extends CommandGroup {

    public GearShootMobility() {
    	addSequential(new Mobility());
        addSequential(new GearGrab());
        addSequential(new TurretAndShoot());
    }
}
