package team.gif;

/**
 * This file is meant for easily changing values in code.
 * It should be simple enough that Enan can do it.
 */
public class Globals {
	
//	Drivetrain
	public static final double DEAD_ZONE				= 0.1;
	public static final double DRIVETRAIN_P				= 0.0003;
	public static final double DRIVETRAIN_I				= 0;
	public static final double DRIVETRAIN_D 			= 0;
	public static final double DRIVE_STRAIGHT_ANGLE_P	= 0.0006;
	public static final double DRIVE_ANGLE_P			= 0.02;
	public static final double DRIVE_ANGLE_I			= 0.001;
	public static final double DRIVE_ANGLE_D			= 0;
	public static final double DRIVE_ANGLE_IZONE		= 3.0;
	public static final double DRIVE_DIST_TOLERANCE 	= 200; // Ticks
	public static final double DRIVE_ANGLE_TOLERANCE	= 3; // Degrees
	public static final double TICKS_PER_INCH 			= (512.0*3.0*(50.0/34.0))/(4.0*Math.PI);
	
//	Shooter
	// SP: Straight Peg | FH: Far Hopper
	public static final double FLYWHEEL_P_SP			= 0.04;
	public static final double FLYWHEEL_I_SP 			= 0.0001;
	public static final double FLYWHEEL_D_SP 			= 0.6;
	public static final double FLYWHEEL_F_SP			= 0.025;
	public static final double FLYWHEEL_P_FH			= 0.02;
	public static final double FLYWHEEL_I_FH 			= 0.00001;
	public static final double FLYWHEEL_D_FH 			= 0.2;
	public static final double FLYWHEEL_F_FH			= 0.024;
	public static final int FLYWHEEL_I_ABOVE 			= 2000; // 2000
	public static final int FLYWHEEL_I_BELOW 			= 1750; // 1750
	public static final double FLYWHEEL_RPM_SP			= 25800; // Default value: 25800 |  Straight peg: 25800 | Far hopper: 23500
	public static final double FLYWHEEL_RPM_FH			= 23500;
	public static final double RPM_PER_INCH				= 42; // based on empirical data
	public static final double RPM_MULTIPLIER 			= 4096d/600d; // QuadEncoder Ticks Per Rev / Milliseconds
	public static final double SHOOTER_TOLERANCE 		= 2000; // ticks
	
//	Feeder
	public static final double POLYWHISK_P				= 0.0003;
	public static final double POLYWHISK_I				= 0;
	public static final double POLYWHISK_D				= 0;
	public static final double POLYWHISK_F				= 0.073;
	public static final int POLYWHISK_IZONE				= 100;
	public static final double POLYWHISK_FRPM			= 1800; // forward
	public static final double POLYWHISK_RRPM			= -600; // reverse
	
//	Turret
	public static final double TURRET_P 				= 0.43; // 0.8
	public static final double TURRET_I 				= 0.0001; // 0.00000001
	public static final double TURRET_D 				= 0; // 60.0
	public static final int TURRET_I_ZONE 				= 0;
	public static final double TURRET_POS	 			= 35d/8d; // 140/32 Encoder Counts per Rev
	public static final double TURRET_ANGLE_TO_TICK		= 7d/576d; // 140/32/360
	public static final double TURRET_TOLERANCE			= 0.0001; // ticks
	public static final double TURRET_REDPOS			= 1; // TODO: figure out ticks
	public static final double TURRET_BLUEPOS			= 0.257; // TODO: figure out ticks
	
// 	Vision
	public static final double VISION_TOLERANCE 		= 1.5; // degrees
	public static final double CAMERA_CENTER_X			= 240; // 480 (length of frame) / 2
	public static final double CAMERA_CENTER_Y 			= 180;
	public static final double CAMERA_HFOV				= 51.229919; // degrees as seen on GRIP
	public static final double CAMERA_VFOV				= 39.55520044; // degrees as seen on GRIP
}
