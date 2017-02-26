package team.gif.commands.auto;

import lib.gif.commands.CommandGroup;
import team.gif.commands.GearRelease;
import team.gif.commands.WaitCommand;

public class GearandGearandMobilityBlue extends CommandGroup {

    public GearandGearandMobilityBlue() {
    	addSequential(new DriveStraightEnc(13815));
    	addSequential(new GearRelease(true));
    	addSequential(new DriveStraightEnc(-7440));
    	addSequential(new GyroTurn(90));
    	addSequential(new DriveStraightEnc(110000));
    	addSequential(new GyroTurn(-90));
    	addSequential(new DriveStraightEnc(240000));
    	addSequential(new GyroTurn(30));
    	addSequential(new DriveStraightEnc(16578));
    	addSequential(new WaitCommand(2.5));
    	addSequential(new DriveStraightEnc(-16578));
    	addSequential(new GyroTurn(-30));
    	addSequential(new DriveStraightEnc(-240000));
    	addSequential(new GyroTurn(90));
    	addSequential(new DriveStraightEnc(110000));
    	addSequential(new GyroTurn(-90));
    	addSequential(new DriveStraightEnc(7440));
    	addSequential(new GearRelease(true));
    	addSequential(new DriveStraightEnc(-7440));
    	addSequential(new GyroTurn(45));
    	addSequential(new DriveStraightEnc(12400));
    }
}