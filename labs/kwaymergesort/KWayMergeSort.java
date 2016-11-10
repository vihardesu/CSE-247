package kwaymergesort;

import timing.Ticker;

public class KWayMergeSort {
	
	/**
	 * 
	 * @param K some positive power of 2.
	 * @param input an array of unsorted integers.  Its size is either 1, or some other power of 2 that is at least K
	 * @param ticker call .tick() on this to account for the work you do
	 * @return
	 */
	public static Integer[] kwaymergesort(int K, Integer[] input, Ticker ticker) {
		int n = input.length;
		
		//
		// FIXME
		// Following just copies the input as the answer
		//
		// You must replace the loop below with code that performs
		// a K-way merge sort, placing the result in ans
		//
		// The web page for this assignment provides more detail.
		//
		// Use the ticker as you normally would, to account for
		// the operations taken to perform the K-way merge sort.
		//
		
		//!!This Logic is wrong, and is how I initially started, but I thought I would keep it up anyway!!
		//Note: the ans will be an array that is the sorted version on the input array
		//Base Case where input.length (n) = 1; then the input array is the answer
		//When input.length does not equal 1; then recursively call kwaymergesort until
		//the smallest arrays are equivalent to 1 (total number of arrays will equal n)
		
		//Start of Processing Code:
		//0) make a double array: Integer[][] dubArray = new Integer[][]
		//size of array, Q, is determined by for loop below:
		//for (int i = 0; i<j; i++){ sum = sum + 2^i} where int j = (log of base k of (n)); int sum = 0 initially;
		//sum*2 + n = Q;
		
		//1) Prepare
		//put input[] into dubArray[0][];
		//prepare to put all other arrays into proceeding columns
		
		//2) Use a for-loop to split up the n-array into k equal arrays by:
		//Make k arrays, populate k arrays with the content of the input array like so:
		//in the below for-loop that cycles through n:
		//for (i=0-->k){push input[n] into array of size n/k into next open column and row in dubArray[][]}
		//Recursively repeat this step until there are n arrays each of size 1
		
		//3 Start the sorting; understand where the location of all the single arrays of n are from each other

		
		//factor is a variable that describes the size of the first arrays
		int factor = n/K;
		Integer[] ans = new Integer[n];
		//This is the Base Case. It Checks if the input array's size is 1; if it is, it is already sorted.
		if (n == 1) {
			ticker.tick();
			return input;
		}

		Integer[][] processingArray = new Integer[K][factor];
		ticker.tick(n);
		
		int incrementer = -1; //this will be used to increment and populate the processingArray
		for (int i = 0; i < n; i++) {
			//incrementer will increase every time i reaches a multiple of factor, which is the size of the first arrays
			if(i % factor == 0){
				incrementer++;
			}
			//the processingArray will be populated with arrays of size factor with the input array's original sequence
			processingArray[incrementer][i%(factor)] = input[i];
			ticker.tick();	
		}
		
		//this loop is to iterate the process from above until the size of the arrays split up are 1 individually
		//basically, if n = 8, k = 2, the above step would populate two arrays of size 4 that each half of input
		//this step would repeat the procedure above for the above 2 arrays (if n = 8, k = 2)
		//it allocates space for the subsequent arrays in the next column of the same row the 2 arrays
		//therefore, there will be two rows, each with the first index having a 4 int array, next index with 2, 2 int arrays
		
		for(int i= 0; i<K; i++){
			processingArray[i] = kwaymergesort(K, processingArray[i], ticker);
			ticker.tick();
		}
		
		//once the splitting process is complete, running this method will append the values in numerical order
		return merger(processingArray, ticker);
	}
	
	public static Integer[] merger(Integer[][] numbers, Ticker ticker){
		//this occurs when the original input array doesn't split up into sub-arrays because it might already be small enough
		//row count is 1
		if (numbers.length == 1){
			return numbers[0];
		}
		
		//this is base case where the rows that merges two sub arrays
		else if (numbers.length == 2){
			Integer[] sol = new Integer[numbers[0].length*2];
			//these two variables will be used as checkers of each individual sub array
			int x = 0; 
			int y = 0;
			while((x+y)<(numbers[0].length*2)){
				if (x<numbers[0].length&&y<numbers[0].length){
					if (numbers[0][x].compareTo(numbers[1][y])<0){
						sol[x+y] = numbers[0][x];
						x++;
						ticker.tick();
					}
					else {
						sol[x+y] = numbers[1][y];
						y++;	
						ticker.tick();
					}
				}
				//this will occur when all values in the second array are appended onto one array
				else if (y==numbers[0].length){
					sol[x+y] = numbers[0][x];
					x++;
					ticker.tick();
				}
				//when all values first array are appended onto one array
				else if (x==numbers[0].length){
					sol[x+y] = numbers[1][y];
					y++;
					ticker.tick();
				}
			}
			return sol;
			//the returned array that is combined
		}		
		
		else {
			
			//this step is the recursion
			//the number of int arrays will always decrease by factor of k at each step
			//so keeping track...
			Integer[][] temporary = new Integer[numbers.length/2][numbers[0].length*2];
			ticker.tick(numbers.length*numbers[0].length);
			for (int i = 0; i < numbers.length; i+=2){
				temporary[i/2] = merger(new Integer[][] {numbers[i], numbers[i+1]}, ticker);	
				ticker.tick();
			}
			return merger(temporary, ticker);
		}
	}

}
