package filteriterator;

/**
 * Criteria implementation Not operation.
 * It returns the opposite of the given criteria.
 * @author mingmin
 *
 */
public final class NotCriteria<T> implements Criteria<T>{

  private final Criteria<T> criteria; 
  
  /**
   * Constructors a NotCriteria with one based criteria.
   * @param criteria
   * @throws IllegalArgumentException if the criteria is null.
   */
  public NotCriteria(Criteria<T> criteria) {
    if (criteria == null) {
      throw new IllegalArgumentException("Criteria cannot be null.");
    }    
    this.criteria = criteria;
  }

  /**
   * Returns the results for the criteria Not operation.
   * It returns the opposite of the given criteria.
   * @param object
   * @return the opposite of the given criteria.
   */
  public boolean accept(T object) {
    
    return ! criteria.accept(object);
  }
   
}