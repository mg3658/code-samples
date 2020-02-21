/**
 * Class: AddressBookEntry
 */
package addressbook;

/**
 * AddressBookEntry is the class for creating an object for all 
 * the contact properties:
 * a name, postal address, phone number, email address, 
 * and a note.
 * The first name is the required field,
 * and the rest are all optional.
 * 
 * @author mingmin
 *
 */
public class AddressBookEntry {
  
  /** The required field in the entry */
  private ContactName contactName;
  
  /** The optional fields in the entry */
  private PostalAddress postalAddress;
  
  private PhoneNumber phoneNumber;
  
  private EmailAddress emailAddress;
  
  private Note note;
  
  /**
   * Instantiates the addressBookEntry
   * through Builder parameter
   * 
   * @param builder
   */
  private AddressBookEntry(Builder builder) {
    this.contactName = builder.contactName;
    this.postalAddress = builder.postalAddress;
    this.phoneNumber = builder.phoneNumber;
    this.emailAddress = builder.emailAddress;   
    this.note = builder.note;
  }
  
  /**
   * Create a builder class to help 
   * AddressBookEntry
   */
  public static class Builder {
    
    // The required field 
    private ContactName contactName;
    
    // The optional fields
    private PostalAddress postalAddress = null;
    
    private PhoneNumber phoneNumber = null;
    
    private EmailAddress emailAddress = null;
    
    private Note note = null;
    
    /**
     * Create the required field 
     * through the first name in the contact name
     * 
     * @param contactName
     */
    public Builder(ContactName contactName) {
      // Check the null
      if (contactName == null) {
        throw new NullPointerException("Contact Name is the required field.");
      }
      this.contactName = contactName;
    }
    
    /**
     * Create the postal address
     * using equals method in the postalAddress class
     * 
     * @param postalAddress
     * @return
     */
    public Builder postalAddress(PostalAddress postalAddress) {
      this.postalAddress = postalAddress;
      return this;
    }
    
    /**
     * Create the phoneNumber
     * using equals method in the phoneNumber class
     * 
     * @param phoneNumber
     * @return
     */
    public Builder phoneNumber(PhoneNumber phoneNumber) {
      this.phoneNumber = phoneNumber;
      return this;
    }
    
    /**
     * Create the emailAddress
     * using equals method in the emailAddress class
     * 
     * @param emailAddress
     * @return
     */
    public Builder emailAddress(EmailAddress emailAddress) {
      this.emailAddress = emailAddress;
      return this;
    }
    
    /**
     * Create the note
     * using equals method in the note class
     * 
     * @param note
     * @return
     */
    public Builder note(Note note) {
      this.note = note;
      return this;
    }
    
    /**
     * Instantiates the addressBookEntry
     * through builder
     * @return
     */
    public AddressBookEntry build() {
      return new AddressBookEntry(this);
    }
    
  }

  /* (non-Javadoc)
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return contactName + "|"
        + postalAddress + "|" + phoneNumber + "|"
        + emailAddress + "|" + note;
  }

  /* (non-Javadoc)
   * @see java.lang.Object#hashCode()
   */
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result
        + ((contactName == null) ? 0 : contactName.hashCode());
    result = prime * result
        + ((emailAddress == null) ? 0 : emailAddress.hashCode());
    result = prime * result + ((note == null) ? 0 : note.hashCode());
    result = prime * result
        + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
    result = prime * result
        + ((postalAddress == null) ? 0 : postalAddress.hashCode());
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
    if (!(obj instanceof AddressBookEntry))
      return false;
    AddressBookEntry other = (AddressBookEntry) obj;
    if (contactName == null) {
      if (other.contactName != null)
        return false;
    } else if (!contactName.equals(other.contactName))
      return false;
    if (emailAddress == null) {
      if (other.emailAddress != null)
        return false;
    } else if (!emailAddress.equals(other.emailAddress))
      return false;
    if (note == null) {
      if (other.note != null)
        return false;
    } else if (!note.equals(other.note))
      return false;
    if (phoneNumber == null) {
      if (other.phoneNumber != null)
        return false;
    } else if (!phoneNumber.equals(other.phoneNumber))
      return false;
    if (postalAddress == null) {
      if (other.postalAddress != null)
        return false;
    } else if (!postalAddress.equals(other.postalAddress))
      return false;
    return true;
  }

  /**
   * Get the contactName
   * 
   * @return the contactName
   */
  public ContactName getContactName() {
    return contactName;
  }

  /**
   * Set the contactName
   * The format will be checked in the contactName class
   * 
   * @param contactName the contactName to set
   */
  public void setContactName(ContactName contactName) {
    this.contactName = contactName;
  }

  /**
   * Get the postal address
   * 
   * @return the postalAddress
   */
  public PostalAddress getPostalAddress() {
    return postalAddress;
  }

  /**
   * Set the postal address
   * The format will be checked in the postalAddress class
   * 
   * @param postalAddress the postalAddress to set
   */
  public void setPostalAddress(PostalAddress postalAddress) {
    this.postalAddress = postalAddress;
  }

  /**
   * Get the phone number
   * 
   * @return the phoneNumber
   */
  public PhoneNumber getPhoneNumber() {
    return phoneNumber;
  }

  /**
   * Set the phoneNumber
   * The format will be checked in the phoneNumber class
   * 
   * @param phoneNumber the phoneNumber to set
   */
  public void setPhoneNumber(PhoneNumber phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  /**
   * Get the email address
   * @return the emailAddress
   */
  public EmailAddress getEmailAddress() {
    return emailAddress;
  }

  /**
   * Set the email address
   * The format will be checked in the emailAddress class
   * 
   * @param emailAddress the emailAddress to set
   */
  public void setEmailAddress(EmailAddress emailAddress) {
    this.emailAddress = emailAddress;
  }

  /**
   * Get the note
   * 
   * @return the note
   */
  public Note getNote() {
    return note;
  }

  /**
   * Set the note
   * The format will be checked in the note class
   * 
   * @param note the note to set
   */
  public void setNote(Note note) {
    this.note = note;
  }
  
  

}