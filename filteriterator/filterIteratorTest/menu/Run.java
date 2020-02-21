package menu;

import filteriterator.AndCriteria;
import filteriterator.Criteria;
import filteriterator.FilterIterator;
import filteriterator.NotCriteria;
import filteriterator.OrCriteria;

import java.util.Iterator;

/**
 * @author mingmin
 *
 */
public class Run {
  public static void main(String[] args) {
    DinerMenu dinerMenu = new DinerMenu();
    Iterator<MenuItem> dinerIterator = dinerMenu.createIterator();
    Criteria<MenuItem> criteriaPrice = new CriteriaOfPrice();
    Criteria<MenuItem> criteriaVege = new CriteriaOfVegetaria();
    Criteria<MenuItem> andPriceVegeCriteria = new AndCriteria<MenuItem>(criteriaPrice, criteriaVege);
    Criteria<MenuItem> orPriceVegeCriteria = new OrCriteria<MenuItem>(criteriaPrice, criteriaVege);
    Criteria<MenuItem> notPriceVegeCriteria = new NotCriteria<MenuItem>(criteriaPrice);
    
    //Iterator<MenuItem> filterIterator = new FilterIterator<MenuItem>(dinerIterator, null);
    //Iterator<MenuItem> filterIterator = new FilterIterator<MenuItem>(dinerIterator, criteriaPrice);
    //Iterator<MenuItem> filterIterator = new FilterIterator<MenuItem>(dinerIterator, orPriceVegeCriteria);
    Iterator<MenuItem> filterIterator = new FilterIterator<MenuItem>(dinerIterator, notPriceVegeCriteria);

    System.out.println("Menu:\n--- \nLUNCH");
    while (filterIterator.hasNext()) {
      MenuItem menuItem = (MenuItem) filterIterator.next();
      System.out.print(menuItem.getName() + ", ");
      System.out.print(menuItem.isVegetarian() + " -- ");
      System.out.print(menuItem.getPrice() + " -- \n");
    }
  }

}