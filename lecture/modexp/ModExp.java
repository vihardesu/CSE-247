package modexp;

/*
 * instructions to self:  refactor into a real class, capturing p
 * and computing the array at construction time
 */
public class ModExp {

	/**
	 * Compute w to the 10th power, mod p
	 * @param w
	 * @param p
	 * @return
	 */
	public static int tenthpower(int w, int p) {
		int sq = mod(w*w, p);
		int ans = sq;
		ans = mod(ans * ans, p);
		ans = mod(ans * ans, p);
		return mod(ans * sq, p);
	}
	
	private static int mod(int m, int p) {
		int res = m % p;
		while (res < 0) {
			res = res + p;
		}
		return res;
	}
	
	public static int modexp(int z, int n, int p) {
		z = mod(z,p);
		int[] h = new int[10];
		h[0] = 1;
		for (int i=1; i < 10; ++i) {
			h[i] = mod(h[i-1] * z, p);
		}
		char[] digs = (""+n).toCharArray();
		int ans = 1;
		for (int i=0; i < digs.length; ++i) {
			ans = mod(tenthpower(ans, p) * h[digs[i]-'0'], p);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		System.out.println(modexp(5,1567675554,23));

	}

}
