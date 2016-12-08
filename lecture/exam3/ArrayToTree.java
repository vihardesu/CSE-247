package exam3;

public class ArrayToTree {
	
	private final int[] sortedarray;
	private final int[] treearray;
	
	/**
	 * Assert without checking that sortedarray.length is one less than a power of 2
	 * @param sortedarray
	 */
	public ArrayToTree(int[] sortedarray) {
		this.sortedarray = sortedarray;
		this.treearray   = new int[sortedarray.length + 1]; // burn index 0
	}
	
	/**
	 * Find the middle element and put it into the tree array at "where"
	 * Recursively ask for the middle elements of the remaining left and
	 *    right parts of the array to go where they should,
	 *    at 2*where      (left child of where)
	 *    at 2*where + 1  (right child of where)
	 * 
	 * @param start inclusive start of the range
	 * @param end   inclusive end of the range
	 * @param where the place in the tree array to store the middle value
	 */
	private void fillInTree(int start, int end, int where) {
		int middleValue = (start + end) / 2;

		treearray[where] = sortedarray[middleValue];
		
		if (middleValue-start == 0)  // anything remaining?
			return;
		//
		// Process left of middle and store result as my left child
		//
		fillInTree(start,         middleValue-1, 2*where    );
		//
		// Process right of middle and store result as my right child
		//
		fillInTree(middleValue+1, end,           2*where + 1);
	}
	
	public void fillInTree() {
		fillInTree(0, this.sortedarray.length-1, 1);
	}
	
	public int[] getTree() {
		return this.treearray;
	}

}
