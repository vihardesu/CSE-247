package timing;

import java.util.ArrayList;
import java.util.List;

public class Equilibrate implements GensRepeatRunnable {

	static {
		List<Integer> sizes = new ArrayList<Integer>(1000);
		for (int i=0; i < 100; i=i+5) {
			sizes.add(i);
		}
		Experiment exper = new Experiment(new Equilibrate(500), sizes, 3);
		exper.run();
		for (SizeAndTiming st : exper.getSizeAndTiming()) {
			System.out.println(st);
		}
	}
	
	private final int inflate;
	
	public Equilibrate(int inflate) {
		this.inflate = inflate;
	}

	@Override
	public RepeatRunnable gen(final long size) {
		return new RepeatRunnable() {

			private volatile int sum;
			private final int inf = inflate;

			@Override
			public void run() {
				for (int i=0; i < size; ++i) {
					takeSomeTime();
				}
			}

			@Override
			public void reset() {
				sum = 0;
			}

			public String toString() {
				return "Equilibrate size " + size;
			}




			private void takeSomeTime() {
				for (int i=0; i < inf; ++i) {
					for (int j=0; j < inf; ++j) {
						sum = sum + i + j;
					}
				}
			}
		};
	}

	public String toString() {
		return "Equlibrate 1000";
	}

	private volatile int sum;

	public static void main(String[] args) {

	}
}
