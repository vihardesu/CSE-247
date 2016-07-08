package timing.examples;

import timing.GenResults;
import timing.RepeatRunnable;
import timing.Ticker;
import timing.quiet.ExecuteQuietAlgorithm;
import timing.quiet.QuietAlgorithm;

public class Quadratic extends QuietAlgorithm {

	private final int size;

	public Quadratic(int size) {
		this.size = size;
	}

	@Override
	public void reset() {
		// No need to do anything
	}

	@Override
	public void run(Ticker ticker) {
		for (int i=0; i < size; ++i) {
			for (int j=0; j < size; ++j) {
				ticker.tick();
			}
		}	
	}

	public String toString() {
		return "Quadratic " + size;
	}

	public static void main(String[] args) {
		for (int i=10000; i < 100000; i=i+10000) {
			ExecuteQuietAlgorithm e = new ExecuteQuietAlgorithm(new Quadratic(i), 3);
			e.run();
			System.out.println(" ticks: " + e.getTicks());
			System.out.println(" time:  " + e.getTime());
		}
	}

}
