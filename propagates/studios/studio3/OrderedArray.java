package studio3;

public class OrderedArray<T extends Comparable<T>> implements PriorityQueue<T> {

	public T[] array;
	public T[] newArray;
	private int size;
	
	@SuppressWarnings("unchecked")
	public OrderedArray(int maxSize) {
		array = (T[]) new Comparable[maxSize];
		newArray = (T[]) new Comparable[maxSize+1];
		size = 0;
	}
	
	@Override
	public boolean isEmpty() {
		if (size == 0){
			return true;
		}
		else{
		return false;
	}
	}

	@Override
	public void insert(T thing) {
		
		for(int i = 0; i < size; i++){
			if(thing.compareTo(array[i])>0 && thing.compareTo(array[i+1])>0){
				newArray[i+1] = array[i];
				newArray[i] = thing;
				
			}
		}
			size ++;
	}
	/*public T extractMin() {
		T min = list.get(0);
		for (T item : list){
			if(min.compareTo(item) > 0){
				min = item;
			}
		}
		list.remove(min);
		return min;
	}*/
	
	@Override
	public T extractMin() {
		//
		// FIXME
		//
		return null;
	}

}
