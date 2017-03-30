/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008-2016. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package team.gif.commands;

import lib.gif.commands.Command;
import team.gif.Robot;

public class WaitCommand extends Command {

    private boolean isAuto;
	private boolean withGear;
	
  public WaitCommand(double timeout) {
    super(timeout);
    this.isAuto = false;
  }
  
  public WaitCommand(double timeout, boolean isAuto) {
    super(timeout);
    this.isAuto = isAuto;
  }

  public WaitCommand(String name, double timeout) {
    super(name, timeout);
  }

  protected void initialize() {
	withGear = Robot.gearChooser.getSelected() != null ? Robot.gearChooser.getSelected() : true;
  }

  protected void execute() {}

  protected boolean isFinished() {
	if (isAuto) {
	  return withGear ? isTimedOut() : true;
	} else {
	  return isTimedOut();
	}
  }

  protected void end() {}

  protected void interrupted() {}
}
