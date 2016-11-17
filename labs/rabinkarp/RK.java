package rabinkarp;

public class RK {
	int[] buffer;
	private int exponent = 1;
	private int hash;
	private int index;
	private int querySize;
	private int workingHash;
	private int deletion;
	
	
	// Be sure to look at the write up for this assignment
	//  so that you get full credit by satisfying all
	//  of its requirements
	//
	

	/**
	 * Rabin-Karp string matching for a window of the specified size
	 * @param m size of the window
	 */
	public RK(int m) {
		this.exponent = exponent;
		this.hash = 0;
		this.workingHash = 0;
		this.deletion = 0;
		this.querySize = m;
		this.buffer = new int [m];
		for (int j = 0; j<m; j++){
			exponent = (31*exponent)%511;
		}
		this.index = 0;
		
	}
	

	/**
	 * Compute the rolling hash for the previous m-1 characters with d appended.
	 * @param d the next character in the target string
	 * @return
	 */
	
	
	public int nextCh(char d) {
			int castedInput = (int)d;
			//the first if statement handles the cases where the first pass through the buffer doesn't account for subtraction
			if (index < querySize) {
				workingHash = ((hash * 31) % 511 + castedInput % 511 ) % 511;
				deletion = (exponent * buffer[index]) % 511;
				hash = (workingHash-deletion) % 511;
				if (hash < 0){
					hash = hash + 511;
				}
				buffer[index] = castedInput;
				index = index + 1;
			}
			//here, the index is reset and subtraction is accounted for 
			else{ 
				index = 0;
				workingHash = ((hash * 31 ) % 511 + castedInput % 511 ) % 511;
				deletion = (exponent * buffer[index]) % 511;
				hash = (workingHash - deletion);
				if (hash < 0){
					hash = hash + 511;
					buffer[index] = castedInput;
					index = index + 1;
				}
				else{
					buffer[index] = castedInput;
					index = index + 1;
				}
			}
			return hash;
		}
	
	}

