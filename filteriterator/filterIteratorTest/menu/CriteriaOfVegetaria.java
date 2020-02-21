package menu;

import filteriterator.Criteria;

/**
 * @author mingmin
 *
 */
public class CriteriaOfVegetaria implements Criteria<MenuItem>{
  public boolean accept(MenuItem menuItem) {
    return menuItem.isVegetarian() == true;
  }
}