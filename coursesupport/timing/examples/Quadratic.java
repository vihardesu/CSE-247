package timing.examples;

import timing.ExecuteAlgorithm;
import timing.Ticker;
import timing.quiet.QuietAlgorithm;
import timing.utils.GenSizes;
import timing.utils.IntArrayGenerator;

public class Quadratic extends QuietAlgorithm {

	private Ticker ticker;

	public Quadratic() {
	}

	@Override
	public void reset(Ticker ticker) {
		this.ticker = ticker;
	}

	@Override
	public void run() {
		ticker.tick();
		for (int i=0; i < size; ++i) {
			ticker.tick();
			for (int j=0; j < size; ++j) {
				ticker.tick();
			}
			ticker.tick();
		}	
	}

	public String toString() {
		return "Quadratic " + size;
	}

	public static void main(String[] args) {
		GenSizes sizes = GenSizes.arithmetic(10000, 100000, 10000);
		ExecuteAlgorithm.timeAlgorithm(
				"quadratic", 
				"timing.examples.Quadratic", 
				new IntArrayGenerator(), 
				sizes
				);	
	}

}
