package timing;

import java.time.Duration;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import timing.results.LeastChooser;
import timing.results.Output;
import timing.utils.SizeAndLong;
import timing.utils.SizeAndTicks;
import timing.utils.SizeAndTiming;
import timing.utils.TimeAndTicks;

public class Experiment implements Runnable {

	final private RepeatRunnable rr;
	private boolean ran;
	private int repeats;
	private Duration time;
	private Long     ticks;


	public Experiment(RepeatRunnable rr, int repeats) {
		this.rr      = rr;
		this.ran     = false;
		this.repeats = repeats;
		this.time    = null;
		this.ticks   = null;
	}

	public SizeAndLong getSizeAndTiming() {
		return new SizeAndTiming(rr.getSize(), this.time);
	}

	public SizeAndLong getSizeAndTicks() {
		return new SizeAndTicks(rr.getSize(), this.getTicks());
	}

	public long getSize() {
		return this.rr.getSize();
	}

	public Duration getTime() {
		return this.time;
	}

	public Long getTicks() {
		return this.ticks;
	}

	/**
	 * Actually do the experiment
	 */
	public void run() {
		if (this.ran) {
			throw new Error("Already ran");
		}
		this.ran = true;
		
		//System.out.println("Experiment size " + size);
		TimeAndTicks tt   = TimedRunnable.getResultsFor(rr, repeats, new LeastChooser<Duration>(), new LeastChooser<Long>());
		Duration     time = tt.time;

		this.time  = time;
		this.ticks = tt.ticks;
	}

	public static void runExperiment(String name, RepeatRunnable rr, int repeats) {
		Experiment e = new Experiment(rr, repeats);
		e.run();
		System.out.println(name+" ticks: " + e.getSizeAndTicks());
		System.out.println(name+" time:  " + e.getSizeAndTiming());
//		Output.writeSizeTiming("outputs/"+name+ "ticks.csv", name, e.getSizeAndTicks());
	}

}
