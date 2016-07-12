package timing.examples;

import timing.ExecuteAlgorithm;
import timing.Ticker;
import timing.quiet.QuietAlgorithm;
import timing.utils.GenSizes;
import timing.utils.IntArrayGenerator;

public class Linear extends QuietAlgorithm {

	private Ticker ticker;

	public Linear() {
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
		GenSizes sizes = GenSizes.arithmetic(10000, 100000, 10000);
		ExecuteAlgorithm.timeAlgorithm(
				"linear", 
				"timing.examples.Linear", 
				new IntArrayGenerator(), 
				sizes
				);	
	}

}
