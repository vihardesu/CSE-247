package studio7;

public interface View<T> {
	
	public int getLocOf(int which);
	public int getFirstLoc();  // inclusve
	public int getLastLoc();   // non inclusive
	
}
