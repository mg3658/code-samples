package menu;

import filteriterator.Criteria;

/**
 * @author mingmin
 *
 */
public class CriteriaOfPrice implements Criteria<MenuItem>{
  public boolean accept(MenuItem menuItem) {    
    return menuItem.getPrice() == 2.99;
  }
}