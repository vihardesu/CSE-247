package timing.examples;

import timing.Experiment;
import timing.RepeatRunnable;
import timing.Ticker;

public class Quadratic implements RepeatRunnable {

	private final int size;

	public Quadratic(int size) {
		this.size = size;
	}

	@Override
	public void reset() {
		// No need to do anything
	}

	@Override
	public void run(Ticker ticker) {
		for (int i=0; i < size; ++i) {
			for (int j=0; j < size; ++j) {
				ticker.tick();
			}
		}	
	}

	@Override
	public int getSize() {
		return this.size;
	}

	public String toString() {
		return "Quadratic " + size;
	}

	public static void main(String[] args) {
		for (int i=10000; i < 100000; i=i+1000) {
			Experiment e = new Experiment(new Quadratic(i), 3);
			e.run();
			System.out.println(" ticks: " + e.getTicks());
			System.out.println(" time:  " + e.getTime());
		}
	}

}
