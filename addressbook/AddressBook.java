/**
 * Class: AddressBook
 */
package addressbook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * AddressBook is the address book library.
 * All the functions are designed here.
 * 1. create an empty address book.
 * 2. add an entry.
 * 3. remove an entry.
 * 4. search for an entry by any of the
 *     contact properties.
 * 5. save the address book to a file.
 * 6. read the address book from a file.
 * 
 * 
 * @author mingmin
 *
 */
public class AddressBook {
  
  /** The address book is combined with array list for each entries */
  public ArrayList<AddressBookEntry> addressBookEntryList;
  
  /**
   * Instantiates the AddressBook
   */
  public AddressBook() {
    this.addressBookEntryList = new ArrayList<AddressBookEntry>();
  }
  
  /**
   * Create an empty address book.
   * 
   * @return an empty address book
   */
  public static AddressBook createAddressBook() {
    return new AddressBook();
  }
  
  /**
   * Add an entry.
   * An entry consists of a name, postal address,
   * phone number, email address and a note.
   * 
   * @param entry is the entry want to be added
   *     into address book.
   */
  public void addEntry(AddressBookEntry entry) {
    addressBookEntryList.add(entry);
  }
  
  /**
   * Remove an entry.
   * 
   * @param entry is the entry want to be removed
   *     from address book.
   * @return if true, means remove successfully.
   */
  public boolean removeEntry(AddressBookEntry entry) {
    return addressBookEntryList.remove(entry);
  }
  
  /**
   * Search an entry by it's all properties
   * 
   * @param entry is the entry user search from 
   *     the address book
   * @return all the entries in the address book that
   *     equal to the entry searched
   */
  public ArrayList<AddressBookEntry> searchEntryByAll(AddressBookEntry entry) {
    
    // Create a new result arraylist to store all the entries
    // equal to the entry searched
    ArrayList<AddressBookEntry> searchResultAsEntryList 
        = new ArrayList<AddressBookEntry>();
    // Iterate the address book 
    for (AddressBookEntry e : addressBookEntryList) {
      // Find the matched entry, then put it into result
      if (e.equals(entry)) {
        searchResultAsEntryList.add(e);
      }
    }
    
    return searchResultAsEntryList;
  }
  
  
  /**
   * Search an entry by it's contact name
   * 
   * @param entry is the entry user search from 
   *     the address book
   * @return all the entries in the address book that
   *     equal to the entry searched
   */
  public ArrayList<AddressBookEntry> searchEntryByContactName(
      ContactName contactname) {
    
    // Create a new result arraylist to store all the entries
    // equal to the entry searched
    ArrayList<AddressBookEntry> searchResultAsEntryList 
        = new ArrayList<AddressBookEntry>();
    // Iterate the address book 
    for (AddressBookEntry e : addressBookEntryList) {
      // Find the matched entry, then put it into result
      if (e.getContactName().equals(contactname)) {
        searchResultAsEntryList.add(e);
      }
    }
    
    return searchResultAsEntryList;
  }
  
  /**
   * Search an entry by it's postal address
   * 
   * @param entry is the entry user search from 
   *     the address book
   * @return all the entries in the address book that
   *     equal to the entry searched
   */
  public ArrayList<AddressBookEntry> searchEntryByPostalAddress(
      PostalAddress postalAddress) {
    
    // Create a new result arraylist to store all the entries
    // equal to the entry searched
    ArrayList<AddressBookEntry> searchResultAsEntryList 
        = new ArrayList<AddressBookEntry>();
    // Iterate the address book 
    for (AddressBookEntry e : addressBookEntryList) {
      // Find the matched entry, then put it into result
      if (e.getPostalAddress().equals(postalAddress)) {
        searchResultAsEntryList.add(e);
      }
    }
    
    return searchResultAsEntryList;
  }
  
  /**
   * Search an entry by it's phone number
   * 
   * @param entry is the entry user search from 
   *     the address book
   * @return all the entries in the address book that
   *     equal to the entry searched
   */
  public ArrayList<AddressBookEntry> searchEntryByPhoneNumber(
      PhoneNumber phoneNumber) {
    
    // Create a new result arraylist to store all the entries
    // equal to the entry searched
    ArrayList<AddressBookEntry> searchResultAsEntryList 
        = new ArrayList<AddressBookEntry>();
    // Iterate the address book 
    for (AddressBookEntry e : addressBookEntryList) {
      // Find the matched entry, then put it into result
      if (e.getPhoneNumber().equals(phoneNumber)) {
        searchResultAsEntryList.add(e);
      }
    }
    
    return searchResultAsEntryList;
  }
  
  /**
   * Search an entry by it's email address
   * 
   * @param entry is the entry user search from 
   *     the address book
   * @return all the entries in the address book that
   *     equal to the entry searched
   */
  public ArrayList<AddressBookEntry> searchEntryByEmailAddress(EmailAddress emailAddress) {
    
    // Create a new result arraylist to store all the entries
    // equal to the entry searched
    ArrayList<AddressBookEntry> searchResultAsEntryList 
        = new ArrayList<AddressBookEntry>();
    // Iterate the address book 
    for (AddressBookEntry e : addressBookEntryList) {
      // Find the matched entry, then put it into result
      if (e.getEmailAddress().equals(emailAddress)) {
        searchResultAsEntryList.add(e);
      }
    }
    
    return searchResultAsEntryList;
  }
  
