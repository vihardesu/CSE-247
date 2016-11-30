package studio12;

import otp.utils.Caesared;

public class BreakCaesar {
	
	private Caesared[] message;
	private char[] chars;
	
	public BreakCaesar(Caesared[] message) {
		this.message = message;
		this.chars = new char[message.length];
		for (int i=0; i < message.length; ++i) {
			chars[i] = message[i].toString().toCharArray()[0];
		}
	}
	
	/**
	 * Analyze the characters in chars to determine the rotation value (between 0 and 25)
	 * and return that value.  For example, if a becomes b, b becomes c, etc, the rotation value is 1
	 * @return the rotation factor that created the encrypted text
	 */
	public int getRotation() {
		return 0; // FIXME
	}
	
	public String getClearText() {
		String ans = "";
		int rotate = getRotation();
		for (int i=0; i < message.length; ++i) {
			ans = ans + message[i].unRotate(rotate);
		}
		return ans;
	}

}
