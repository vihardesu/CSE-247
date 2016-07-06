package timing.examples;

import timing.Experiment;
import timing.GensRepeatRunnable;
import timing.RepeatRunnable;
import timing.Ticker;
import timing.utils.GenSizes;

public class Quadratic {

	private final GensRepeatRunnable grr;

	public Quadratic(final int n) {
		this.grr = new GensRepeatRunnable() {

			@Override
			public RepeatRunnable gen(final long size) {
				return new RepeatRunnable() {

					@Override
					public void run(Ticker t) {
						for (int i=0; i < size; ++i) {
							for (int j=0; j < size; ++j) {
								t.tick();
							}
						}
					}

					@Override
					public void reset() {
						// Nada
					}
					
					public String toString() { 
						return "Quadratic work size " + size;
					}

				};
			}

		};
	}

	public void run() {
		Experiment.runExperiment("quad", grr, new GenSizes(), 3);
	}

	public static void main(String[] args) {
		new Quadratic(1000).run();
	}

}
