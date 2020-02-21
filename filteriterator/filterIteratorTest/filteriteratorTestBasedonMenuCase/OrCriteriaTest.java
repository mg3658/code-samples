package filteriterator;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

import menu.CriteriaOfPrice;
import menu.CriteriaOfVegetaria;
import menu.DinerMenu;
import menu.MenuItem;

/**
 * Test for OrCriteria
 * @author mingmin
 *
 */
public class OrCriteriaTest {

  private Criteria<MenuItem> criteriaOfPrice;
  private Criteria<MenuItem> criteriaOfVegetaria;
  private Criteria<MenuItem> orCriteria;

  @Before
  public void setUp() {
    criteriaOfPrice = new CriteriaOfPrice();
    criteriaOfVegetaria = new CriteriaOfVegetaria();
  }
  
  /**
   * Tests the constructor
   */
  @Test
  public void testBeforeConstructor() {
    assertTrue(criteriaOfPrice instanceof Criteria);
    assertTrue(criteriaOfVegetaria instanceof Criteria);   
  }
  
  /**
   * Tests first criteria argument is Null.
   */
  @Test
  public void testFirstOneNullCriteria() {    
    try {
      orCriteria = new OrCriteria<MenuItem>(null, criteriaOfVegetaria);
      fail("Should have thrown an ioe");  
    } catch (IllegalArgumentException ioe) {
      assertEquals("Criteria cannot be null.", ioe.getMessage());
    }    
  }
  
  /**
   * Tests second criteria argument is Null.
   */
  @Test
  public void testSecondOneNullCriteria() {    
    try {
      orCriteria = new OrCriteria<MenuItem>(criteriaOfPrice, null);
      fail("Should have thrown an ioe");  
    } catch (IllegalArgumentException ioe) {
      assertEquals("Criteria cannot be null.", ioe.getMessage());
    }
  }
  
  /**
   * Tests both criteria arguments are Null.
   */
  @Test
  public void testBothNullCriteria() {    
    try {
      orCriteria = new OrCriteria<MenuItem>(null, null);
      fail("Should have thrown an ioe");  
    } catch (IllegalArgumentException ioe) {
      assertEquals("Criteria cannot be null.", ioe.getMessage());
    }
  }
  
  /**
   * Tests both criteria arguments are not Null.
   */
  @Test
  public void testBothNotNullCriteria() {       
    orCriteria = new OrCriteria<MenuItem>(criteriaOfPrice, criteriaOfVegetaria);
    assertTrue(orCriteria instanceof Criteria);
  }
  
  /**
   * Test OR Operation accept()
   */
  @Test
  public void testAndCriteriaAccept(){
    orCriteria = new OrCriteria<MenuItem>(criteriaOfPrice, criteriaOfVegetaria);
    DinerMenu dinerMenu = new DinerMenu();
    Iterator<MenuItem> iterator = dinerMenu.createIterator();
    while (iterator.hasNext()) {
      MenuItem menuItem = iterator.next();
      assertEquals(orCriteria.accept(menuItem), 
          criteriaOfPrice.accept(menuItem) || 
          criteriaOfVegetaria.accept(menuItem));
    }
    
  }


}
