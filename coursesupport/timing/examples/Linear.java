package timing.examples;

import timing.InputSpec;
import timing.Ticker;
import timing.quiet.ExecuteQuietAlgorithm;
import timing.quiet.QuietAlgorithm;

public class Linear extends QuietAlgorithm {
	
	private final int size;
	private Ticker ticker;
	
	public Linear(int size) {
		this.size = size;
	}
	
	@Override
	public void reset(Ticker ticker) {
		this.ticker = ticker;
	}

	@Override
	public void run() {
		for (int i=0; i < size; ++i) {
			ticker.tick();
		}	
	}

	public String toString() {
		return "Linear " + size;
	}
	
	public static void main(String[] args) {
		for (int i=0; i < 100; ++i) {
			ExecuteQuietAlgorithm ea = new ExecuteQuietAlgorithm(new Linear(i), InputSpec.gen(i));
			ea.run();
			System.out.println(" ticks: " + ea.getTicks());
			System.out.println(" time:  " + ea.getTime());
		}
	}

}
