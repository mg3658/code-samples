/**
 * Class: ContactName
 */
package addressbook;

/**
 * ContactName is class for creating name object
 * which has three part: first name (required), middle name,
 * and last name.
 * The contactName class can accept all the characters,
 * not only for a-z, A-Z. Because in real life, people like using what they want
 * to create a contact name.
 * Here, we have a maxSize for each three field. 
 * Everything exceeds the max size will be omitted.
 * 
 * 
 * @author mingmin
 *
 */
public class ContactName {
  
  /** Contact name: first name */
  private String firstName;
  
  /** Contact name: middle name */
  private String middleName;
  
  /** Contact name: last name */
  private String lastName;
  
  /** Max length for each part of name */
  private final static int maxSizeForName = 50;
  
  /**
   * Instantiates a new contact name
   * 
   * @param builder 
   */
  private ContactName(Builder builder){
    this.firstName = builder.firstName;
    this.middleName = builder.middleName;
    this.lastName = builder.lastName;   
  }

  /**
   * Builder class is used for ContactName class
   * 
   * @author mingmin
   *
   */
  public static class Builder {
    
    // Required filed 
    private String firstName;
    
    // Optional filed 
    private String middleName = "";
    private String lastName = "";
    
    /**
     * Using builder patter to define the required filed 
     * in the contact name.
     * 
     * How to use: 
     * ContactName name = new ContactName.Builder("firstname").
     *     middleName("middlename").lastName("lastname").build().
     * 
     * @param firstName is the required filed for contact name
     */
    public Builder(String firstName)  {
      if (firstName == null || firstName.length() == 0) {
        throw new NullPointerException("Contact first name cannot to be null");
      }      
      this.firstName = resetNameLength(firstName);
    }
    
    /**
     * Using builder patter to define the middle name 
     * in the contact name.
     * 
     * @param middleName
     * @return
     */
    public Builder middleName(String middleName) {
      this.middleName = resetNameLength(middleName);
      return this;
    }
    
    /**
     * Using builder patter to define the last name 
     * in the contact name.
     * 
     * @param lastName
     * @return
     */
    public Builder lastName(String lastName) {
      this.lastName = resetNameLength(lastName);
      return this;
    }
    
    /**
     * Instantiates a new contactName after 
     * each part checked.
     * 
     * @return
     */
    public ContactName build() {
      return new ContactName(this);
    }
    
    /**
     * Checked each part of name if
     * having the right length format 
     * 
     * @param name
     * @return
     */
    public static String resetNameLength (String name) {
      if (name == null || name.length() == 0) {
        name = "";
      }     
      else if (name.length() > maxSizeForName) {
        name = name.substring(0, maxSizeForName - 1);
      }
      
      return name;      
    }    
    
  } 

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return firstName + "," + middleName + "*," + lastName + "*";
  }
    
  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
    result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
    result = prime * result
        + ((middleName == null) ? 0 : middleName.hashCode());
    return result;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#equals(java.lang.Object)
   */
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (!(obj instanceof ContactName))
      return false;
    ContactName other = (ContactName) obj;
    if (firstName == null) {
      if (other.firstName != null)
        return false;
    } else if (!firstName.equals(other.firstName))
      return false;
    if (lastName == null) {
      if (other.lastName != null)
        return false;
    } else if (!lastName.equals(other.lastName))
      return false;
    if (middleName == null) {
      if (other.middleName != null)
        return false;
    } else if (!middleName.equals(other.middleName))
      return false;
    return true;
  }


  /**
   * Get the first name
   * 
   * @return the firstName
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Set first name under the max size format
   * 
   * @param firstName the firstName to set
   */
  public void setFirstName(String firstName) {
    this.firstName = Builder.resetNameLength(firstName);
  }

  /**
   * Get the middle name
   * 
   * @return the middleName
   */
  public String getMiddleName() {
    return middleName;
  }

  /**
   * Set middle name under the max size format
   * 
   * @param middleName the middleName to set
   */
  public void setMiddleName(String middleName) {
    this.middleName = Builder.resetNameLength(middleName);
  }

  /**
   * Get the last name
   * 
   * @return the lastName
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Set last name under the max size format
   * 
   * @param lastName the lastName to set
   */
  public void setLastName(String lastName) {
    this.lastName = Builder.resetNameLength(lastName);
  }
  
}