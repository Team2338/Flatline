package team.gif.commands.auto;

import static team.gif.Robot.grip;

import edu.wpi.first.wpilibj.command.Command;
import lib.gif.Logger;
import team.gif.Robot;

/**
 *
 */
public class CameraTest extends Command {
	
	private double centerX;

    public CameraTest() {
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if (grip.getNumberArray("myContoursReport/centerX", new Double[] {0.0}) != null) {
    		
//    		Logger.println("Array length:  " +
//    		grip.getNumberArray("myContoursReport/centerX", new Double[] {0.0}).length, logFile);
    		
    		if (grip.getNumberArray("myContoursReport/centerX", new Double[] {0.0}).length > 0) {
    			
    			int index = 0;
    			
    			if (grip.getNumberArray("myContoursReport/centerX", new Double[] {0.0}).length > 1) {
    				
    				for (int i = 0;
    						
    					 i < grip.getNumberArray("myContoursReport/centerX", new Double[] {0.0}).length;
    					 i++) {
    					
    					if (grip.getNumberArray("myContoursReport/width", new Double[] {0.0})[index] <
    							grip.getNumberArray("myContoursReport/width", new Double[] {0.0})[i]) {
    							index = i;
    					}
    				}
    			}
//    			Logger.println("Selecting index " + index, logFile);
    			centerX = grip.getNumberArray("myContoursReport/centerX", new Double[] {0.0})[index];
    		} else {
    			
    			centerX = 0;
    		}
    	}
    }

    protected void execute() {

    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }


    protected void interrupted() {
    }
}
