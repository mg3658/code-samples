package addressbook;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * This class is used to test all the functions defined in 
 * AddressBook
 * @author mingmin
 *
 */
public class AddressBookTest {

  private AddressBook addressBook;
  private ByteArrayOutputStream err = new ByteArrayOutputStream();
  
  /**
   * Get the err infomation
   */
  @Before
  public void setErr() {
    System.setErr(new PrintStream(err));
  }
  
  
  @Before
  public void setUp() {
    addressBook = AddressBook.newInstance();
  }
  
  /**
   * Test the constructor
   */
  @Test
  public void testConstructor() {
    assertTrue(AddressBook.newInstance() instanceof AddressBook);
  }
  
  /**
   * Test adding an new entry to a newly created addressbook
   * and search for that to see to check it is there
   */
  @Test
  public void testAddEntryNormal() {
    AddressEntry addressEntry = new AddressEntry.Builder("Mingmin")
      .address("NYU").email("mg3658@nyu.edu").phone("123-456-7890")
      .note("hello").build(); 
    
    addressBook.addEntry(addressEntry);
    
    List<AddressEntry> tempEntries = addressBook.search("Mingmin");
    assertEquals(1, tempEntries.size());
    assertEquals(addressEntry.toString(), tempEntries.get(0).toString());        
  }
  
  /**
   * Test add the same new entry twice 
   */
  @Test
  public void testAddSameEntryNormalAgain() {
    AddressEntry addressEntry = new AddressEntry.Builder("Mingmin")
      .address("NYU").email("mg3658@nyu.edu").phone("123-456-7890")
      .note("hello").build(); 
  
    addressBook.addEntry(addressEntry);
    addressBook.addEntry(addressEntry);
    
    List<AddressEntry> tempEntries = addressBook.search("Mingmin");
    assertEquals(2, tempEntries.size());
    assertEquals(addressEntry.toString(), tempEntries.get(0).toString());
    assertEquals(addressEntry.toString(), tempEntries.get(1).toString());
  }
  
  /**
   * Test the add method for empty entry
   */
  @Test
  public void testAddEmptyEntry() {
    AddressEntry addressEntry = new AddressEntry.Builder("").build(); 
  
    addressBook.addEntry(addressEntry);
    // contains method check empty string
    // nothing, should be back
    List<AddressEntry> tempEntries = addressBook.search("");
    assertEquals(0, tempEntries.size());
  }
  
  /**
   * Test the add method for null entry
   */
  @Test
  public void testAddNullEntry() {  
    addressBook.addEntry(null);

    List<AddressEntry> tempEntries = addressBook.search("");
    assertEquals(0, tempEntries.size());
  }
  
  /**
   * Test remove entry for removing the one
   * just added
   */
  @Test
  public void testRemoveSameNormalEntryAfterAdded() {
    AddressEntry addressEntry = new AddressEntry.Builder("Mingmin")
      .address("NYU").email("mg3658@nyu.edu").phone("123-456-7890")
      .note("hello").build(); 
    
    addressBook.addEntry(addressEntry);
    addressBook.removeEntry(addressEntry);
    List<AddressEntry> tempEntries = addressBook.search("Mingmin");
    assertEquals(0, tempEntries.size());
    
  }
  
  /**
   * Test remove entry for removing the one
   * just added twice
   */
  @Test
  public void testRemoveSameNormalEntryAfterAddedTwice() {
    AddressEntry addressEntry = new AddressEntry.Builder("Mingmin")
      .address("NYU").email("mg3658@nyu.edu").phone("123-456-7890")
      .note("hello").build();  
    
    addressBook.addEntry(addressEntry);
    addressBook.addEntry(addressEntry);
    
    addressBook.removeEntry(addressEntry);
    List<AddressEntry> tempEntries = addressBook.search("Mingmin");
    assertEquals(1, tempEntries.size());
    
  }
  
