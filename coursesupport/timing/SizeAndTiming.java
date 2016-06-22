package timing;

import java.time.Duration;

/**
 * Simple aggregating class.
 * @author roncytron
 *
 */
public class SizeAndTiming {
	
	public final int      size;
	public final Duration timing;
	
	public SizeAndTiming(int size, Duration timing) {
		super();
		this.size = size;
		this.timing = timing;
	}
	
	@Override
	public String toString() {
		return "SizeAndTiming [size=" + size + ", timing=" + timing + "]";
	}

}
