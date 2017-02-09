package team.gif.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team.gif.commands.drivetrain.GyroDrive;
import team.gif.commands.shooter.CameraShoot;

//enan was here
public class GearShootMobility extends CommandGroup {

//	private final WAIT_TIME = 0.0;

    public GearShootMobility() {
//    	addSequential(new WaitCommand(WAIT_TIME));
    	addSequential(new GyroDrive(0.25,0.25,5));
//    	addSequential(new WaitCommand(WAIT_TIME));
        addSequential(new GearGrab());
//    	addSequential(new WaitCommand(WAIT_TIME));
        addSequential(new CameraShoot());
//    	addSequential(new WaitCommand(WAIT_TIME));
    }
}
