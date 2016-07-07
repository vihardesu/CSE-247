package timing.examples;

import timing.GenResults;
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

	public String toString() {
		return "Linear " + size;
	}
	
	public static void main(String[] args) {
		for (int i=0; i < 100; ++i) {
			GenResults e = new GenResults(new Linear(i), 3);
			e.run();
			System.out.println(" ticks: " + e.getTicks());
			System.out.println(" time:  " + e.getTime());
		}
	}

}
