package otp;

import java.util.Random;

import modexp.ModExp;

public class DH {
	
	private final long privKey, base, modulus;
	private final ModExp modexp;
	
	public DH(long privKey, long base, long modulus) {
		this.privKey = privKey;
		this.base    = base;
		this.modulus = modulus;
		this.modexp  = new ModExp(base, modulus);
	}
	
	public DH() {
		this(genRandLong(1567675554L), 5, 1567675554L);
	}
	
	public long getPubKey() {
		return modexp.toThePower(this.privKey);
	}
	
	public long getAgreedNum(long otherPubKey) {
		return ModExp.gToTheXModP(otherPubKey, this.privKey, this.modulus);
	}
	
	private static Random rand = new Random();
	
	private static long genRandLong(long n) {
		long ans = rand.nextLong();
		if (ans < 0) ans = - ans;
		while (ans >= n) {
			ans = ans / 10;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		DH dh1 = new DH(); // 6, 5, 23);
		DH dh2 = new DH(); // 15, 5, 23);
		long pub1 = dh1.getPubKey();
		long pub2 = dh2.getPubKey();
		System.out.println(dh1.getPubKey());
		System.out.println(dh2.getPubKey());
		System.out.println(dh1.getAgreedNum(pub2));
		System.out.println(dh2.getAgreedNum(pub1));
	}

}
