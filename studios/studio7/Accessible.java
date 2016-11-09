package studio7;

abstract public class Accessible<T> extends Iterable<T> {
	
	private Accessible<T> base;
	
	public Accessible(Accessible<T> base) {
		this.base = base;
	}

	abstract public int view(int which);
	

	public T get(int which) {
		return base.get(view(which));
	}
	
	public void set(int which, T what) {
		base.set(view(which), what);
	}
	
	public Iterator<T> () {
		return new Iterator() {
			
		}
	}

}
