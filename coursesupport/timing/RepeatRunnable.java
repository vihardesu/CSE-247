package timing;

/**
 * A class must implement this interface to be
 *    "timed".
 * @author roncytron
 *
 */
public interface RepeatRunnable {
	
	/**
	 * Called before each execution of run.  This method is used
	 *   to reset an implementation to the point where it should
	 *   be timed.
	 */
	public void reset();
	/**
	 * The actual workload to be performed after reset().  The run method uses the Ticker to keep 
	 * track of operations during its execution.
	 * @param ticker
	 */
	public void run(Ticker ticker);
	
	/**
	 * The size of the input for this problem.
	 * @return the size of the input for this problem
	 */
	public int getSize();

}
