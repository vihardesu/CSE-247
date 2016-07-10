package timing.examples;

import timing.InputSpec;
import timing.Ticker;
import timing.output.Output;
import timing.quiet.ExecuteQuietAlgorithm;
import timing.quiet.QuietAlgorithm;

public class Log extends QuietAlgorithm {
	
	private final int size;
	private Ticker ticker;
	
	public Log(int size) {
		this.size = size;
	}
	
	@Override
	public void reset(Ticker ticker) {
		this.ticker = ticker;
	}

	@Override
	public void run() {
		helper(size);
	}
	
	private void helper(int size) {
		if (size <= 1)
			return;
		else {
			ticker.tick();
			helper(size/2);
		}
	}

	public String toString() {
		return "Linear " + size;
	}
	
	public static void main(String[] args) {
		Output out = new Output("log", "logticks");
		for (int i=1; i < 1000000; i=i*2) {
			ExecuteQuietAlgorithm e = new ExecuteQuietAlgorithm(new Log(i), InputSpec.gen(i));
			e.run();
			out.writeSizeValue(i, e.getTicks());
			System.out.println(" ticks: " + e.getTicks());
			System.out.println(" time:  " + e.getTime());
		}
		out.close();
	}

}
