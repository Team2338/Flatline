package team.gif;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// CAN Addresses
	public static final int FRONT_RIGHT_DRIVE	= 1; //P: 11 // C: 1
	public static final int MID_RIGHT_DRIVE		= 2; //P: 14 // C: 2
	public static final int REAR_RIGHT_DRIVE	= 3; //P: 13 // C: 3
	public static final int FRONT_LEFT_DRIVE	= 4; //P: 6 // C: 4
	public static final int MID_LEFT_DRIVE		= 5; //P:1 // C: 5
	public static final int REAR_LEFT_DRIVE		= 6; //P: 1 // C: 6
	public static final int COLLECTOR			= 7; //P: 12 // C: 7
	public static final int FEEDER				= 8; //P: 2 // C: 8
	public static final int POLY_WHISK			= 9; //P: 7 // C: 9
	public static final int FLYWHEEL_1			= 10;//P: 15 // C: 10
	public static final int FLYWHEEL_2			= 11;//P: 16 // C: 11
	public static final int TURRET				= 12; //P: 5 // C: 12
	public static final int CLIMBER_1			= 13; //P: 3 // C: 13
	public static final int CLIMBER_2			= 14; //P: 0 // C: 14
	
	// Relay Ports
	public static final int GEAR_HANGER1 		= 4;//P: 6 // C: 4
//	public static final int GEAR_HANGER2		= 5;
	public static final int VERSA__DROP			= 5;//P: 5 // C: 5
	public static final int SHIFTER				= 7;//P: 4 // C: 7
	public static final int COLLECTORSOLA		= 0;//P: 0 // C: 0
	public static final int COLLECTORSOLB		= 1;//P: 1 // C: 1
	public static final int COLLECTORHOODSOL	= 6;//P: 7 // C: 6
	
	// DIO Ports
	public static final int FLAPPY				= 9;//P: 0 // C: 9

}
