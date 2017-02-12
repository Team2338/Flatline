package team.gif;

public class Globals {
	
//	Drivetrain
	public static final double DEAD_ZONE				= 0.1;
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
	public static final double FLYWHEEL_P 				= 0.011;     // PVC: 0.14 Turret: .0048 New Turret: 0.01
	public static final double FLYWHEEL_I 				= 0.00001;     // PVC:  0.0005 Turret: .0001 New Turret: 0.0001
	public static final double FLYWHEEL_D 				= 0.01;	     // PVC: 0.001 Turret: 0.000 New Turret: 0.01
	public static final double FLYWHEEL_F				= 0.00835;  	 // PVC: 0.028 Turret: 0.0087 New Turret: 0.0084
//	public static final int FLYWHEEL_I_ZONE 			= 1200;  // PVC: 1200
	public static final int FLYWHEEL_I_ABOVE 			= 500; // Turret: 500
	public static final int FLYWHEEL_I_BELOW 			= 4000; // Turret: 2000
	public static final double FLYWHEEL_RPM				= 79550; // PVC: 22000 Turret: 90000 (16000 Mag Encoder Relative) New Turret: 80500
	public static final double RPM_MULTIPLIER 			= 4096d/600d; // QuadEncoder Ticks Per Rev / Milliseconds
	public static final double revTime 					= 0;
	public static final double SHOOTER_TOLERANCE 		= 100; // Ticks
	
//	Turret
	public static final double TURRET_P 				= 0.8; // 0.011 | 0.44
	public static final double TURRET_I 				= 0.00000001; // 0.00000001
	public static final double TURRET_D 				= 60.0; // 0.1
	public static final int TURRET_I_ZONE 				= 0;
	public static final double TURRET_POS	 			= 14d/3d; // 140/30 Encoder Counts per Rev
	public static final double TURRET_ANGLE_TO_TICK		= 7d/540d; // 140/30/360
	public static final double TURRET_TOLERANCE			= 0.01; // ticks
	
// 	Vision
	public static final double VISION_TOLERANCE 		= 3; // degrees
	public static final double CAMERA_CENTER_X			= 240; // 480 (length of frame) / 2
	public static final double CAMERA_CENTER_Y 			= 180;
}
