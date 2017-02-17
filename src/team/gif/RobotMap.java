package team.gif;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// CAN Addresses
	public static final int FRONT_RIGHT_DRIVE	= 11; //11 
	public static final int MID_RIGHT_DRIVE		= 14; //14
	public static final int REAR_RIGHT_DRIVE	= 13; //13 
	public static final int FRONT_LEFT_DRIVE	= 60; //6
	public static final int MID_LEFT_DRIVE		= 8; //8
	public static final int REAR_LEFT_DRIVE		= 1; //1
	public static final int COLLECTOR			= 12; //12
	public static final int FEEDER				= 2; //2
	public static final int POLY_WHISK			= 7; //7
	public static final int FLYWHEEL_1			= 3;
	public static final int FLYWHEEL_2			= 6;
	public static final int TURRET				= 5; //5
	public static final int CLIMBER_1			= 30; //3
	public static final int CLIMBER_2			= 0; //0
	
	// Relay Ports
	public static final int GEAR_HANGER1 		= 6;//6
//	public static final int GEAR_HANGER2		= 5;
	public static final int VERSA__DROP			= 5;//5
	public static final int SHIFTER				= 4;//4
	public static final int COLLECTORSOLA		= 0;//0
	public static final int COLLECTORSOLB		= 1;//1
	public static final int COLLECTORHOODSOL	= 7;//7
	
	// DIO Ports
	public static final int FLAPPY_SERVO		= 0;

}
