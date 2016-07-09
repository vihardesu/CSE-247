package timing;

/**
 * An algorithm needs an input of size n, and we express the complexity
 * of algorithms in terms of that input size.  This interface is needed
 * so that the timing and testing harnesses can demand input for
 * an algorithm if a specified size.
 * 
 * The complexity of some inputs formally takes more than one parameter.
 * Describing a graph with v vertices and e edges takes Theta(v+e) time.
 * For our purposes, n would the the sum of v and e here, so we can still
 * think of algorithms' complexities in terms of a single parameter. It
 * would then be up to genInput(n) to generate a graph whose vertices and
 * edges sum to n.
 * 
 * In the future perhaps the int argument should become int[] so that
 * we can characterize multiple parameters.  In fact as I write this
 * I regret not having int[] so much that I'm about to refactor to use
 * that.
 * @author roncytron
 *
 * @param <T>
 */
public interface InputProvider<T> {
	
	/**
	 * 
	 * @param n the complexity parameter 
	 * @return
	 */
	public T genInput(int n);

}
