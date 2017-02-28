package team.gif;

/**
 * This file is meant for easily changing values in code.
 * It should be simple enough that mechanical can do it.
 */
public class Globals {
	
//	Drivetrain
	public static final double DEAD_ZONE				= 0.25;
	public static final double DRIVETRAIN_P				= 0;
	public static final double DRIVETRAIN_I				= 0;
	public static final double DRIVETRAIN_D 			= 0;
	public static final double DRIVE_ANGLE_P			= 0;
	public static final double DRIVE_ANGLE_I			= 0;
	public static final double DRIVE_ANGLE_D			= 0;
	public static final double DRIVE_DIST				= 10000;
	public static final double DRIVE_DIST_TOLERANCE 	= 250;
	public static final double DRIVE_ANGLE_TOLERANCE	= 0.5;
	
//	Shooter
	public static final double FLYWHEEL_P 				= 0.028; // 0.415
	public static final double FLYWHEEL_I 				= 0.00001; // 0.00001
	public static final double FLYWHEEL_D 				= 0.0; // 0.0
	public static final double FLYWHEEL_F				= 0.026; // 0.026
//	public static final int FLYWHEEL_I_ZONE 			= 1200;  //
	public static final int FLYWHEEL_I_ABOVE 			= 500; // 500
	public static final int FLYWHEEL_I_BELOW 			= 1500; // 1500
	public static final double FLYWHEEL_RPM				= 25300; // Straight peg: 27000 | 
	public static final double RPM_PER_INCH				= 42; // based on empirical data
	public static final double RPM_MULTIPLIER 			= 4096d/600d; // QuadEncoder Ticks Per Rev / Milliseconds
	public static final double revTime 					= 0;
	public static final double SHOOTER_TOLERANCE 		= 500; // ticks
	
//	Feeder
	public static final double FEEDER_P					= 0;
	public static final double FEEDER_I					= 0;
	public static final double FEEDER_D					= 0;
	public static final double FEEDER_F					= 0;
	public static final double FEEDER_FRPM				= 0; // forward
	public static final double FEEDER_RRPM				= 0; // reverse
	public static final double POLYWHISK_P				= 0;
	public static final double POLYWHISK_I				= 0;
	public static final double POLYWHISK_D				= 0;
	public static final double POLYWHISK_F				= 0;
	public static final double POLYWHISK_FRPM			= 0; // forward
	public static final double POLYWHISK_RRPM			= 0; // reverse
	
//	Turret
	public static final double TURRET_P 				= 0.43; // 0.8
	public static final double TURRET_I 				= 0.0001; // 0.00000001
	public static final double TURRET_D 				= 0; // 60.0
	public static final int TURRET_I_ZONE 				= 0;
	public static final double TURRET_POS	 			= 35d/8d; // 140/32 Encoder Counts per Rev
	public static final double TURRET_ANGLE_TO_TICK		= 7d/576d; // 140/32/360
	public static final double TURRET_TOLERANCE			= 0.01; // ticks
	public static final double TURRET_REDPOS			= 1; // TODO: figure out ticks
	public static final double TURRET_BLUEPOS			= -1.706; // TODO: figure out ticks
	
// 	Vision
	public static final double VISION_TOLERANCE 		= 1.5; // degrees
	public static final double CAMERA_CENTER_X			= 240; // 480 (length of frame) / 2
	public static final double CAMERA_CENTER_Y 			= 180;
	public static final double CAMERA_HFOV				= 51.229919; // degrees as seen on GRIP
	public static final double CAMERA_VFOV				= 39.55520044; // degrees as seen on GRIP
}
