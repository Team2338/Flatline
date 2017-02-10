package team.gif.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team.gif.Globals;
import team.gif.commands.shooter.CameraShoot;

public class GearShootMobility extends CommandGroup {

//	private final WAIT_TIME = 0.0;

    public GearShootMobility() {
//    	addSequential(new WaitCommand(WAIT_TIME));
    	addSequential(new  DriveStraightEnc(Globals.DRIVE_DIST));
//    	addSequential(new WaitCommand(WAIT_TIME));
        addSequential(new GearGrab());
//    	addSequential(new WaitCommand(WAIT_TIME));
        addSequential(new CameraShoot());
//    	addSequential(new WaitCommand(WAIT_TIME));
    }
}
