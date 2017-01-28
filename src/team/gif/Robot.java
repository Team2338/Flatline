package team.gif;

import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionThread;
import team.gif.commands.drivetrain.TankDrive;
import team.gif.subsystems.Climber;
import team.gif.subsystems.Drivetrain;
import team.gif.subsystems.Geardrop;
import team.gif.subsystems.Shifter;
import team.gif.subsystems.Shooter;
import team.gif.subsystems.ShooterTurret;
import team.gif.subsystems.Versadrop;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static final Drivetrain drivetrain = new Drivetrain();
	public static final Climber climber = new Climber();
	public static final Shooter shooter = new Shooter();
	public static final ShooterTurret turret = new ShooterTurret();
	public static final Geardrop geardrop = new Geardrop();
	public static final Shifter shifter = new Shifter();
	public static final Versadrop versadrop = new Versadrop();
	public static OI oi;
	
    Command autonomousCommand;
    SendableChooser chooser;
//    public static Preferences prefs;
	
	// Vision - test
    public static NetworkTable grip;
	private VisionThread visionThread;
//	GripPipeline grip = new GripPipeline();
//	private final Object imgLock = new Object();
	
	private double centerX = 0.0;
	private double centerY = 0.0;
	private double area = 0.0;
	private double solidity = 0.0;
	private boolean isProcessing = false;

    public void robotInit() {
	  oi = new OI();
      chooser = new SendableChooser();
//      prefs = Preferences.getInstance();
//      prefs.putDouble("FlywheelP", Globals.flywheelP);
//      prefs.putDouble("FlywheelI", Globals.flywheelI);
//      prefs.putDouble("FlywheelD", Globals.flywheelD);
//      prefs.putDouble("FlywheelF", Globals.flywheelF);
//      prefs.putDouble("FlywheenRPM", Globals.flywheelRPM);     
      
      // Kangaroo test
     grip = NetworkTable.getTable("GRIP/myContoursReport");
        
//      UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
////      camera.setFPS(10);
////      camera.setExposureManual(0);
////      camera.setBrightness(0);
//      camera.setResolution(640, 480);
//        
//      // Camera processing in a separate thread
//      visionThread = new VisionThread(camera, grip, pipeline -> {
////    	SmartDashboard.putBoolean("Find Contours Output is Empty: ", pipeline.findContoursOutput().isEmpty());
////    	SmartDashboard.putBoolean("Filter Contours Output is Empty: ", pipeline.filterContoursOutput().isEmpty());
//    	if(!pipeline.filterContoursOutput().isEmpty()) {
//    		Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(pipeline.getIndexLargestArea()));
//    		synchronized (imgLock) {
//    			isProcessing = true;
//    			centerX = r.x + (r.width / 2);
//    			centerY = r.y + (r.height / 2);
//    			area = r.area();
////    			solidity = r. // TODO: I forgot what this means so figure it out later
//    		}
//    		update();
//    	} else {
//    		isProcessing = false;
//    		}
//    	}
//    );
//    visionThread.start();
}

    public void disabledInit(){}
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		update();
	}

    public void autonomousInit() {
        autonomousCommand = (Command) chooser.getSelected();
        
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
        update();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
        new TankDrive().start();
        
//        shooter.setPID(prefs.getDouble("FlywheelP", Globals.flywheelP), prefs.getDouble("FlywheelI", Globals.flywheelI),
//        		prefs.getDouble("FlywheelD", Globals.flywheelD), prefs.getDouble("FlywheelF", Globals.flywheelF));       
//
//        Globals.flywheelP = prefs.getDouble("FlywheelP", Globals.flywheelP);
//        Globals.flywheelI = prefs.getDouble("FlywheelI", Globals.flywheelI);
//        Globals.flywheelD = prefs.getDouble("FlywheelD", Globals.flywheelD);
//        Globals.flywheelF = prefs.getDouble("FlywheelF", Globals.flywheelF);
//        Globals.flywheelRPM = prefs.getDouble("FlywheelRPM", Globals.flywheelRPM);
    }

    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        update();
    }

    public void testPeriodic() {
        LiveWindow.run();
        update();
    }
    
    public void update() {
//    	synchronized(imgLock) {
    		Robot.shooter.update();
    		Robot.turret.update();
        	SmartDashboard.putNumber("Center X: ", centerX);
        	SmartDashboard.putNumber("Center Y: ", centerY);
        	SmartDashboard.putNumber("Area: ", area);
        	SmartDashboard.putBoolean("Is Processing: ", isProcessing);
//    	}
    }
}
