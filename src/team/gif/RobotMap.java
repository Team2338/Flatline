package team.gif;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// CAN Addresses
	public static final int FRONT_RIGHT_DRIVE	= 4; //P: 4 // C: 4
	public static final int MID_RIGHT_DRIVE		= 5; //P: 5 // C: 5
	public static final int REAR_RIGHT_DRIVE	= 6; //P: 6 // C: 6
	public static final int FRONT_LEFT_DRIVE	= 1; //P: 1 // C: 1
	public static final int MID_LEFT_DRIVE		= 2; //P: 2 // C: 2
	public static final int REAR_LEFT_DRIVE		= 3; //P: 3 // C: 3
	public static final int COLLECTOR			= 10; //P: 10 // C: 10 
	public static final int FEEDER				= 9; //P: 9 // C: 9
	public static final int POLY_WHISK			= 8; //P: 8 // C: 8
	public static final int FLYWHEEL_1			= 14;//P: 14 // C: 14
	public static final int FLYWHEEL_2			= 13;//P: 13 // C: 13
	public static final int TURRET				= 7; //P: 7 // C: 7
	public static final int CLIMBER_1			= 12; //P: 11 // C: 12 // TODO: Need to recheck
//	public static final int CLIMBER_2			= 12; //P: 0 // C: 12
	
	// Relay Ports
	public static final int GEAR_HANGER1 		= 4;//P: 6 // C: 4
//	public static final int GEAR_HANGER2		= 5;
	public static final int VERSA__DROP			= 5;//P: 4 // C: 5
	public static final int SHIFTER				= 7;//P: 5 // C: 7
	public static final int COLLECTORSOLA		= 0;//P: 0 // C: 0
	public static final int COLLECTORSOLB		= 1;//P: 1 // C: 1
	public static final int COLLECTORHOODSOL	= 6;//P: 7 // C: 6
	
	// DIO Ports
	public static final int PEGSENSOR			= 0;//Needs to be tuned
	public static final int FLAPPY				= 9;//P: 0 // C: 9

}
