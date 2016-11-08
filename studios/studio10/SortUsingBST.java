package studio10;

import java.util.Iterator;

import timing.Algorithm;
import timing.ExecuteAlgorithm;
import timing.Ticker;
import timing.utils.GenSizes;
import timing.utils.IntArrayGenerator;
import timing.utils.IntSequenceArrayGenerator;

public class SortUsingBST implements Algorithm<Integer[], Integer[]> {

	private Integer[] originalArray;
	private Ticker ticker;
	private BST<Integer> bst;

	public SortUsingBST() {

	}

	@Override
	public void reset(Ticker ticker) {
		this.ticker = ticker;
		this.bst = new BST<Integer>(this.ticker);
	}

	@Override
	public void loadInput(Integer[] input) {
		this.originalArray = input;
	}

	@Override
	public Integer[] getResults() {
		Integer[] ans = new Integer[originalArray.length];
		Iterator<Integer> iter = bst.iterator();
		for (int i=0; i < ans.length; ++i) {
			ans[i] = iter.next();
		}
		return ans;
	}

	@Override
	public void run() {
		for (Integer i : originalArray) {
			bst.add(i);
		}
	}

	public String toString() {
		return "Sorted set using BST of " + originalArray.length + " numbers";
	}
	
	public static void main(String[] args) {
		GenSizes sizes = GenSizes.arithmetic(100, 10000, 100);
		ExecuteAlgorithm.timeAlgorithm(
				"sortusingbst", 
				"studio10.SortUsingBST", 
				new IntArrayGenerator(), 
/*				new IntSequenceArrayGenerator(),   */
				sizes
				);
	}

}
