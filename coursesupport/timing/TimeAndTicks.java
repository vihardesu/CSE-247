package timing;

import java.time.Duration;

public class TimeAndTicks {
	
	public final Duration time;
	public final long     ticks;
	
	public TimeAndTicks(Duration time, long ticks) {
		this.time = time;
		this.ticks = ticks;
	}

}
