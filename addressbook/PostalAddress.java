/**
 * Class: PostalAddress
 */
package addressbook;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * PostalAddress is the class for creating an object for
 * postal address.
 * It has five fields,
 * street name, city, state, zipCode, and country.
 * They have their own format and will be set after checking format.
 * 
 * @author mingmin
 *
 */
public class PostalAddress {
  
  /** The street name */
  private String streetName;
  
  /** The city name */
  private String city;
  
  /** The state name using abbreviations */
  private String state;
  
  /** The zip code */
  private String zipCode;
  
  /** The country name */
  private String country;
  
  /** max limit for city, state, and country */  
  private final static int maxLengthOfCityStateCounty = 50;
  
  /** max limit for street */
  private final static int maxlengthOfStreet = 80;
  
  /** max limit for zipCode */
  private final static int maxLengthOfZipCode = 30;
  
  /**
   * Instantiates a new Postal Address 
   * Using builder pattern.
   * 
   * @param builder
   */
  private PostalAddress(Builder builder) {
    this.streetName = builder.streetName;
    this.city = builder.city;
    this.state = builder.state;
    this.zipCode = builder.zipCode;
    this.country = builder.country;
  }
  
  /**
   * Builder class to help PostalAddress class
   * to create optional fields
   *
   */
  public static class Builder {
    
    /** The street name */
    private String streetName = "";
    
    /** The city name */
    private String city = "";
    
    /** The state name using abbreviations */
    private String state = "";
    
    /** The zip code */
    private String zipCode = "";
    
    /** The country name */
    private String country = ""; 
    
    /** For city, state, country, all the character are letters */
    private final static Pattern countryCityStatePattern = Pattern.compile(
        "^([A-Z]+)$", Pattern.CASE_INSENSITIVE);
    
    /**
     * Set street name after checking its format
     * 
     * @param streetName
     * @return
     */
    public Builder streetName(String streetName) {
      this.streetName = rangeCheckForStreet(streetName);
      return this;
    }
    
    /**
     * Set city name after checking its format
     * @param city
     * @return
     */
    public Builder city(String city) {
      this.city = rangeCheckForCityStateCountry(city, "City");
      return this;
    }
    
    /**
     * Set state name after checking its format
     * @param state
     * @return
     */
    public Builder state(String state) {
      this.state = rangeCheckForCityStateCountry(state, "State");
      return this;
    }
    
    /**
     * Set zipCode name after checking its format
     * @param zipCode
     * @return
     */
    public Builder zipCode(String zipCode) {
      this.zipCode = rangeCheckForZipCode(zipCode);
      return this;
    }
    
    /**
     * Set country name after checking its format
     * @param country
     * @return
     */
    public Builder country(String country) {
      this.country = rangeCheckForCityStateCountry(country, "country");
      return this;
    }
    
    /**
     * Instantiates the PostalAddress
     * through builder
     * @return
     */
    public PostalAddress build() {
      return new PostalAddress(this);
    }
    
    /**
     * Check if valid city, state, country name.
     * Check its length and pattern format.
     * And return the valid name.
     * 
     * @param arg city/state/country value
     * @param name the name for the arg to tell which one is.
     * @return the valid arg
     */
    private static String rangeCheckForCityStateCountry(String arg, String name) {
      
      // Check for null and no length 
      if (arg == null || arg.length() == 0) {
        return "";
      }
      
      // Check for max length
      if (arg.length() > maxLengthOfCityStateCounty) {
        throw new IllegalArgumentException(name + " exceeds the length limit.");
      }
      
      // Check for pattern format
      Matcher match = countryCityStatePattern.matcher(arg);
      
      if (! match.find()) {
        throw new IllegalArgumentException(name + " is invalid.");
      }
      else {
        return arg;
      }
      
    }
    
