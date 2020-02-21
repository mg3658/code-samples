package menu;

import java.util.Iterator;

/**
 * @author mingmin
 *
 */
public class DinerMenu {
  static final int MAX_ITEMS = 6;
  int numberOfItems = 0;
  MenuItem[] menuItems;
  
  public DinerMenu() {
    menuItems = new MenuItem[MAX_ITEMS];
    addItem("Vegetarian BLT", false, 2.99);
    addItem("BLT", true, 2.99);
    addItem("Soup of the last day", false, 2.99);
    addItem("Soup of the day", true, 3.29);
  }
    
  public void addItem(String name, boolean vegetarian, double price) {
    MenuItem menuItem = new MenuItem(name, vegetarian, price);
    if (numberOfItems >= MAX_ITEMS) {
      System.err.println("Sorry!");
    } else {
      menuItems[numberOfItems] = menuItem;
      numberOfItems++;
    }
  }
  
  public Iterator<MenuItem> createIterator() {
    return new DinerMenuIterator(menuItems);
  }
}