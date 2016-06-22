package timing;

public interface GensRepeatRunnable {
	
	/**
	 * Generates a RepeatRunnable of the specified size
	 * @param size the input size
	 * @return something that can be run many times to get accurate timing
	 */
	public RepeatRunnable gen(long size);

}
