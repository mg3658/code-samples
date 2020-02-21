package filteriterator;

/**
 * Criteria implementation AND operation.
 * If both the criteria return true, then return true.
 * Otherwise, false.
 * @author mingmin
 *
 */
public final class AndCriteria<T> implements Criteria<T> {
  
  private final Criteria<T> criteria1;
  
  private final Criteria<T> criteria2;
  
  /**
   * Constructors an AndCriteria with two based criteria.
   * @param critera1
   * @param critera2
   * @throws IllegalArgumentException if either of the criteria is null
   */
  public AndCriteria(Criteria<T> criteria1, Criteria<T> criteria2) {
    if (criteria1 == null || criteria2 == null) {
      throw new IllegalArgumentException("Criteria cannot be null.");
    }
    this.criteria1 = criteria1;
    this.criteria2 = criteria2;
  }

   /**
    * Returns the results for two criteria AND operation.
    * If both criteria return true, then return true. 
    * @param object
    * @return true if both criteria return true
    *     otherwise false.
    */
  public boolean accept(T object) {
   
    return (criteria1.accept(object) && criteria2.accept(object));
  }
  
}
