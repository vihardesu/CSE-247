package timing.examples;

import timing.InputSpec;
import timing.GenResults;
import timing.RepeatRunnable;
import timing.Ticker;
import timing.output.Output;
import timing.quiet.ExecuteQuietAlgorithm;
import timing.quiet.QuietAlgorithm;

public class Quadratic extends QuietAlgorithm {

	private final int size;
	private Ticker ticker;

	public Quadratic(int size) {
		this.size = size;
	}

	@Override
	public void reset(Ticker ticker) {
		this.ticker = ticker;
	}

	@Override
	public void run() {
		for (int i=0; i < size; ++i) {
			for (int j=0; j < size; ++j) {
				ticker.tick();
			}
		}	
	}

	public String toString() {
		return "Quadratic " + size;
	}

	public static void main(String[] args) {
		Output out = new Output("quadratic", "quadticks");
		for (int i=10000; i < 100000; i=i+10000) {
			ExecuteQuietAlgorithm e = new ExecuteQuietAlgorithm(new Quadratic(i), InputSpec.gen(i));
			e.run();
			out.writeSizeValue(i, e.getTicks());
			System.out.println(" ticks: " + e.getTicks());
			System.out.println(" time:  " + e.getTime());
		}
		out.close();
	}

}
