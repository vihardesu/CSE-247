package heaps.test;

import java.util.Arrays;
import java.util.Random;

import heaps.MinHeap;
import timing.Experiment;
import timing.GensRepeatRunnable;
import timing.Output;
import timing.RepeatRunnable;
import timing.SizeAndTiming;

public class HeapTimer implements GensRepeatRunnable {
	

	public HeapTimer() {
	}

	public RepeatRunnable genRunnable(final long n) {
		return new RepeatRunnable() {
			
			private MinHeap<Integer> heap;
			private Random r = new Random(0);

			@Override
			public void reset() {
				heap = new MinHeap<Integer>((int)	n);
			}
			
			//
			// Our work consists of:
			//    inserting  n times into the heap
			//    extracting n times from the heap
			//

			@Override
			public void run() {
				for (int i=0; i < n; ++i) {
					heap.insert(r.nextInt());
				}
				for (int i=0; i < n; ++i) {
					heap.extractMin();
				}

			}

			public String toString() {
				return "Heap " + " of size " + n;
			}


		};
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
		
		Experiment e = new Experiment(new HeapTimer(), Arrays.asList(sizes), 5);
		e.run();

		for (SizeAndTiming st : e.getSizeAndTiming()) {
			System.out.println(st.size + " " + st.timing.toMillis());
		}
		
		Output.writeSizeTiming("outputs/prioqueue.csv", "binary heap", e.getSizeAndTiming());
	}


	@Override
	public RepeatRunnable gen(long size) {
		return genRunnable(size);
	}

}
