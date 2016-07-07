package timing;

public interface Algorithm<T,U> extends RepeatRunnable {
	
	public void loadInput(T input);
	public U    getResults();

}
