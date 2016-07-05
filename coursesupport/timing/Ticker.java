package timing;

public class Ticker {
	
	private long tickCount;

	public Ticker() {
		this.tickCount = 0L;
	}
	
	public void tick() {
		++tickCount;
	}
	
	public long getTickCount() {
		return this.tickCount;
	}

}
