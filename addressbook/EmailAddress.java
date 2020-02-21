/**
 * Class: EmailAddress
 */
package addressbook;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * EmailAddress is the class for creating an object for email address.
 * It can accept some character that designed in the emailAddressPattern.
 * 
 * @author mingmin
 *
 */
public class EmailAddress {
  
  /** The value for the email address */
  private String emailAdress;
  
  /** Maximum length limit of an email address */
  private final static int maxLength = 254;
  
  /**
   * The reg expression for the email address.
   * The accept characters are as follows:
   * a-z,A-Z,0-9,',','-','_' for the name part;
   * a-z,A-Z,0-9,',','-','_','.',' for the server part.
   * and using @ to separate them.
   */
  private final static Pattern emailAddressPattern = Pattern.compile(
      "^([a-z0-9]+[_a-z0-9-\\.]+)@([-_a-z0-9]+[\\.a-z]+)$", Pattern.CASE_INSENSITIVE);
  
  /**
   * Instantiates a new email address.
   * 
   * @param emailAddress the argument pass into 
   *     check length and pattern format;
   *     and get the valid value to set emailAddress.
   *     
   */
  public EmailAddress(String emailAddress) {
    this.emailAdress = rangeCheck(emailAddress);
  }
  
  /**
   * Check if valid for email address
   * 
   * Check pattern format and max length limit
   * 
   * @param emailAddress the argument passing to be checked
   * @return the valid email address
   */
  private String rangeCheck(String emailAddress) {
    
    // Check the null for email address
    if (emailAddress == null) {
      throw new NullPointerException("Email address should be name@serverName.");
    }
    // Check max length limit 
    if (emailAddress.length() > maxLength) {
      throw new IllegalArgumentException("Email address exceeds the max length limit.");
    }
    // Check the valid email address pattern
    Matcher patternMatch = emailAddressPattern.matcher(emailAddress);
    
    // If not match, means invalid; else valid
    if (!patternMatch.find()) {
      throw new IllegalArgumentException("Email address is invalid.");
    }
    else{
      return emailAddress;
    }
    
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return emailAdress;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + emailAdress.hashCode();
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
    if (!(obj instanceof EmailAddress))
      return false;
    EmailAddress other = (EmailAddress) obj;
    if (emailAdress == null) {
      if (other.emailAdress != null)
        return false;
    } else if (!emailAdress.equals(other.emailAdress))
      return false;
    return true;
  }

  /**
   * Get the email address
   * 
   * @return the emailAdress
   */
  public String getEmailAdress() {
    return emailAdress;
  }

  /**
   * Set email address after checking it is valid
   * 
   * @param emailAdress the emailAdress to set
   */
  public void setEmailAdress(String emailAdress) {
    this.emailAdress = rangeCheck(emailAdress);
  }
  
  
  

}