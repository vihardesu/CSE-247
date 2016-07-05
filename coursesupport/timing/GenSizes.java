package timing;

import java.util.Iterator;

public class GenSizes implements Iterable<Integer> {
	
	private final int start, almostEnd, bump;

	public GenSizes(int start, int almostEnd, int bump) {
		this.start     = start;
		this.almostEnd = almostEnd;
		this.bump      = bump;
	}
	
	public GenSizes() {
		this(0,100,1);
	}

	@Override
	public Iterator<Integer> iterator() {
		return new Iterator<Integer> () {
			
			private int i = start;

			@Override
			public boolean hasNext() {
				return i < almostEnd;
			}

			@Override
			public Integer next() {
				int ans = i;
				i = i + bump;
				return ans;
			}
			
		};
	}

}
