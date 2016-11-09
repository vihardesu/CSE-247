package studio7;

public class BaseArray<T> implements  {

	private T[] array;
	
	public BaseArray(T[] array) {
		this.array = array;
	}

	@Override
	public int getLocOf(int which) {
		return which;
	}

	@Override
	public int getFirstLoc() {
		return 0;
	}

	@Override
	public int getLastLoc() {
		return array.length;
	}
	
	
}
