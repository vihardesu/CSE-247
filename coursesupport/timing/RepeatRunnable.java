package timing;

public interface RepeatRunnable {
	
	/**
	 * Called before running a Runnable again.
	 */
	public void reset();
	public void run(Ticker t);

}