  /**
   * Search an entry by it's note
   * 
   * @param entry is the entry user search from 
   *     the address book
   * @return all the entries in the address book that
   *     equal to the entry searched
   */
  public ArrayList<AddressBookEntry> searchEntryByNote(Note note) {
    
    // Create a new result arraylist to store all the entries
    // equal to the entry searched
    ArrayList<AddressBookEntry> searchResultAsEntryList 
        = new ArrayList<AddressBookEntry>();
    // Iterate the address book 
    for (AddressBookEntry e : addressBookEntryList) {
      // Find the matched entry, then put it into result
      if (e.getNote().equals(note)) {
        searchResultAsEntryList.add(e);
      }
    }
    
    return searchResultAsEntryList;
  }
  
  /**
   * Save the address book into one file
   * through the file path
   * 
   * @param filePath is the position that file located
   * @throws IOException
   */
  public void saveAddressBookToFile(String filePath) throws IOException{
    
    // Write into file through file path
    BufferedWriter bw = new BufferedWriter((new FileWriter(filePath, false)));
    // Write each entry line by line
    for (AddressBookEntry entry: addressBookEntryList) {      
      bw.write(entry.toString());
      bw.newLine();     
    }    
    bw.close();
  }
  
  /**
   * Read the address book from a file
   * Open a file through its path
   * and read line by line.
   * For each line, check the information.
   * If the information meets the format for each class,
   * then add this into a temp entry.
   * In the end, add this entry into entry list.
   * User can get the results back through an array list.
   * 
   * @param filePath
   * @throws IOException
   */
  public void readAddressBookFromFile(String filePath)
      throws IOException {
    
    BufferedReader br = new BufferedReader(new InputStreamReader(
        new FileInputStream(filePath)));
    
    String line = br.readLine();
    
    while (line != null) {
      
      // Each entry has five parts separated by "|"
      String[] slot = line.replace("|", "!").split("!");
      
      // Check five parts for each line.
      if (slot.length != 5) {
        throw new IllegalArgumentException("The input file is illegal.");
      }
      // Check contactName
      String[] contactNameSlot = slot[0].split(",");
      
      if (contactNameSlot[0] == null) {
        throw new NullPointerException("Firstname for Contact name " +
        		"is a required field and cannot be null.");
      }
      
      // Create a new contact name with this first name
      ContactName contactName = new ContactName.Builder(
          contactNameSlot[0]).build();
      // set middlename and lastname
      
      if (contactNameSlot[1].replace("*", "").length() != 0){
        contactName.setMiddleName(contactNameSlot[1]);
      }
      if (contactNameSlot[2].replace("*", "").length() != 0){
        contactName.setLastName(contactNameSlot[2]);
      }      
      
      // Create a new address book entry with contactName
      AddressBookEntry newEntry = new AddressBookEntry.Builder(
          contactName).build();
      
      // Set phone number if slot[2] has the three fields
      if (! slot[2].equals("null")) {
        String[] phoneNumberSlot = slot[2].split("-");
        if (phoneNumberSlot.length != 3) {
          throw new IllegalArgumentException("Phone number should have three fields:" +
                  "area code, exchange, and extension.");
        }
        PhoneNumber phoneNumber = new PhoneNumber(phoneNumberSlot[0], 
            phoneNumberSlot[1], phoneNumberSlot[2]);
        newEntry.setPhoneNumber(phoneNumber);  
      }
      
      // Set Email address
      if (! slot[3].equals("null")) {
        String emailAddressSlot = slot[3];
        EmailAddress emailAddress = new EmailAddress(emailAddressSlot);
        newEntry.setEmailAddress(emailAddress);
      }
            
      // Set Note
      if (! slot[4].equals("null")) {
        String noteSlot = slot[4];
        Note note = new Note(noteSlot);
        newEntry.setNote(note);
      }
      
      // Set postal address
      if (! slot[1].equals("null")) {
        String[] postalAddressSlot = slot[1].split(",");
        // Check for five fields for postal address
        if (postalAddressSlot.length != 5) {
          throw new IllegalArgumentException("Postal Address should " +
                  "have five fields: street, city, state, zipCode, Country.");
        }
        
        // Create a new postal address with the value of five fields
        PostalAddress postalAddress = new PostalAddress.Builder().streetName(
            postalAddressSlot[0].replace("*", "")).city(
                postalAddressSlot[1].replace("*", "")).state(
                postalAddressSlot[2].replace("*", "")).zipCode(
                    postalAddressSlot[3].replace("*", "")).country(
                        postalAddressSlot[4].replace("*", "")).build();
        
        newEntry.setPostalAddress(postalAddress);
      }
     
      this.addEntry(newEntry);
      
      // Next line
      line = br.readLine();
    }    
  }

}