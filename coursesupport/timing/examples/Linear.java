package timing.examples;

import timing.RepeatRunnable;
import timing.Ticker;

public class Linear implements RepeatRunnable {
	
	private final int size;
	
	public Linear(int size) {
		this.size = size;
	}
	
	@Override
	public void reset() {
		// No need to do anything
	}

	@Override
	public void run(Ticker ticker) {
		for (int i=0; i < size; ++i) {
			ticker.tick();
		}	
	}

}
