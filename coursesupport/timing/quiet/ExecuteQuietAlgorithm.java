package timing.quiet;

import timing.Algorithm;
import timing.ComplexityParameters;
import timing.ExecuteAlgorithm;

public class ExecuteQuietAlgorithm extends ExecuteAlgorithm<NoInputNeeded,NoOutputNeeded>{

	public ExecuteQuietAlgorithm(Algorithm<NoInputNeeded, NoOutputNeeded> algorithm, ComplexityParameters size) {
		super(NoInputNeeded.instance, algorithm, size);
	}

}
