package studio7;

import java.util.Iterator;

public interface GetterSetterIter<T> extends Iterable<T>{
	
	public T get(int which);
	public void set(int which, T val);
	public Iterator<T> iterator();

}
