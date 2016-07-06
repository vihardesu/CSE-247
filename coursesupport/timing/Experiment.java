package timing;

import java.time.Duration;
import java.util.PriorityQueue;

import timing.results.LeastChooser;
import timing.results.ResultsChooser;

public class Experiment implements Runnable {

	final private RepeatRunnable rr;
	private int repeats;
	private Duration time;
	private Long     ticks;
	private ResultsChooser<Duration> timeChooser;
	private ResultsChooser<Long>     ticksChooser;



	public Experiment(RepeatRunnable rr, int repeats, ResultsChooser<Duration> timeChooser, ResultsChooser<Long> ticksChooser) {
		this.rr      = rr;
		this.repeats = repeats;
		this.timeChooser  = timeChooser;
		this.ticksChooser = ticksChooser;
		this.time    = null;
		this.ticks   = null;
	}
	
	public Experiment(RepeatRunnable rr, int repeats) {
		this(rr, repeats, 
				new LeastChooser<Duration>(), 
				new LeastChooser<Long>()
				);
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
		PriorityQueue<Duration> pq = new PriorityQueue<Duration>();
		PriorityQueue<Long>     tq = new PriorityQueue<Long>();
		for (int i=0; i < repeats; ++i) {
			TimedRunnable tr = new TimedRunnable(rr);
			tr.start();
			Duration time = tr.getTime();
			Long ticks = tr.getTicker().getTickCount();
			tq.offer(ticks);
			pq.offer(time);
		}
		
		this.time  = timeChooser.getValue(pq);
		this.ticks = ticksChooser.getValue(tq);
	}


}