  /**
   * Test remove entry for removing the one already there
   * 
   */
  @Test
  public void testRemoveNormalOneButNotThere() {
    AddressEntry addressEntry = new AddressEntry.Builder("Mingmin")
      .address("NYU").email("mg3658@nyu.edu").phone("123-456-7890")
      .note("hello").build();   
    
    AddressEntry addressEntry2 = new AddressEntry.Builder("Mingmin")
      .address("NYU").email("mg3658@nyu.edu").phone("123-456-7890")
      .note("hello").build();  
    
    addressBook.addEntry(addressEntry);
    addressBook.removeEntry(addressEntry2);
    List<AddressEntry> tempEntries = addressBook.search("Mingmin");
    assertEquals(1, tempEntries.size());   
  }
  
  /**
   * Test remove entry for removing null
   * 
   */
  @Test
  public void testRemoveNullEntry() {
    AddressEntry addressEntry = new AddressEntry.Builder("Mingmin")
      .address("NYU").email("mg3658@nyu.edu").phone("123-456-7890")
      .note("hello").build();  
    
    AddressEntry addressEntry2 = new AddressEntry.Builder(null).build(); 
    
    addressBook.addEntry(addressEntry);
    addressBook.removeEntry(addressEntry2);
    List<AddressEntry> tempEntries = addressBook.search("Mingmin");
    assertEquals(1, tempEntries.size());   
  }
  
  
  /**
   * Test remove normal entry from an empty list
   * 
   */
  @Test
  public void testRemoveNormalEntryButListIsEmpty() {
    Anew AddressEntry.Builder("Mingmin")
      .address("NYU").email("mg3658@nyu.edu").phone("123-456-7890")
      .note("hello").build();  
      
    assertEquals(false, addressBook.removeEntry(addressEntry));   
  }
  
  /**
   * Test remove null entry from an empty list
   * 
   */
  @Test
  public void testRemoveNullEntryButListIsEmpty() {
    assertEquals(false, addressBook.removeEntry(null));   
  }
  
  /**
   * Test save method into a file
   */
  @Test
  public void testNormalToFile() {
    String fileName = "temp.txt";
    AddressEntry addressEntry = new AddressEntry.Builder("Mingmin")
      .address("NYU").email("mg3658@nyu.edu").phone("123-456-7890")
      .note("hello").build();  
    addressBook.addEntry(addressEntry);
    addressBook.save(fileName);
    assertEquals(false, err.toString().contains("CaughtIOException"));   
  }
  
  /**
   * Test save method into a file
   */
  @Test
  public void testEmptyFileNameToFile() {
    addressBook.save("");
    assertEquals(true, err.toString().contains("CaughtIOException"));   
  }
  
  /**
   * Test filename is invalid
   */
  @Test
  public void testReadInvalidFile() {
    AddressBook.read("");
    assertEquals(true, err.toString().contains("CaughtFileNotFoundException"));
  }
  
  /**
   * Test read method to read a file that
   * contains incorrect format
   */
  @Test
  public void testReadUnformatedFile() {
    String fileName = "temp.txt";     
    AddressEntry addressEntry = new AddressEntry.Builder("Mingmin")
      .address("NYU").email("mg3658@nyu.edu").phone("123-456-7890")
      .note("hello").build();  
    addressBook.addEntry(null);
    addressBook.addEntry(addressEntry);
    addressBook.save(fileName);
    AddressBook.read(fileName);
    assertEquals(true, err.toString().contains("CaughtParseException"));
  }
  
  /**
   * Test save and read method
   */
  @Test
  public void testSaveAndRead() {
    String fileName = "temp.txt";     
    AddressEntry addressEntry = new AddressEntry.Builder("Mingmin")
      .address("NYU").email("mg3658@nyu.edu").phone("123-456-7890")
      .note("hello").build();  
    addressBook.addEntry(addressEntry);
    addressBook.save(fileName);
    AddressBook tempAddressBook = AddressBook.read(fileName);
    List<AddressEntry> tempEntries = addressBook.search("Mingmin");
    List<AddressEntry> tempEntries2 = tempAddressBook.search("Mingmin");
    assertEquals(tempEntries.size(), tempEntries2.size());
   
  }
  

  
  

}
