package modexp;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ModExp {
	
	private long z, p;
	private long[] h;
	
	private Map<Long,Long> discreteLog;
	
	public ModExp(long z, long p) {
		this.discreteLog = null;
		this.p = p;
		this.z = mod(z,p);
		h = new long[10];
		h[0] = 1;
		for (int i=1; i < 10; ++i) {
			h[i] = mod(h[i-1] * this.z, this.p);
		}
	}

	/**
	 * Compute w to the 10th power, mod p
	 * @param w
	 * @param p
	 * @return
	 */
	public static long tenthpower(long w, long p) {
		long sq = mod(w*w, p);
		long ans = sq;
		ans = mod(ans * ans, p);
		ans = mod(ans * ans, p);
		return mod(ans * sq, p);
	}
	
	/**
	 * Protects against a negative result mod p
	 * @param m
	 * @param p
	 * @return m mod p as traditionally computed in math, a result in range 0...p-1
	 */
	private static long mod(long m, long p) {
		long res = m % p;
		while (res < 0) {
			res = res + p;
		}
		return res;
	}
	

	/**
	 * 
	 * @param n exponent
	 * @return this.z to the n mod this.p
	 */
	public long modexp(long n) {
		char[] digs = (""+n).toCharArray();
		long ans = 1;
		for (int i=0; i < digs.length; ++i) {
			ans = mod(tenthpower(ans, this.p) * h[digs[i]-'0'], p);
		}
		return ans;
	}
	
	public Long discreteLog(long y) {
		//
		// If the reverse map is not yet computed, fill it all in
		//
		if (this.discreteLog == null) {
			this.discreteLog = new HashMap<Long,Long>();
			for (long i=0; i < this.p; ++i) {
				long ans = modexp(i);
				discreteLog.put(ans, i);
				if (i % 1000000 == 0) System.out.println(new Date().toString() + " At " + i);
			}
		}
		return discreteLog.get(y);
	}
	
	
	public static void main(String[] args) {
		ModExp smallie = new ModExp(5,23);
		System.out.println("Examples from lecture (^ means exponentiation here):");
		System.out.println("  5^6 mod 23 = " + smallie.modexp(6));
		System.out.println("  5^15 mod 23 = " + smallie.modexp(15));
		System.out.println("Discrete logs of those:");
		System.out.println("  discrete log of 8: " + smallie.discreteLog(8));
		System.out.println("  discrete log of 19: " + smallie.discreteLog(19));
		//
		// Compute 5 to a really large integer mod 23:
		//
		System.out.println("5^1567675554L mod 23 = " + smallie.modexp(1567675554L));
		System.out.println("Now a much larger modulus:  " + 67867967L);
		ModExp biggie = new ModExp(5,67867967L);
		System.out.println("5^1000232 mod 67867967L = " + biggie.modexp(1000232));
		//
		// Will take about 1/2 an hour to compute
		//
		System.out.println(biggie.discreteLog(23));
		
		

	}

}
