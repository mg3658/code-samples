package filteriterator;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import menu.CriteriaOfBigPrice;
import menu.CriteriaOfPrice;
import menu.CriteriaOfVegetaria;
import menu.DinerMenu;
import menu.MenuItem;

/**
 * Test for FilterIterator 
 * @author mingmin
 *
 */
public class FilterIteratorTest {
  
  private Criteria<MenuItem> criteriaOfPrice;
  private Criteria<MenuItem> criteriaOfBigPrice;
  private Criteria<MenuItem> criteriaOfVegetaria;
  private DinerMenu dinerMenu;
  private Iterator<MenuItem> dineriterator;
  
  private Criteria<MenuItem> andCriteria;
  private Criteria<MenuItem> orCriteria;
  private Criteria<MenuItem> notCriteria;
  
  private Iterator<MenuItem> filterIterator;
  private Iterator<MenuItem> filterIterator2;
  

  @Before
  public void setUp() {
    dinerMenu = new DinerMenu();
    dineriterator = dinerMenu.createIterator();    
    criteriaOfPrice = new CriteriaOfPrice();
    criteriaOfBigPrice = new CriteriaOfBigPrice();
    criteriaOfVegetaria = new CriteriaOfVegetaria();
  }
  
  /**
   * Tests the constructor
   */
  @Test
  public void testBeforeConstructor() {
    assertTrue(criteriaOfPrice instanceof Criteria);
    assertTrue(criteriaOfBigPrice instanceof Criteria);
    assertTrue(criteriaOfVegetaria instanceof Criteria);   
  }
  
  /**
   * Tests one iterator argument is null.
   */
  @Test
  public void testOnlyOneArgumentNull() {
    try {
      filterIterator = new FilterIterator<MenuItem>(null);
      fail("Should have thrown ioe");
    } catch (IllegalArgumentException ioe) {
      assertEquals("Iterator cannot be null.", ioe.getMessage());
    }    
  }
  
  /**
   * Tests only one iterator argument isn't null.
   */
  @Test
  public void testSecondOneArgumentNotNull() {    
    filterIterator = new FilterIterator<MenuItem>(dineriterator);
    assertTrue(filterIterator instanceof Iterator); 
  }
  
  /**
   * Tests first one iterator argument is null.
   */
  @Test
  public void testFirstOneArgumentNull() {
    try {
      filterIterator = new FilterIterator<MenuItem>(null, criteriaOfPrice);
      fail("Should have thrown ioe");
    } catch (IllegalArgumentException ioe) {
      assertEquals("Iterator cannot be null.", ioe.getMessage());
    }    
  }
  
  /**
   * Tests second one iterator argument is null.
   */
  @Test
  public void testSecondOneArgumentNull() {    
    filterIterator = new FilterIterator<MenuItem>(dineriterator, null);
    assertTrue(filterIterator instanceof Iterator); 
  }
  
  /**
   * Tests Next() with throw 
   */
  @Test
  public void testNextThrow() {
    filterIterator = new FilterIterator<MenuItem>(dineriterator, criteriaOfBigPrice);
    try {
      MenuItem menuItem = (MenuItem) filterIterator.next();
      fail("should have thrown ioe");
    } catch (NoSuchElementException ioe) {
      assertEquals("No next object finded to matches this criteria.", ioe.getMessage());
    }      
  }
  
  /**
   * Tests Next() return next object
   */
  @Test
  public void testNextReturnObject() {
    filterIterator = new FilterIterator<MenuItem>(dineriterator, criteriaOfPrice);   
    MenuItem menuItem = (MenuItem) filterIterator.next();
    assertNotNull(menuItem);
  }
  
  /**
   * Tests hasNext() return true
   */
  @Test
  public void testHasNextTrue() {
    filterIterator = new FilterIterator<MenuItem>(dineriterator, criteriaOfPrice);   
    assertTrue(filterIterator.hasNext());
  }
  
  /**
   * Tests hasNext() return false
   */
  @Test
  public void testHasNextFalse() {
    filterIterator = new FilterIterator<MenuItem>(dineriterator, criteriaOfBigPrice);   
    assertFalse(filterIterator.hasNext());
  }
  
  /**
   * Tests two arguments FilterIterator
   * with one based criteria
   */
  @Test
  public void testFilterIteratorWithOneCriteria() {
    filterIterator = new FilterIterator<MenuItem>(dineriterator, criteriaOfPrice); 
    while (filterIterator.hasNext()) {
      MenuItem menuItem = (MenuItem) filterIterator.next();
      assertTrue(menuItem.getPrice() == 2.99);
    }
  }
  
  /**
   * Tests FilterIterator with AndCriteria 
   */
  @Test
  public void testFilterIteratorWithAndCriteria() {
    andCriteria = new AndCriteria<MenuItem>(criteriaOfPrice, criteriaOfVegetaria);
    filterIterator = new FilterIterator<MenuItem>(dineriterator, andCriteria); 
    while (filterIterator.hasNext()) {
      MenuItem menuItem = (MenuItem) filterIterator.next();
      assertTrue(menuItem.getPrice() == 2.99 && menuItem.isVegetarian() == true);
    }       
  }
  
  /**
   * Tests FilterIterator with OrCriteria 
   */
  @Test
  public void testFilterIteratorWithOrCriteria() {
    orCriteria = new OrCriteria<MenuItem>(criteriaOfPrice, criteriaOfVegetaria);
    filterIterator = new FilterIterator<MenuItem>(dineriterator, orCriteria); 
    while (filterIterator.hasNext()) {
      MenuItem menuItem = (MenuItem) filterIterator.next();
      assertTrue(menuItem.getPrice() == 2.99 || menuItem.isVegetarian() == true);
    }       
  }
  
  /**
   * Tests FilterIterator with NotCriteria 
   */
  @Test
  public void testFilterIteratorWithNotCriteria() {
    notCriteria = new NotCriteria<MenuItem>(criteriaOfVegetaria);
    filterIterator = new FilterIterator<MenuItem>(dineriterator, notCriteria); 
    while (filterIterator.hasNext()) {
      MenuItem menuItem = (MenuItem) filterIterator.next();
      assertTrue(menuItem.isVegetarian() == false);
    }       
  }
  
  /**
   * Tests FilterIterator with NullCriteria
   */
  @Test
  public void testFilterIteratorWithNullCriteria() {
    filterIterator = new FilterIterator<MenuItem>(dineriterator);    
    MenuItem menuItem1 = (MenuItem) filterIterator.next();
    MenuItem menuItem2 = (MenuItem) dineriterator.next();      
    assertTrue(menuItem1.getPrice() == menuItem2.getPrice());
  }
  
}