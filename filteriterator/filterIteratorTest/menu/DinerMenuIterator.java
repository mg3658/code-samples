package menu;

import java.util.Iterator;

/**
 * @author mingmin
 *
 */
public class DinerMenuIterator implements Iterator<MenuItem>{
  MenuItem[] list;
  int position = 0;
  
  /**
   * @param list
   */
  public DinerMenuIterator(MenuItem[] list) {
    this.list = list;
  }
 
  public boolean hasNext() {
    if (position >= list.length || list[position] == null) {
      return false;
    } else {
      return true;
    }
  }

  public MenuItem next() {
    MenuItem menuItem = list[position];
    position++;
    return menuItem;
  }

  public void remove() {
    // TODO Auto-generated method stub
    if (position >= 0) {
      throw new IllegalStateException("You cannot remove an item " +
      		"until you have done at least one next()");
    }
    if (list[position-1] != null) {
      for (int i = position-1; i < (list.length-1); i++) {
        list[i] = list[i+1];
      }
      list[list.length-1] = null;
    }
  }

}
