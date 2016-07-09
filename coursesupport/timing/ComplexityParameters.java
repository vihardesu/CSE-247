package timing;

import java.util.Arrays;

public class ComplexityParameters {
	
	private final int[] params;
	
	private ComplexityParameters(int[] params) {
		this.params = Arrays.copyOf(params, params.length);
	}
	
	private ComplexityParameters(int one) {
		this(new int[] { one });
	}
	
	private ComplexityParameters(int one, int two) {
		this(new int[] { one, two });
	}
	
	public int getFirstParameter() {
		return params[0];
	}
	
	public int getSecondParameter() {
		return params[1];
	}
	
	public int[] getParamters() {
		return Arrays.copyOf(this.params, this.params.length);
	}
	
	// Factory methods
	
	public static ComplexityParameters gen(int one) {
		return new ComplexityParameters(one);
	}
	
	public static ComplexityParameters gen(int one, int two) {
		return new ComplexityParameters(one, two);
	}
	
	public String toString() {
		String ans = "(" + params[0];
		for (int i=1; i < params.length; ++i) {
			ans += "," + params[i];
		}
		ans += ")";
		return ans;
	}

}
