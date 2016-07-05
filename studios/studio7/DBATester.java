package studio7;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Random;
import org.junit.Test;

public class DBATester {

	@Test
	public void testSlice() {
		testGetAndSet();
		Integer[] array = genRandomArray(10);
		DBA<Integer> base = DBA.gen(array);
		DBA<Integer> slice1 = base.slice(0, 5);
		for (int i = 0; i < 6; ++i) {
			assertEquals("Your slice does not contain the same values as the base", base.get(i), slice1.get(i));
		}

		base.set(0, 1000);
		assertEquals("Your slice wasn't updated when the base was changed", base.get(0), slice1.get(0));
		slice1.set(0, 1001);
		assertEquals("Your base wasn't updated when the slice was changed", base.get(0), slice1.get(0));

		DBA<Integer> slice2 = base.slice(5, 9);
		slice2.set(5, 1002);
		assertEquals("Your base wasn't updated when the slice was changed", slice2.get(5), base.get(5));
		assertEquals("The first slice wasn't updated when the second slice was changed", slice2.get(5), slice1.get(5));
		assertTrue("Your base and slice weren't updated to reflect the second slice", base.get(5).equals(slice1.get(5)));
	}

	@Test
	public void testIterator() {
		testGetAndSet();
		Integer[] array = genRandomArray(10);
		DBA<Integer> base = DBA.gen(array);
		Iterator<Integer> baseIter = base.iterator();

		int i = 0;
		while (baseIter.hasNext()) {
			assertEquals("Your iterator does not return the correct value", array[i], baseIter.next());
			i++;
		}

		DBA<Integer> slice1 = base.slice(0, 4);
		baseIter = base.iterator();
		Iterator<Integer> sliceIter = slice1.iterator();
		while (sliceIter.hasNext()) {
			assertEquals("Your slice's iterator does not return the correct value", baseIter.next(), sliceIter.next());
		}
	}

	@Test
	public void testReverse() {
		testGetAndSet();
		Integer[] array = genRandomArray(10);
		DBA<Integer> slice1 = DBA.gen(array).reverse().slice(5, 3);
		Iterator<Integer> sliceIter = slice1.iterator();
		
		assertTrue("Your hasNext() function does not work when first > last. Slice: '" + slice1 + "'", sliceIter.hasNext());
		int i = 5;
		while (i >= 3) {
			assertEquals("Your iterator does not return the correct value", array[i], sliceIter.next());
			i--;
		}
		assertTrue("Your hasNext() function does not work when first > last. Slice: '" + slice1 + "'", !sliceIter.hasNext());
	}

	@Test
	public void testIndexBounds() {
		testGetAndSet();
		Integer[] array = genRandomArray(10);
		DBA<Integer> base = DBA.gen(array);
		DBA<Integer> slice1 = base.slice(0, 4);

		for (int i = 5; i < 10; ++i) {
			try {
				slice1.get(i);
			} catch (Error e) {
				continue;
			}
			fail("Your slice: '" + slice1 + "' should not be able to access the value at index " + i);
		}

		for (int i = 5; i < 10; ++i) {
			Integer original = array[i];
			try {
				slice1.set(i, i*100);
			} catch (Error e) {
				assertEquals("Your slice: '" + slice1 + "' should not be able to change the value at index " + i, 
						original, base.get(i));
				continue;
			} 
			fail("Your slice: '" + slice1 + "' should not be able to change the value at index " + i);
		}
	}
	
	private void testGetAndSet() {
		Integer[] array = genRandomArray(10);
		DBA<Integer> base = DBA.gen(array);
		for (int i = 0; i < 10; ++i) {
			assertEquals("Your get() method does not return the correct value", array[i], base.get(i));
			base.set(i, (i+1)*1000);
			assertEquals("Your set() method does not set the correct value", new Integer((i+1)*1000), base.get(i));
		}
	}

	private Integer[] genRandomArray(int numElements) {
		Random r = new Random();
		Integer[] randArray = new Integer[numElements];
		for (int i = 0; i < numElements; ++i) {
			randArray[i] = r.nextInt(numElements);
		}
		return randArray;
	}
}
