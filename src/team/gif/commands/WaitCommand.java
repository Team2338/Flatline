/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008-2016. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package team.gif.commands;


public class WaitCommand extends lib.gif.commands.Command {


  public WaitCommand(double timeout) {
    super(timeout);
  }

  public WaitCommand(String name, double timeout) {
    super(name, timeout);
  }

  protected void initialize() {}

  protected void execute() {}

  protected boolean isFinished() {
    return isTimedOut();
  }

  protected void end() {}

  protected void interrupted() {}
}
