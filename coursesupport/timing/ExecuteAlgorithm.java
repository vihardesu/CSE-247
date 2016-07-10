package timing;

import java.time.Duration;

/**
 * 
 * @author roncytron
 * 
 * Allows runs of an algorithm for a specific input size.
 * This is used for generating timing profiles for an algorithm.
 *
 * @param <T> Input type for the algorithm
 * @param <U> Output type for the algorithm
 */
public class ExecuteAlgorithm<T,U> {
	
	private final static int NUMREPEATS = 3;
	private U              results;
	private T              input;
	private Algorithm<T,U> algorithm;
	private Long           ticks;
	private Duration       time;
	
	/**
	 * 
	 * @param inputProvider source for the input to the algorithm
	 * @param algorithm     the algorithm itself
	 * @param size          describes the size of the input to be supplied by the inputProvider
	 */
	public ExecuteAlgorithm(InputProvider<T> inputProvider, Algorithm<T,U> algorithm, InputSpec size) {
		this.input     = inputProvider.genInput(size);
		this.algorithm = algorithm;
	}
	
	/**
	 * Load the input, and then run the algorithm under the
	 * controlled timing setting.
	 */
	public void run() {
		algorithm.loadInput(input);
		GenResults gs = new GenResults(algorithm, NUMREPEATS);
		gs.run();
		this.results = algorithm.getResults();
		this.ticks   = gs.getTicks();
		this.time    = gs.getTime();
	}
	
	public U getResults() {
		return results;
	}
	
	public Duration getTime() {
		return time;
	}
	
	public Long getTicks() {
		return ticks;
	}

}
