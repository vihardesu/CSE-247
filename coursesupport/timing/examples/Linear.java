package timing.examples;

import timing.Algorithm;
import timing.ExecuteAlgorithm;
import timing.GenResults;
import timing.RepeatRunnable;
import timing.Ticker;
import timing.quiet.ExecuteQuietAlgorithm;
import timing.quiet.NoInputNeeded;
import timing.quiet.NoOutputNeeded;
import timing.quiet.QuietAlgorithm;

public class Linear extends QuietAlgorithm {
	
	private final int size;
	
	public Linear(int size) {
		this.size = size;
	}
	
	@Override
	public void reset() {
		// No need to do anything
	}

	@Override
	public void run(Ticker ticker) {
		for (int i=0; i < size; ++i) {
			ticker.tick();
		}	
	}

	public String toString() {
		return "Linear " + size;
	}
	
	public static void main(String[] args) {
		for (int i=0; i < 100; ++i) {
			ExecuteQuietAlgorithm ea = new ExecuteQuietAlgorithm(new Linear(i), 3);
			ea.run();
			System.out.println(" ticks: " + ea.getTicks());
			System.out.println(" time:  " + ea.getTime());
		}
	}

}
