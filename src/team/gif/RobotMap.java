package team.gif;

import edu.wpi.first.wpilibj.DigitalSource;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// CAN Addresses
	public static final int FRONT_RIGHT_DRIVE	= 3; //9
	public static final int MID_RIGHT_DRIVE		= 60;
	public static final int REAR_RIGHT_DRIVE	= 0; //4
	public static final int FRONT_LEFT_DRIVE	= 1; //7
	public static final int MID_LEFT_DRIVE		= 61;
	public static final int REAR_LEFT_DRIVE		= 2; //8
	public static final int COLLECTOR			= 50;
	public static final int FEEDER				= 52;
	public static final int POLY_WHISK			= 53;
	public static final int FLYWHEEL_1			= 5;
	public static final int FLYWHEEL_2			= 6;
	public static final int TURRET				= 51;
	public static final int CLIMBER_1			= 15;
	public static final int CLIMBER_2			= 16;
	
	// Relay Ports
	public static final int GEAR_HANGER 		= 5;
	public static final int VERSA__DROP			= 6;
	public static final int SHIFTER				= 7;

}
