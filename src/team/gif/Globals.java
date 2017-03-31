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
	public static final double DRIVE_STRAIGHT_ANGLE_P	= 0.04; //  Peoria: 0.0012
	public static final double DRIVE_ANGLE_P			= 0.022;
	public static final double DRIVE_ANGLE_I			= 0.001;
	public static final double DRIVE_ANGLE_D			= 0;
	public static final double DRIVE_ANGLE_IZONE		= 3.0;
	public static final double DRIVE_DIST_TOLERANCE 	= 1000; // Ticks
	public static final double DRIVE_ANGLE_TOLERANCE	= 3; // Degrees
	public static final double TICKS_PER_INCH 			= (512.0*3.0*(50.0/34.0))/(4.0*Math.PI);
	
//	Shooter
	// CP: Center Peg | FH: Far Hopper | SP = Side Peg
	public static final double FLYWHEEL_P_CP			= 0.04;
	public static final double FLYWHEEL_I_CP 			= 0.0004;
	public static final double FLYWHEEL_D_CP 			= 1.4;
	public static final double FLYWHEEL_F_CP			= 0.025;
	public static final double FLYWHEEL_P_FH			= 0.02;
	public static final double FLYWHEEL_I_FH 			= 0.00001;
	public static final double FLYWHEEL_D_FH 			= 0.8;
	public static final double FLYWHEEL_F_FH			= 0.0237;
	public static final double FLYWHEEL_P_SP			= 0.006;
	public static final double FLYWHEEL_I_SP			= 0.00002;
	public static final double FLYWHEEL_D_SP			= 1.0;
	public static final double FLYWHEEL_F_SP			= 0.02323;
	public static final int FLYWHEEL_I_ABOVE 			= 2750; // 2750
	public static final int FLYWHEEL_I_BELOW 			= 1750; // 1750
	public static final double FLYWHEEL_RPM_CP			= 25850; // 25850
	public static final double FLYWHEEL_RPM_FH			= 23950; // 23950
	public static final double FLYWHEEL_RPM_SP			= 24760; // 24750
	public static final double FLYWHEEL_RPM_EJECT		= 12000; // 12000 (for spewing balls out)
	public static final double SHOOTER_TOLERANCE 		= 2000; // ticks
	
//	Feeder
	public static final double POLYWHISK_P				= 0.0005;
	public static final double POLYWHISK_I				= 0;
	public static final double POLYWHISK_D				= 0.05;
	public static final double POLYWHISK_F				= 0.079;
	public static final int POLYWHISK_IZONE				= 100;
	public static final double POLYWHISK_FRPM			= 900; // forward
	public static final double POLYWHISK_RRPM			= -600; // reverse
	
//	Turret
	public static final double TURRET_P 				= 0.38;
	public static final double TURRET_I 				= 0.0002;
	public static final double TURRET_D 				= 3.8;
	public static final int TURRET_I_ZONE 				= 150;
	public static final double TURRET_POS	 			= 35d/8d; // 140/32 Encoder Counts per Rev
	public static final double TURRET_ANGLE_TO_TICK		= 7d/576d; // 140/32/360
	public static final double TURRET_TOLERANCE			= 0.0001; // ticks
	
// 	Vision
	// CP: Center Peg | FH: Far Hopper | SP = Side Peg | MS = Auto mobility and shoot
	public static final double VISION_TOLERANCE 		= 1.7; // degrees
	public static final double CAMERA_CENTER_X_CP		= 260; // 275
	public static final double CAMERA_CENTER_X_FH		= 265; // 260
	public static final double CAMERA_CENTER_X_SP		= 270;
	public static final double CAMERA_CENTER_X_MS		= 265;
	public static final double CAMERA_CENTER_Y 			= 180;
	public static final double CAMERA_HFOV				= 51.229919; // degrees as seen on GRIP
	public static final double CAMERA_VFOV				= 39.55520044; // degrees as seen on GRIP
}
