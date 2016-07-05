package timing.examples;

import timing.Experiment;
import timing.GenSizes;
import timing.GensRepeatRunnable;
import timing.RepeatRunnable;
import timing.Ticker;

public class LinearExample {
	
	private final GensRepeatRunnable grr;

	public LinearExample(final int n) {
		this.grr = new GensRepeatRunnable() {

			@Override
			public RepeatRunnable gen(final long size) {
				return new RepeatRunnable() {

					@Override
					public void run(Ticker t) {
						for (int i=0; i < size; ++i) {
							t.tick();
						}
					}

					@Override
					public void reset() {
						// Nada
					}
					
					public String toString() {
						return "Linear size " + size;
					}
				};
			}
			
		};
	}
	
	public void run() {
		Experiment.runExperiment("liner", grr, new GenSizes(), 3);
	}
	
	public static void main(String[] args) {
		new LinearExample(1000).run();
	}

}
