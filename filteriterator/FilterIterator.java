package filteriterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Implement FilterIterator with Criteria.
 * A filterIerator is an iterator that can be used to wrap an existing iterator
 * but skip an values that do not satisfy a specified criteria.
 * A filterIterator must take an iterator and criteria as constructor arguments.
 * A filterIterator must behave correctly for all calls to Next and hasNext.
 * A filterIterator should throw an UnSupportedoperationException in remove().
 * Criteria should allow users to create their own criteria classes.
 * Implement AndCriteria, OrCriteria, and NotCriteria with Factory Methods.
 * @author mingmin
 *
 */
public class FilterIterator<T> implements Iterator<T>{

  /** The iterator being used */
  private Iterator<T> iterator;
  
  /** The Criteria being used */
  private Criteria<T> criteria;
  
  /** The next object in the iteration */
  private T nextObject;
  
  /** Flag for the next object */
  private boolean nextObjectSet = false;  
  
  /**
   * Constructors a new FilterIterator 
   * used with given iterator
   * @param iterator the iterator to use
   */
  public FilterIterator(Iterator<T> iterator) {
    if (iterator == null) {
      throw new IllegalArgumentException("Iterator cannot be null.");
    } 
    this.iterator = iterator;
  }

  /**
   * Constructors a new FilterIterator
   * used with given iterator and criteria
   * @param iterator the iterator to use
   * @param criteria the criteria to use
   */
  public FilterIterator(Iterator<T> iterator, Criteria<T> criteria) {
    if (iterator == null) {
      throw new IllegalArgumentException("Iterator cannot be null.");
    } 
    this.iterator = iterator;
    this.criteria = criteria;
  }

  /**
   * Returns true if the iterator contains an object that
   * matches this criteria
   * @return true if there is another object that matches the criteria
   */
  public boolean hasNext() {
    if (nextObjectSet) {
      return true;
    } else {
      return setNextObject();
    }    
  }  

  /**
   * Returns the next object if fined to match this criteria.
   * 
   * @return the next object
   * @throws NoSuchElementException if there are no more objects to match 
   *     this criteria
   */
  public T next() {
    if (! nextObjectSet) {
      if (! setNextObject()) {
        throw new NoSuchElementException("No next object found" +
        		" to matches this criteria.");
      }
    }
    nextObjectSet = false;
    return nextObject;
  }

  /**
   * Do not want to provide the ability
   * to remove something from the underlying collection 
   * of objects.
   * @throws UnsupportedOperationException 
   */
  public void remove() {
    throw new UnsupportedOperationException();   
  }
  
  /**
   * Sets nextObject to the next object.
   * If there are no more objects matches the criteria,
   * then return false. Otherwise, return true.
   * @return false if no more next object 
   *         true if find next object
   */
  private boolean setNextObject() {
    while (iterator.hasNext()) {
      T object = iterator.next();
      if (criteria == null) {
        nextObject = object;
        nextObjectSet = true;
        return true;
      } else if (criteria.accept(object)) {
        nextObject = object;
        nextObjectSet = true;
        return true;
      }
    }
    return false;
  }

  /**
   * Gets this iterator used.
   * @return the iterator
   */
  public Iterator<T> getIterator() {
    return iterator;
  }

  /**
   * Sets the iterator to use.
   * @param iterator the iterator to set
   */
  public void setIterator(Iterator<T> iterator) {
    this.iterator = iterator;
  }

  /**
   * Gets this criteria used.
   * @return the criteria
   */
  public Criteria<T> getCriteria() {
    return criteria;
  }

  /**
   * Sets the criteria to use.
   * @param criteria the criteria to set
   */
  public void setCriteria(Criteria<T> criteria) {
    this.criteria = criteria;
  }
   
}