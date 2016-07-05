package timing;

import java.time.Duration;

/**
 * Simple aggregating class.
 * @author roncytron
 *
 */
public class SizeAndTicks extends SizeAndLong {
	
	public final int  size;
	public final long ticks;
	
	public SizeAndTicks(int size, long ticks) {
		super(size, ticks);
		this.size = size;
		this.ticks = ticks;
	}
	
	@Override
	public String toString() {
		return "SizeAndTicks [size=" + size + ", ticks=" + ticks + "]";
	}

}
