package team.gif;

public class Globals {
	
//	Drivetrain
	public static final double deadzone = 0.1;
	
//	Shooter
	public static double flywheelP = 0.01;     // PVC: 0.14 Turret: .0048 New Turret: 0.01
	public static double flywheelI = 0.0001;     // PVC:  0.0005 Turret: .0001 New Turret: 0.0001
	public static double flywheelD = 0.01;	     // PVC: 0.001 Turret: 0.000 New Turret: 0.01
	public static double flywheelF = 0.0084;  	 // PVC: 0.028 Turret: 0.0087 New Turret: 0.0084
	//	public static int flywheelIZone = 1200;  // PVC: 1200
	public static int flywheelIZoneAbove = 1200;  // Turret: 500
	public static int flywheelIZoneBelow = 4000; // Turret: 2000
	public static double flywheelRPM = 80500; 	 // PVC: 22000 Turret: 90000 (16000 Mag Encoder Relative) New Turret: 80500
	public static double RPMMultiplier = 6.84;
	public static final double revTime = 0;
	public static final double shooterTolerance = 100;
	
//	Turret
	public static double turretP = 0.011; // 0.011
	public static double turretI = 0.0000001; // 0.00000001
	public static double turretD = 0.8; // 0.1
	public static int turretIZone = 0;
	public static double turretPosition = 635; // 635 Encoder Counts per Rev
	public static double turretAngleToTick = 16/9; // 127/172 possible
	public static double turretTolerance = 10; // ticks
	public static double cameraCenterX = 240; // 480 (length of frame) / 2
}
