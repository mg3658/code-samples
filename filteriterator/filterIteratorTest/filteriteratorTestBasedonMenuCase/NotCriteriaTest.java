package filteriterator;

import static org.junit.Assert.*;


import org.junit.Test;
import java.util.Iterator;

import org.junit.Before;

import menu.CriteriaOfVegetaria;
import menu.DinerMenu;
import menu.MenuItem;

/**
 * Test for NotCriteria
 * @author mingmin
 *
 */
public class NotCriteriaTest {

  private Criteria<MenuItem> criteriaOfVegetaria;
  private Criteria<MenuItem> notCriteria;

  @Before
  public void setUp() {
    criteriaOfVegetaria = new CriteriaOfVegetaria();
  }
  
  /**
   * Tests the constructor
   */
  @Test
  public void testBeforeConstructor() {
    assertTrue(criteriaOfVegetaria instanceof Criteria);   
  }
  
  /**
   * Tests first criteria argument is Null.
   */
  @Test
  public void testNullCriteria() {    
    try {
      notCriteria = new NotCriteria<MenuItem>(null);
      fail("Should have thrown an ioe");  
    } catch (IllegalArgumentException ioe) {
      assertEquals("Criteria cannot be null.", ioe.getMessage());
    }    
  }
  
  /**
   * Tests both criteria arguments are not Null.
   */
  @Test
  public void testNotNullCriteria() {       
    notCriteria = new NotCriteria<MenuItem>(criteriaOfVegetaria);
    assertTrue(notCriteria instanceof Criteria);
  }
  
  /**
   * Test Not Operation accept()
   */
  @Test
  public void testAndCriteriaAccept(){
    notCriteria = new NotCriteria<MenuItem>(criteriaOfVegetaria);
    DinerMenu dinerMenu = new DinerMenu();
    Iterator<MenuItem> iterator = dinerMenu.createIterator();
    while (iterator.hasNext()) {
      MenuItem menuItem = iterator.next();
      assertEquals(notCriteria.accept(menuItem),  
         ! criteriaOfVegetaria.accept(menuItem));
    }    
  }

}