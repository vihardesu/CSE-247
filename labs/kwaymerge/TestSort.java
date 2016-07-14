package kwaymerge;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Random;

public class TestSort {

	@org.junit.Test
	public void testKWayMergeSort() {
		for(int i = 0; i < 800; ++i){
			int k = (int)(Math.random() * i) + 2;
			int numElements = (int)(Math.random() * (i * 10)) + 1;
			System.out.println("k: " + k + " numElements: " + numElements);
			
			int[] unsortedArray = genRandomArray(numElements);
			int[] sortedArray = unsortedArray.clone();
			Arrays.sort(sortedArray);
			System.out.println("given:    " + Arrays.toString(unsortedArray));
			
			KWayMergeSort kms = new KWayMergeSort(k, unsortedArray);
			kms.sort();

			System.out.println("expected: " + Arrays.toString(sortedArray));
			System.out.println("actual:   " + Arrays.toString(unsortedArray));
			assertArrayEquals("Your array is not properly sorted", sortedArray, unsortedArray);
		}
	}

	private int[] genRandomArray(int numElements) {
		Random r = new Random();
		int[] randArray = new int[numElements];
		for (int i = 0; i < numElements; ++i) {
			randArray[i] = r.nextInt(numElements);
		}
		return randArray;
	}
}
