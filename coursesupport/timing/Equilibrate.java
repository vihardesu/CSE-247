package timing;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import timing.utils.SizeAndTiming;

public class Equilibrate implements GensRepeatRunnable {

	public static int calcInflation() {
		final Duration target = Duration.ofNanos(6000000); // target for inflate value adjustments
		final Duration tolerance = Duration.ofNanos(500000); // tolerance of deviation from the target
		int inflate = 500;
		boolean done = false;
		while (!done) {
			List<Integer> sizes = new ArrayList<Integer>(1000);
			for (int i=0; i < 100; i=i+5) {
				sizes.add(i);
			}
			GenResults exper = new GenResults(new Equilibrate(inflate), sizes, 3);
			exper.run();
			
			Duration sumOfDiff = Duration.ZERO;
			Duration prev = Duration.ZERO;
			for (SizeAndTiming st : exper.getSizeAndTiming()) {
				System.out.println(st);
				sumOfDiff = sumOfDiff.plus(st.timing.minus(prev));
				prev = st.timing;
			}
			Duration avg = sumOfDiff.dividedBy((long)(exper.getCount() - 1));
			System.out.println("Average duration difference: " + avg);
			
			Duration result = target.minus(avg);
			if (result.abs().compareTo(tolerance) < 0) {
				// found inflate, save it and exit
				System.out.println("Inflate final value = " + inflate);
				return inflate;
			} else if (result.abs().compareTo(tolerance.multipliedBy(2)) < 0) {
				// greater than tolerance but within twice tolerance
				// change inflate by 25
				if (result.isNegative())
					inflate -= 25;
				else
					inflate += 25;
			} else {
				// greater than twice tolerance
				// change inflate by 50
				if (result.isNegative())
					inflate -= 50;
				else
					inflate += 50;
			}
		}
		return -1;
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

	public static void main(String[] args) {

	}
}
