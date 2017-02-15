package team.gif.commands.shooter;

import edu.wpi.first.wpilibj.command.CommandGroup;
import team.gif.OI;
import team.gif.commands.intake.FeederDrive;

/**
 *
 */
public class CameraFeeder extends CommandGroup {

    public CameraFeeder() {}
    
    protected void execute() {
    	if (OI.xboxController.getRawAxis(3) > 0.1 && !OI.xboxController.getRawButton(5))
    		new FeederDrive(true);
    }
}
