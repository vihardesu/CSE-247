package exam3;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class TestArrayToTree {
	
	@Test
	public void test() {
		for (int i=2; i <=1024; i = i * 2) {
			testcode(i);
		}
	}

	private void testcode(int pow2) {
		int n = pow2-1;  //  n is one less than a power of 2
		int[] nums = genNums(n);
		ArrayToTree att = new ArrayToTree(nums);
		att.fillInTree();
		System.out.println("array as tree (ignore index 0): " + Arrays.toString(att.getTree()));
	}
	
	private int[] genNums(int num) {
		int[] ans = new int[num];
		for (int i=0; i < num; ++i) {
			ans[i] = 100+i;
		}
		Arrays.sort(ans);   // they are already sorted
		return ans;
	}
}
