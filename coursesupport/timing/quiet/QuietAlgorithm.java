package timing.quiet;

import timing.Algorithm;
import timing.Ticker;

abstract public class QuietAlgorithm implements Algorithm<NoInputNeeded,NoOutputNeeded>{


	@Override
	public void loadInput(NoInputNeeded input) {
		
	}

	@Override
	public NoOutputNeeded getResults() {
		return null;
	}

}
