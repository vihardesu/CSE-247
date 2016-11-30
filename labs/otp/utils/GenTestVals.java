package otp.utils;

import java.util.LinkedList;
import java.util.List;

import otp.DH;

/**
 * Generate public and private pairs for checking using RKC solution
 * @author roncytron
 *
 */
public class GenTestVals {

	
	private static void out(String name, List<Long> nums) {
		System.out.print("private static final long[] " + name + " = new long[] {");
		for (long l : nums) {
			System.out.print(" " + l + "L" +",");
		}
		System.out.println("};");
		
	}
	public static void main(String[] args) {
		RandomWithBoundedLong rand = new RandomWithBoundedLong();
		DHFactory dhf= new DHFactory(DHFactory.BASE, DHFactory.LARGEPRIME);
		List<Long> privs = new LinkedList<Long>();
		List<Long> pubs  = new LinkedList<Long>();
		for (int i=0; i < 1000; ++i) {
			long privkey = rand.nextLong(DHFactory.LARGEPRIME);
			DH dh = dhf.nextDH(privkey);
			privs.add(privkey);
			pubs.add(dh.getPubKey());
		}
		out("privs", privs);
		out("pubs", pubs);

	}

}
