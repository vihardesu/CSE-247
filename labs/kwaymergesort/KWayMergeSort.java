package kwaymergesort;

import timing.Ticker;

public class KWayMergeSort {
	
	public static Integer[] kwaymergesort(int K, Integer[] input, Ticker ticker) {
		Integer[] ans = new Integer[input.length];
		
		//
		// FIXME
		// Following just copies the input as the answer
		// You must replace the loop below with code that performs
		// a K-way merge sort, placing the result in ans
		// Use the ticker as you normally would, to account for
		// the operations taken to perform the K-way merge sort
		//
		for (int i=0; i < input.length; ++i) {
			ans[i] = input[i];
			ticker.tick();
		}
		
		return ans;
	}

}
