/**
 * Class: PhoneNumber
 */
package addressbook;

/**
 * PhoneNumber is the class for creating an object for 
 * phone number.
 * There are three fields for it:
 * area code, exchange, extension.
 * 
 * Each field needs to check it's format.
 * 
 * @author mingmin
 *
 */
public class PhoneNumber {
  
  /** Phone Number: (areaCode) exchange-extension */
  private  String areaCode;
  private  String exchange;
  private  String extension;
  
  /**
   * Instantiates a new phone number
   * 
   * It will be checked first to meet the format
   * requirement and then pass it to the phone number 
   * class member.
   * 
   * @param areaCode the first 3 digits
   * @param exchange the next 3 digits
   * @param extension the last 4 digits
   */
  public PhoneNumber(String areaCode, String exchange, 
      String extension) {   
    
    // Check the 3 fields 
    // throw exception if the format is not right
    rangecheck(areaCode, "area code");
    rangecheck(exchange, "exchange");
    rangecheck(extension, "extension");
    
    this.areaCode = areaCode;
    this.exchange = exchange;
    this.extension = extension;
  }
  
  /**
   * Check phone number three fields format
   * areaCode field should be 3 digits
   * exchange field should be 3 digits
   * extension field should be 4 digits
   * 
   * @param arg three fields for the phone number
   * @param name three fields' name
   */
  private static void rangecheck(String arg, String name) {
    
    // Check if phone number is null
    if (arg == null) {
      throw new NullPointerException("Phone number " + name +
          " cannot be null.");      
    }
    
    // Check if phone number field has its correct digits
    if (name != "extension") {
      if (arg.length() != 3) {
        throw new IllegalArgumentException("Phone number " + name + 
            " shoule be three digits.");
      }
    }
    else {
      if (arg.length() != 4) {
        throw new IllegalArgumentException("Phone number " + name + 
            " shoule be four digits.");
      }
    }
    // Check if all phone number strings are digits
    for (int i = 0; i < arg.length(); i++) {
      if (! Character.isDigit(arg.charAt(i))) {
        throw new IllegalArgumentException("Phone number " + name + 
            " cannot include digits.");
      }
    }
       
  }
  
  /**
   * to String method
   * Transform phone number to the string
   * using the popular way people use today.
   * Like 718-249-6215
   * 
   */
  @Override
  public String toString() {

    return areaCode + "-" +  exchange
        + "-" + extension;    
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + areaCode.hashCode();
    result = prime * result + exchange.hashCode();
    result = prime * result + extension.hashCode();
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
    if (!(obj instanceof PhoneNumber))
      return false;
    PhoneNumber other = (PhoneNumber) obj;
    if (areaCode == null) {
      if (other.areaCode != null)
        return false;
    } else if (!areaCode.equals(other.areaCode))
      return false;
    if (exchange == null) {
      if (other.exchange != null)
        return false;
    } else if (!exchange.equals(other.exchange))
      return false;
    if (extension == null) {
      if (other.extension != null)
        return false;
    } else if (!extension.equals(other.extension))
      return false;
    return true;
  }

  /**
   * Get the area code
   * 
   * @return the areaCode
   */
  public String getAreaCode() {
    return areaCode;
  }

  /**
   * Get the exchange
   * 
   * @return the exchange
   */
  public String getExchange() {
    return exchange;
  }

  /**
   * Get the extension
   * 
   * @return the extension
   */
  public String getExtension() {
    return extension;
  }

  /**
   * Set the area code after checking 
   * its format
   * 
   * @param areaCode the areaCode to set
   */
  public void setAreaCode(String areaCode) {
    rangecheck(areaCode, "area code");
    this.areaCode = areaCode;
  }

  /**
   * Set the exchange after checking 
   * its format
   * 
   * @param exchange the exchange to set
   */
  public void setExchange(String exchange) {
    rangecheck(exchange, "exchange");
    this.exchange = exchange;
  }

  /**
   * Set the extension after checking 
   * its format
   * 
   * @param extension the extension to set
   */
  public void setExtension(String extension) {
    rangecheck(extension, "extension");
    this.extension = extension;
  }
  
  
  
}