package team.gif.commands.auto;

import lib.gif.commands.CommandGroup;
import team.gif.commands.CollectorIn;
import team.gif.commands.WaitCommand;
import team.gif.commands.drivetrain.ResetGyro;
import team.gif.commands.drivetrain.ShiftOmni;
import team.gif.commands.drivetrain.ShifterLow;
import team.gif.commands.shooter.ResetTurret;
import team.gif.subsystems.Limelight;
public class Follow extends CommandGroup {

    public Mobility() {
    	addParallel(new drive(true));
    	addSequential(new WaitCommand(0.4, true);
    	addSequential(new DriveStraightEnc(getdistance(), 0.75, 9));
    }
}