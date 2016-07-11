package heaps.test;

import heaps.HeapSort;
import timing.ExecuteAlgorithm;
import timing.InputSpec;
import timing.utils.IntArrayGenerator;

public class HeapTimer {
	

	public HeapTimer() {
	}



	public static void main(String[] args) {
		runExperiment(30000);   // FIXME change to 25000 or some large number so times show up
	}
	
	private static void runExperiment(int factor) {
		int start = 5;
		int end   = 50;
		Integer[] sizes = new Integer[end-start];
		for (int i=start; i < end; ++i) {
			sizes[i-start] = i*factor;
		}
		for (int size : sizes) {
			System.out.println("Size " + size);
			ExecuteAlgorithm<Integer[],Integer[]> ea = 
					new ExecuteAlgorithm<Integer[],Integer[]>(
							new IntArrayGenerator(), new HeapSort(), InputSpec.gen(size)
							);
			ea.run();
			System.out.println("Ticks :" + ea.getTicks());
		}
	}

}
