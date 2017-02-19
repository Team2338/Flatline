package team.gif;

/**
 * This file is meant for easily changing values in code.
 * It should be simple enough that mechanical can do it.
 */
public class Globals {
	
//	Drivetrain
	public static final double DEAD_ZONE				= 0.2;
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
	public static final double FLYWHEEL_P 				= 0.0415; // 0.415
	public static final double FLYWHEEL_I 				= 0.00001; // 0.00001
	public static final double FLYWHEEL_D 				= 0.0; // 0.0
	public static final double FLYWHEEL_F				= 0.026; // 0.026
//	public static final int FLYWHEEL_I_ZONE 			= 1200;  //
	public static final int FLYWHEEL_I_ABOVE 			= 500; // Turret: 500
	public static final int FLYWHEEL_I_BELOW 			= 1500; // Turret: 1500
	public static final double FLYWHEEL_RPM				= 26000; // 189 in: 25000 | 
	public static final double RPM_MULTIPLIER 			= 4096d/600d; // QuadEncoder Ticks Per Rev / Milliseconds
	public static final double revTime 					= 0;
	public static final double SHOOTER_TOLERANCE 		= 500; // ticks
	
//	Turret
	public static final double TURRET_P 				= 0.8; // 0.011 | 0.44
	public static final double TURRET_I 				= 0.00000001; // 0.00000001
	public static final double TURRET_D 				= 60.0; // 0.1
	public static final int TURRET_I_ZONE 				= 0;
	public static final double TURRET_POS	 			= 35d/8d; // 140/32 Encoder Counts per Rev
	public static final double TURRET_ANGLE_TO_TICK		= 7d/576d; // 140/32/360
	public static final double TURRET_TOLERANCE			= 0.01; // ticks
	public static final double TURRET_REDPOS			= 1; // TODO: figure out ticks
	public static final double TURRET_BLUEPOS			= 2; // TODO: figure out ticks
	
// 	Vision
	public static final double VISION_TOLERANCE 		= 3; // degrees
	public static final double CAMERA_CENTER_X			= 240; // 480 (length of frame) / 2
	public static final double CAMERA_CENTER_Y 			= 180;
	public static final double CAMERA_HFOV				= 51.229919; // degrees as seen on GRIP
	public static final double CAMERA_VFOV				= 39.55520044; // degrees as seen on GRIP
}
