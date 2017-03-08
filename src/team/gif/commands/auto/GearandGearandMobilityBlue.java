package team.gif.commands.auto;

import lib.gif.commands.CommandGroup;
import team.gif.commands.GearRelease;
import team.gif.commands.WaitCommand;

public class GearandGearandMobilityBlue extends CommandGroup {

    public GearandGearandMobilityBlue() {
    	addSequential(new DriveStraightEnc(-14100));
    	addSequential(new GearRelease(true));
    	addSequential(new DriveStraightEnc(1535));
    	addSequential(new GyroTurn(90));
    	addSequential(new DriveStraightEnc(-22685));
    	addSequential(new GyroTurn(-90));
    	addSequential(new DriveStraightEnc(-46240));
    	addSequential(new GyroTurn(30));
    	addSequential(new DriveStraightEnc(-3419));
    	addSequential(new WaitCommand(2.5));
    	addSequential(new DriveStraightEnc(3419));
    	addSequential(new GyroTurn(-30));
    	addSequential(new DriveStraightEnc(46240));
    	addSequential(new GyroTurn(90));
    	addSequential(new DriveStraightEnc(-22685));
    	addSequential(new GyroTurn(-90));
    	addSequential(new DriveStraightEnc(-1535));
    	addSequential(new GearRelease(true));
    	addSequential(new DriveStraightEnc(1535));
    	addSequential(new GyroTurn(45));
    	addSequential(new DriveStraightEnc(-2000));
    }
}