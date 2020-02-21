package menu;
/**
 * @author mingmin
 *
 */
public class MenuItem {
  String name;
  boolean vegetarian;
  double price;
  /**
   * @param name
   * @param vegeterian
   * @param price
   */
  public MenuItem(String name, boolean vegetarian, double price) {
   
    this.name = name;
    this.vegetarian = vegetarian;
    this.price = price;
  }
  /**
   * @return the name
   */
  public String getName() {
    return name;
  }
  /**
   * @param name the name to set
   */
  public void setName(String name) {
    this.name = name;
  }
  /**
   * @return the vegetarian
   */
  public boolean isVegetarian() {
    return vegetarian;
  }
  /**
   * @param vegetarian the vegetarian to set
   */
  public void setVegetarian(boolean vegetarian) {
    this.vegetarian = vegetarian;
  }
  /**
   * @return the price
   */
  public double getPrice() {
    return price;
  }
  /**
   * @param price the price to set
   */
  public void setPrice(double price) {
    this.price = price;
  }
  

}