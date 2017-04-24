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
	// TODO: Tune all new PIDF values with sidewheels
	public static final double FLYWHEEL_P_CP			= 0.05; // New: 0.12 | Midwest: 0.04 (0.011) (0.045) (0.05)
	public static final double FLYWHEEL_I_CP 			= 0.0003; // New: 0.0004 | Midwest: 0.0004 (0.0001) (0.00025) (0.0035)
	public static final double FLYWHEEL_D_CP 			= 0.5; // New: 2.4 | Midwest: 1.4 (2.0) (0.4) (0.5)
	public static final double FLYWHEEL_F_CP			= 0.02322; // New: 0.02389 | Midwest: 0.025 (0.0229) (0.0225) (0.0229)
	public static final double FLYWHEEL_P_FH			= 0.032; // 0.016 for 64 measurement window; 0.032 for 32 measurement window
	public static final double FLYWHEEL_I_FH 			= 0.00002;
	public static final double FLYWHEEL_D_FH 			= 0.16;
	public static final double FLYWHEEL_F_FH			= 0.02228; // 0.02235
	public static final double FLYWHEEL_P_SP			= 0.016; // New: 0.012 | Midwest: 0.006
	public static final double FLYWHEEL_I_SP			= 0.0001; // New: 0.00004 | Midwest: 0.0002
	public static final double FLYWHEEL_D_SP			= 0.16; // New: 0.2 | Midwest: 1.0
	public static final double FLYWHEEL_F_SP			= 0.02225; // New: 0.02384 | Midwest: 0.02323
//	public static final double FLYWHEEL_P_FSP			= 0.026;
//	public static final double FLYWHEEL_I_FSP			= 0.00002;
//	public static final double FLYWHEEL_D_FSP			= 0.3;
//	public static final double FLYWHEEL_F_FSP			= 0.02267;
	public static final int FLYWHEEL_I_ABOVE 			= 750; // New: 250 | Midwest: 2750
	public static final int FLYWHEEL_I_BELOW 			= 750; // New: 250 | Midwest: 1750
	public static final double FLYWHEEL_RPM_CP			= 25600; // 25950
	public static final double FLYWHEEL_RPM_FH			= 23825; // 23950
	public static final double FLYWHEEL_RPM_SP			= 24300; // 24750
//	public static final double FLYWHEEL_RPM_FSP			= 29150; // 29150
	public static final double FLYWHEEL_RPM_EJECT		= 12000; // 12000 (for spewing balls out)
	public static final double SHOOTER_TOLERANCE 		= 2000; // ticks
	
//	Feeder
	public static final double POLYWHISK_P				= 0.0005;
	public static final double POLYWHISK_I				= 0;
	public static final double POLYWHISK_D				= 0.05;
	public static final double POLYWHISK_F				= 0.079;
	public static final double POLYWHISK_F_FH			= 0.079;
	public static final int POLYWHISK_IZONE				= 100;
	public static final double POLYWHISK_FRPM			= 800; // forward
	public static final double POLYWHISK_FHRPM			= 1800; // far hopper
	public static final double POLYWHISK_RRPM			= -600; // reverse
	
//	Turret
	public static final double TURRET_P 				= 4.9; // 4.9 (1.3) 0.38
	public static final double TURRET_I 				= 0.0009; // 0.0004
	public static final double TURRET_D 				= 40.9; // 3.8
	public static final double TURRET_I_ZONE 			= 0.05; // 0.0378
	public static final double TURRET_POS	 			= 35d/8d; // 140/32 Encoder Counts per Rev
	public static final double TURRET_ANGLE_TO_TICK		= 7d/576d; // 140/32/360
	public static final double TURRET_TOLERANCE			= 0.0001; // ticks
	
// 	Vision
	// CP: Center Peg | FH: Far Hopper | SP = Side Peg | MS = Auto mobility and shoot
	public static final double VISION_TOLERANCE 		= 1.7; // degrees
	public static final double CAMERA_CENTER_X			= 240; 
//	public static final double CAMERA_CENTER_X_CP		= 260; // 260
//	public static final double CAMERA_CENTER_X_FH		= 272;
//	public static final double CAMERA_CENTER_X_SP		= 270;
//	public static final double CAMERA_CENTER_X_MS		= 265;
	public static final double CAMERA_OFFSET_CP			= 3.9; // degrees (Pixel conversion: 260) 2.2879442689 
	public static final double CAMERA_OFFSET_FH			= -0.8; // degrees (FH and FSP) (Pixel conversion: 272) 3.6576809278
	public static final double CAMERA_OFFSET_SP			= 1.6; // degrees (Pixel conversion: 270) (240)
	public static final double CAMERA_OFFSET_MS			= 2.8590759970; // degrees (Pixel conversion: 265)
//	public static final double CAMERA_OFFSET_FSP		= 3.9;
	public static final double CAMERA_CENTER_Y 			= 180;
	public static final double CAMERA_HFOV				= 51.229919; // degrees as seen on GRIP
	public static final double CAMERA_VFOV				= 39.55520044; // degrees as seen on GRIP
}
