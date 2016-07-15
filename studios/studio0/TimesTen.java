package studio0;

import timing.ExecuteAlgorithm;
import timing.utils.GenSizes;
import timing.utils.IntArrayGenerator;

public class TimesTen extends Rarrays {

	/**
	 * We ask for a new, bigger array that is 4 times as large
	 *  as the current one.
	 */
	public int getNewSize() {
		return 10 * array.length;
	}
	
	public String toString() { return "Grow by multiplying by 10"; }

	public static void main(String[] args) {
		GenSizes sizes = GenSizes.arithmetic(1, 1000, 1);
		ExecuteAlgorithm.timeAlgorithm(
				"times10", 
				"studio0.TimesTen", 
				new IntArrayGenerator(), 
				sizes
				);	
	}
}
