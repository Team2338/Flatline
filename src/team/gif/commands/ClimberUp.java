package team.gif.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team.gif.Globals;
import team.gif.commands.shooter.TurretTurn;

public class ClimberUp extends CommandGroup {

    public ClimberUp() {
    	addSequential(new TurretTurn(Globals.TURRET_POS/4d)); // 140/32/4
    	addSequential(new CollectorIn(true));
    	addSequential(new ClimberDrive(1));
    }
    
}
