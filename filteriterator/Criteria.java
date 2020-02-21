package filteriterator;

/**
 * Defines a functor interface implemented by classed
 * that perform a criteria.
 * The implements include and, or, not methods.
 * @author mingmin
 *
 */
public interface Criteria<T> {
  
  /**
   * Uses the specified parameter to perform
   * a logical criteria that returns true or false.
   * @param object
   * @return true or false
   */
  public boolean accept(T object);
}