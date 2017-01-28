package team.gif.commands.auto;

/**
 * A {@link WaitCommand} will wait for a certain amount of time before
 * finishing. It is useful if you want a {@link CommandGroup} to pause for a
 * moment.
 *$
 * @author Joe Grinstead
 * @see CommandGroup
 */
public class WaitCommand extends lib.gif.commands.Command {

  /**
   * Instantiates a {@link WaitCommand} with the given timeout.
   *$
   * @param timeout the time the command takes to run
   */
  public WaitCommand(double timeout) {
    super(timeout);
  }

  /**
   * Instantiates a {@link WaitCommand} with the given timeout.
   *$
   * @param name the name of the command
   * @param timeout the time the command takes to run
   */
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
