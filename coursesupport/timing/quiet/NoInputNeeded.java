package timing.quiet;

import timing.InputSpec;
import timing.InputProvider;

public class NoInputNeeded implements InputProvider<NoInputNeeded> {

	public static final NoInputNeeded instance = new NoInputNeeded();
	
	private NoInputNeeded() { }
	
	@Override
	public NoInputNeeded genInput(InputSpec size) {
		return null;
	}

	

}
