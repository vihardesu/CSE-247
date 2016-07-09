package timing.utils;

import java.util.Random;

import timing.ComplexityParameters;
import timing.InputProvider;

public class IntArrayGenerator implements InputProvider<Integer[]> {

	@Override
	public Integer[] genInput(ComplexityParameters size) {
		Random r = new Random();
		Integer[] ans = new Integer[size.getFirstParameter()];
		for (int i=0; i < ans.length; ++i) {
			ans[i] = r.nextInt();
		}
		return ans;
	}

}
