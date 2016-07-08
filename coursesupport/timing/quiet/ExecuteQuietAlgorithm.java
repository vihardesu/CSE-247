package timing.quiet;

import timing.Algorithm;
import timing.ExecuteAlgorithm;

public class ExecuteQuietAlgorithm extends ExecuteAlgorithm<NoInputNeeded,NoOutputNeeded>{

	public ExecuteQuietAlgorithm(Algorithm<NoInputNeeded, NoOutputNeeded> algorithm, int size) {
		super(NoInputNeeded.instance, algorithm, size);
	}

}
