package timing.quiet;

import timing.ComplexityParameters;
import timing.InputProvider;

public class NoInputNeeded implements InputProvider<NoInputNeeded> {

	public static final NoInputNeeded instance = new NoInputNeeded();
	
	private NoInputNeeded() { }
	
	@Override
	public NoInputNeeded genInput(ComplexityParameters size) {
		return null;
	}

	

}
