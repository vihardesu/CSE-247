package timing.examples;

import timing.ExecuteAlgorithm;
import timing.Ticker;
import timing.quiet.QuietAlgorithm;
import timing.utils.GenSizes;
import timing.utils.IntArrayGenerator;

public class Quadratic extends QuietAlgorithm {

	private Ticker ticker;
	public  int    value;

	public Quadratic() {
	}

	@Override
	public void reset(Ticker ticker) {
		this.ticker = ticker;
		this.value = 0;
	}

	@Override
	public void run() {
		for (int i=0; i < n; ++i) {
			for (int j=0; j < n; ++j) {
				ticker.tick();
				this.value = this.value + i;
			}
		}	
	}

	public String toString() {
		return "Quadratic " + n;
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
