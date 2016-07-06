package timing.utils;

import java.time.Duration;

/**
 * Simple aggregating class.
 * @author roncytron
 *
 */
public class SizeAndTiming extends SizeAndLong {
	
	public final int      size;
	public final Duration timing;
	
	public SizeAndTiming(int size, Duration timing) {
		super(size, timing.toMillis());
		this.size = size;
		this.timing = timing;
	}
	
	@Override
	public String toString() {
		return "SizeAndTiming [size=" + size + ", timing=" + timing + "]";
	}

}
