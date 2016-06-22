package timing;

import java.time.Duration;
import java.time.Instant;
import java.util.PriorityQueue;

/**
 * Runs a specified Runnable, keeping track of
 *   when it started and ended,
 *   so that the Duration of the Runnable can be returned
 *   
 * @author roncytron
 *
 */
public class TimedRunnable extends Thread implements Runnable {

	final private RepeatRunnable runnable;
	private Instant start = null;
	private Instant end   = null;
	private static boolean logging = true;

	/**
	 * Construct but do not yet run the Runnable
	 * @param r The Runnable that will be run
	 */
	public TimedRunnable(RepeatRunnable r) {
		this.runnable = r;
	}

	/**
	 * 1) Mark time (variable start), 
	 * 2) Run the Runnable, 
	 * 3) Mark time (variable end)
	 */
	@Override
	public void run() {
		if (this.end != null) {
			throw new Error("You can only run " + runnable + " once");
		}
		if (logging)
			System.out.println("Starting " + runnable + "...");
		//
		// Have the ResetRunnable set itself up again
		//   before we count timing
		//
		runnable.reset();
		//
		// collect your garbage Java!
		// 
		System.gc();
		System.runFinalization();
		//
		//  and finish all the dead objects -- get all done you need to do
		//
		this.start = Instant.now();        // (1)
		try {
			runnable.run();                // (2)
		}
		catch (Throwable t) {
			this.end = Instant.now();      // (3)
			System.out.println("Runnable " + runnable + " threw error " + t);
		}
		finally {
			if (this.end == null)
				this.end = Instant.now();  // (3)
			if (logging)
				System.out.println("...Ending " + runnable );
			Wrappers.notifyAll(this); //Notifies everyone that this.end might have changed
		}
	}

	/**
	 * If the Runnable as not yet completed execution, wait
	 * 
	 * @return the Duration of time taken by the Runnable
	 */
	public Duration getTime() {

		while(this.end == null){
			Wrappers.wait(this);	  //waits for the Runnable to finish
		}

		return Duration.between(start, end);
	}

	public static TimedRunnable genTimedRunnable(RepeatRunnable r) {
		return new TimedRunnable(r);
	}

	public static Duration getTimeFor(RepeatRunnable r, int numTimes) {
		PriorityQueue<Duration> pq = new PriorityQueue<Duration>();
		for (int i=0; i < numTimes; ++i) {
			TimedRunnable tr = genTimedRunnable(r);
			tr.start();
			Duration t = tr.getTime();
			pq.offer(t);
		}
		//
		// return the median time by pulling the first
		//   n/2 entries from the PriorityQueue
		//   for linked list we wanted the fastest time
		//   but if there is randomness in the data, the median makes
		//   more sense.
		// FIXME The strategy for which time to take should be
		//   something we can specify as a parameter
		//   We study priority queues later 
		//
		Duration ans = null;
		for (int i=0; i <= numTimes/2; ++i) {
			ans = pq.poll();
		}
		return ans;
	}

}
