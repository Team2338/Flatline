package team.gif.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team.gif.commands.shooter.TurretTurn;

public class ClimberUp extends CommandGroup {

    public ClimberUp() {
    	addSequential(new TurretTurn(7d/6d)); // 140/30/4
    	addSequential(new CollectorIn(true));
    	addSequential(new ClimberDrive(1));
    }
    
}
