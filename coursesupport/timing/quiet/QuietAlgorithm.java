package timing.quiet;

import timing.Algorithm;
import timing.Ticker;

abstract public class QuietAlgorithm<T> implements Algorithm<T[],NoOutputNeeded>{


	protected int size;
	
	@Override
	public void loadInput(T[] input) {
		this.size = input.length;
	}

	@Override
	public NoOutputNeeded getResults() {
		return null;
	}

}
