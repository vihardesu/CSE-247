package timing.examples;

import timing.ExecuteAlgorithm;
import timing.Ticker;
import timing.quiet.QuietAlgorithm;
import timing.utils.GenSizes;
import timing.utils.IntArrayGenerator;

public class Log extends QuietAlgorithm {
	
	private Ticker ticker;
	
	public Log() {
	}
	
	@Override
	public void reset(Ticker ticker) {
		this.ticker = ticker;
	}

	@Override
	public void run() {
		helper(size);
	}
	
	private void helper(int size) {
		if (size <= 1)
			return;
		else {
			ticker.tick();
			helper(size/2);
		}
	}

	public String toString() {
		return "Linear " + size;
	}
	
	public static void main(String[] args) {
		GenSizes sizes = GenSizes.geometric(1, 1000000, 2);
		ExecuteAlgorithm.timeAlgorithm(
				"log", 
				"timing.examples.Log", 
				new IntArrayGenerator(), 
				sizes
				);
	}

}
