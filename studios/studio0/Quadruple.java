package studio0;

import timing.ExecuteAlgorithm;
import timing.utils.GenSizes;
import timing.utils.IntArrayGenerator;

public class Quadruple extends Rarrays {

	/**
	 * We ask for a new, bigger array that is 4 times as large
	 *  as the current one.
	 */
	public int getNewSize() {
		return 4 * array.length;
	}
	
	public String toString() { return "Grow by quadrupling"; }

	public static void main(String[] args) {
		GenSizes sizes = GenSizes.arithmetic(1, 1000, 1);
		ExecuteAlgorithm.timeAlgorithm(
				"quadruple", 
				"studio0.Quadruple", 
				new IntArrayGenerator(), 
				sizes
				);	
	}

}
