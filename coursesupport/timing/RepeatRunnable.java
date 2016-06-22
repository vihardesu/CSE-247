package timing;

public interface RepeatRunnable extends Runnable {
	
	/**
	 * Called before running a Runnable again.
	 */
	public void reset();

}
