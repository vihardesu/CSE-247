package otp;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Carries a character along with whether it has been rotated or not
 * If it has been rotated, the character is the rotated version, not the original.
 * If it has not been rotated, the character is the original character.
 * @author roncytron
 *
 */
public class Caesared {

	private final boolean rotated;
	private final char c;

	/**
	 * Only this class can create an instance, using the static method gen.
	 * Note that we do not remember the rotation amount, as that was imposed by
	 *   cryptography.
	 * @param rotated was this character rotated?
	 * @param c if rotated, the value of the rotated character; otherwise the original character
	 */
	private Caesared(boolean rotated, char c) {
		this.rotated = rotated;
		this.c       = c;
	}
	
	private static void check(long rotation) {
		if (rotation < 0)
			throw new IllegalArgumentException("Must supply nonnegative rotation value but you supplied " + rotation);
	}

	public String toString() {
		return ""+c;
	}

	/**
	 * Only rotates characters between 'a' and 'z' so we can see some things clearly.
	 * @param c cleartext character
	 * @param rotation rotation amount
	 * @return an instance of Caesared containing the possibly rotated character
	 */
	public static Caesared gen(char c, long rotation) {
		check(rotation);
		if (c >= 'a' && c <= 'z') {
			char r = (char) (((c-'a') + rotation) % 26 + 'a');
			return new Caesared(true, r);
		}
		else return new Caesared(false, c);
	}

	/**
	 * Return the contained character unrotated by the specified amount.
	 * If the character was not rotated, we just return the character without unrotating it.
	 * @param rotation the amount to unrotate, must be positive
	 * @return the answer as described above.
	 */
	public char unRotate(long rotation) {
		check(rotation);
		if (!rotated)
			return c;
		else {
			rotation = rotation % 26;
			return (char)((c-'a' + (26-rotation)) % 26 + 'a');
		}
	}

	/**
	 * Demonstrate this class
	 * @param args
	 */
	public static void main(String[] args) {
		//
		// choose a random rotation amount
		//
		int rot = new Random().nextInt(100000);
		System.out.println("Rotation value: " + rot);
		//
		// Simple input string
		//
		String s = "This is a string with at least 10 characters in it but not 247.";
		List<Caesared> list = new LinkedList<Caesared>();

		// Add each rotated characer to a list

		String r = "";
		for (char c : s.toCharArray()) {
			Caesared cs = gen(c,rot);
			r = r + cs;
			list.add(cs);
		}
		System.out.println("Rotated:   " + r);

		//
		// Now unrotate and show the result
		//
		String ur = "";
		for (Caesared cs : list) {
			ur = ur + cs.unRotate(rot);
		}
		System.out.println("Unrotated: " + ur);
	}
}
