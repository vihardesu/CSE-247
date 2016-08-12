package timing.examples;

import timing.ExecuteAlgorithm;
import timing.Ticker;
import timing.quiet.QuietAlgorithm;
import timing.utils.GenSizes;
import timing.utils.IntArrayGenerator;

public class Linear extends QuietAlgorithm {

	private Ticker ticker;
	public  int    counter;

	public Linear() {
	}

	@Override
	public void reset(Ticker ticker) {
		this.ticker = ticker;
		this.counter = 0;
	}

	@Override
	public void run() {
		for (int i=0; i < size; ++i) {
			ticker.tick();
			this.counter = this.counter + 1;
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