    /**
     * Check if valid for zip code
     * It should be all digits 
     * and no more than the max limit.
     *  
     * @param zipCode
     * @return the valid zip code back
     */
    private static String rangeCheckForZipCode(String zipCode) {
      
      // Check for null and no length 
      if (zipCode == null || zipCode.length() == 0) {
        return "";
      }
      // Check for max length
      if (zipCode.length() > maxLengthOfZipCode) {
        throw new IllegalArgumentException("zip code exceeds the max limit.");
      }
      else {
        // Check for digits
        for (int i = 0; i < zipCode.length(); i++) {
          if (! Character.isDigit(zipCode.charAt(i))) {
            throw new IllegalArgumentException("zip code should be all digits.");
          }
        }
        
        return zipCode;
      }            
    }
    
    /**
     * Check if valid for street.
     * 
     * @param street 
     * @return the valid street back
     */
    private static String rangeCheckForStreet(String street) {
      
      // Check for null and no length 
      if (street == null || street.length() == 0) {
        return "";
      }
      // Check for max limit
      if (street.length() > maxlengthOfStreet) {
        throw new IllegalArgumentException("Street exceeds the max limit.");
      }
     
      return street;         
    }
    
    
  }//builder


  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return streetName + "*," + city
        + "*," + state + "*," + zipCode + "*," + country + "*";
  }


  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((city == null) ? 0 : city.hashCode());
    result = prime * result + ((country == null) ? 0 : country.hashCode());
    result = prime * result + ((state == null) ? 0 : state.hashCode());
    result = prime * result
        + ((streetName == null) ? 0 : streetName.hashCode());
    result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
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
    if (!(obj instanceof PostalAddress))
      return false;
    PostalAddress other = (PostalAddress) obj;
    if (city == null) {
      if (other.city != null)
        return false;
    } else if (!city.equals(other.city))
      return false;
    if (country == null) {
      if (other.country != null)
        return false;
    } else if (!country.equals(other.country))
      return false;
    if (state == null) {
      if (other.state != null)
        return false;
    } else if (!state.equals(other.state))
      return false;
    if (streetName == null) {
      if (other.streetName != null)
        return false;
    } else if (!streetName.equals(other.streetName))
      return false;
    if (zipCode == null) {
      if (other.zipCode != null)
        return false;
    } else if (!zipCode.equals(other.zipCode))
      return false;
    return true;
  }


  /**
   * Get the streetName
   * 
   * @return the streetName
   */
  public String getStreetName() {
    return streetName;
  }


  /**
   * Set the streetName after checking its format
   * 
   * @param streetName the streetName to set
   */
  public void setStreetName(String streetName) {
    this.streetName = Builder.rangeCheckForStreet(streetName);
  }


  /**
   * Get the city
   * 
   * @return the city
   */
  public String getCity() {
    return city;
  }


  /**
   * Set the city after checking its format
   * 
   * @param city the city to set
   */
  public void setCity(String city) {
    this.city = Builder.rangeCheckForCityStateCountry(city, "City");
  }


  /**
   * Get the state
   * 
   * @return the state
   */
  public String getState() {
    return state;
  }


  /**
   * Set the state after checking its format
   * 
   * @param state the state to set
   */
  public void setState(String state) {
    this.state = Builder.rangeCheckForCityStateCountry(state, "State");
  }


  /**
   * Get the zipCode
   * 
   * @return the zipCode
   */
  public String getZipCode() {
    return zipCode;
  }


  /**
   * Set the zipCode after checking its format
   * 
   * @param zipCode the zipCode to set
   */
  public void setZipCode(String zipCode) {
    this.zipCode = Builder.rangeCheckForZipCode(zipCode);
  }


  /**
   * Get the country
   * 
   * @return the country
   */
  public String getCountry() {
    return country;
  }


  /**
   * Set the country after checking its format
   * 
   * @param country the country to set
   */
  public void setCountry(String country) {
    this.country = Builder.rangeCheckForCityStateCountry(country, "Country");
  }
  
  
  
  
  

}