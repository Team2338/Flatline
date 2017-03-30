package team.gif.commands.auto;

import lib.gif.commands.CommandGroup;
import team.gif.commands.CollectorIn;
import team.gif.commands.WaitCommand;
import team.gif.commands.drivetrain.ResetGyro;
import team.gif.commands.drivetrain.ShiftOmni;
import team.gif.commands.drivetrain.ShifterLow;
import team.gif.commands.shooter.ResetTurret;

public class Mobility extends CommandGroup {

    public Mobility() {
    	addParallel(new ShifterLow(true));
    	addParallel(new ShiftOmni(true));
    	addSequential(new ResetGyro());
    	addSequential(new WaitCommand(0.4, true));
    	addSequential(new ResetTurret(true));
    	addSequential(new DriveStraightEnc(-120, 0.75, 9));
    	addParallel(new CollectorIn(false));
    }
}
