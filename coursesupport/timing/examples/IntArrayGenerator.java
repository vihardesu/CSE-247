package timing.examples;

import java.util.Random;

import timing.InputProvider;

public class IntArrayGenerator implements InputProvider<Integer[]> {

	@Override
	public Integer[] genInput(int size) {
		Random r = new Random();
		Integer[] ans = new Integer[size];
		for (int i=0; i < ans.length; ++i) {
			ans[i] = r.nextInt();
		}
		return ans;
	}

}
