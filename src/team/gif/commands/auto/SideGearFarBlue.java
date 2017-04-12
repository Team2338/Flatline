package team.gif.commands.auto;

import lib.gif.commands.CommandGroup;
import team.gif.commands.GearRelease;
import team.gif.commands.WaitCommand;
import team.gif.commands.drivetrain.ResetGyro;
import team.gif.commands.drivetrain.ShiftOmni;
import team.gif.commands.drivetrain.ShifterLow;
import team.gif.commands.shooter.ResetTurret;

/**
 *
 */
public class SideGearFarBlue extends CommandGroup {

    public SideGearFarBlue() {
    	addParallel(new ShifterLow(true));
    	addParallel(new ShiftOmni(true));
    	addSequential(new ResetGyro());
    	addSequential(new WaitCommand(0.4));
    	addSequential(new ResetTurret(false));
        addSequential(new DriveStraightEnc(-60.477, 0.75, 7));
        addSequential(new GyroTurn(60, 1.5));
        addSequential(new DriveStraightEnc(-82, 0.75, 7));
    	addParallel(new GearRelease(true, true, false));
    	addSequential(new WaitCommand(1.2));
    	addSequential(new DriveStraightEnc(12, 0.75, 7));
    }
}
