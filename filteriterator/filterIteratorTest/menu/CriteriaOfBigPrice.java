package menu;

import filteriterator.Criteria;

/**
 * @author mingmin
 *
 */
public class CriteriaOfBigPrice implements Criteria<MenuItem>{
  public boolean accept(MenuItem menuItem) {
    return menuItem.getPrice() > 50.00;
  }
}
