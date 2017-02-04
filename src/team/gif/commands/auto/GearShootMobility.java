package team.gif.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team.gif.commands.shooter.TurretAndShoot;

//enan was here
public class GearShootMobility extends CommandGroup {

    public GearShootMobility() {
    	addSequential(new Mobility(0.25,0.25));
        addSequential(new GearGrab());
        addSequential(new TurretAndShoot());
    }
}
