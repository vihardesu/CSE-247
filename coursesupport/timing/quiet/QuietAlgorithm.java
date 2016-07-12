package timing.quiet;

import timing.Algorithm;
import timing.Ticker;

abstract public class QuietAlgorithm implements Algorithm<Integer[],NoOutputNeeded>{


	protected int size;
	
	@Override
	public void loadInput(Integer[] input) {
		this.size = input.length;
	}

	@Override
	public NoOutputNeeded getResults() {
		return null;
	}

}
