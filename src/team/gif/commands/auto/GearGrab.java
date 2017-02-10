package team.gif.commands.auto;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team.gif.Globals;
import team.gif.commands.GearRelease;
import team.gif.commands.drivetrain.GyroTurn;



public class GearGrab extends CommandGroup {
	
    public GearGrab() {
    	addSequential(new  DriveStraightEnc(Globals.DRIVE_DIST));
//    	addSequential(new WaitCommand(WAIT_TIME));
    	addSequential(new GearRelease(false));
    	addSequential(new GearRelease(true));
    	// TODO: Turn 180 degrees
    	addSequential(new GyroTurn(180));
    	addSequential(new  DriveStraightEnc(Globals.DRIVE_DIST));
    }
}
