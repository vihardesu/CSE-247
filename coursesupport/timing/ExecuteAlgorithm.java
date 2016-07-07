package timing;

import java.time.Duration;

public class ExecuteAlgorithm<T,U> {
	
	private U              results;
	private T              input;
	private Algorithm<T,U> algorithm;
	private Long           ticks;
	private Duration       time;
	
	public ExecuteAlgorithm(InputProvider<T> inputProvider, Algorithm<T,U> algorithm, int size) {
		this.input     = inputProvider.genInput(size);
		this.algorithm = algorithm;
	}
	
	/**
	 * Load the input, and then run the algorithm under the
	 * controlled timing setting.
	 */
	public void run() {
		algorithm.loadInput(input);
		GenResults gs = new GenResults(algorithm, 3);
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
