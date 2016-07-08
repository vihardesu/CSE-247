package studio7;

import java.util.Arrays;
import java.util.Iterator;

public class DBA<T> implements Iterable<T> {
	
	final private int first, last, inc;
	final private T[] data;
	
	public static<T> DBA<T> gen(T[] array) {
		return new DBA<T>(array, 0, array.length-1, 1);
	}
	
	/**
	 * 
	 * @param data the backing array
	 * @param first the first location that should be used, inclusively
	 * @param last  the last location that should be used, inclusively
	 * @param inc   the change in index that should occur between accesses
	 */
	private DBA(T[] data, int first, int last, int inc) {
		this.data  = data;
		this.first = first;
		this.last  = last;
		this.inc  = inc;
	}
	
	/**
	 * Returns a new DBA object which iterates through its contents in
	 *  the opposite direction of the DBA on which this method is called.
	 * @return
	 */
	public DBA<T> reverse() {
		// 
		// FIXME
		//
		return null;
	}
	
	/**
	 * Returns a new DBA object with a new range of accessible data
	 * @param newFirst the first index of the data for this range
	 * @param newLast the last index of the data for this range
	 * @return
	 */
	public DBA<T> slice(int newFirst, int newLast) {
		//
		// FIXME
		//
		return null;
	}
	
	/**
	 * Assigns a new value to the element at the specified index
	 * @param index
	 * @param value
	 */
	public void set(int index, T value) {
		// FIXME
	}
	
	/**
	 * Returns the value at the specified index
	 * @param index
	 * @return
	 */
	public T get(int index) {
		// FIXME
		return null;
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			
			private int i = first;

			@Override
			public boolean hasNext() {
				// FIXME
				return false;
			}

			@Override
			public T next() {
				// FIXME
				return null;
			}
			
		};
	}
	
	public String toString() {
		if (first <= last)
			return Arrays.toString(Arrays.copyOfRange(data, first, last+1)) + " first: " + first + " last: " + last;
		String s = "[";
		for (int i = last; i <= first; ++i) {
			s += data[i];
			if (i != first)
				s += ", ";
		}
		s += "] first: " + first + " last: " + last;
		return s;
	}

}
