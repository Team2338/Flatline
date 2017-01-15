
package org.usfirst.frc.team2338.robot;

import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc.team2338.robot.subsystems.Climber;
import org.usfirst.frc.team2338.robot.subsystems.Drivetrain;
import org.usfirst.frc.team2338.robot.commands.TankDrive;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionThread;

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
	public static OI oi;
	
	// Vision - test
	private VisionThread visionThread;
	GripPipeline grip = new GripPipeline();
	private final Object imgLock = new Object();
	
	private double centerX = 0.0;
	private double centerY = 0.0;
	private double area = 0.0;
	private double solidity = 0.0;
	private boolean isProcessing = false;

    Command autonomousCommand;
    SendableChooser chooser;

    public void robotInit() {
	  oi = new OI();
      chooser = new SendableChooser();
        
      UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
      camera.setFPS(10);
//      camera.setExposureManual(0);
//      camera.setBrightness(0);
      camera.setResolution(640, 480);
        
      // Camera processing in a separate thread
      visionThread = new VisionThread(camera, grip, pipeline -> {
//    	System.out.println("Running thread"); // Debug purpose only
    	SmartDashboard.putBoolean("Find Contours Output is Empty: ", pipeline.findContoursOutput().isEmpty());
    	SmartDashboard.putBoolean("Filter Contours Output is Empty: ", pipeline.filterContoursOutput().isEmpty());
    	if(!pipeline.filterContoursOutput().isEmpty()) {
    		Rect r = Imgproc.boundingRect(pipeline.filterContoursOutput().get(pipeline.getIndexLargestArea()));
    		System.out.println("Start processing"); // Debug purpose only
    		synchronized (imgLock) {
    			isProcessing = true;
    			centerX = r.x + (r.width / 2);
    			centerY = r.y + (r.height / 2); // This is probably wrong
    			area = r.area();
    			System.out.println(centerX);
//    			solidity = r. // TODO: I forgot what this means so figure it out later
    		}
    		update();
    	} else {
    		isProcessing = false;
    		}
    	}
    );
    visionThread.start();
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
    	synchronized(imgLock) {
        	SmartDashboard.putNumber("Center X: ", centerX);
        	SmartDashboard.putNumber("Center Y: ", centerY);
        	SmartDashboard.putNumber("Area: ", area);
        	SmartDashboard.putBoolean("Is Processing: ", isProcessing);
    	}
    }
}
