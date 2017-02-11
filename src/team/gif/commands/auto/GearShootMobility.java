package team.gif.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team.gif.Globals;
import team.gif.commands.GearRelease;
import team.gif.commands.shooter.CameraShoot;

public class GearShootMobility extends CommandGroup {

    public GearShootMobility() {
    	addSequential(new DriveStraightEnc(Globals.DRIVE_DIST));
    	addSequential(new GearRelease(true));
        addSequential(new CameraShoot());
    }
}
