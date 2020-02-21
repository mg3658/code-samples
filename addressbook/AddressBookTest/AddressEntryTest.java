package pqs.ps1.addressbook;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;

import pqs.ps1.addressbook.AddressEntry.Builder;

/**
 * This class is used to test all the functions defined in 
 * AddressEntryTest 
 * @author mingmin
 *
 */
public class AddressEntryTest {
  
  private AddressEntry addressEntry;
  private ByteArrayOutputStream err = new ByteArrayOutputStream();
  
  /**
   * Get the err infomation
   */
  @Before
  public void setErr() {
    System.setErr(new PrintStream(err));
  }
  
  /**
   * Set the initialization to addressEntry
   */
  @Before
  public void setup() {
    addressEntry = new AddressEntry.Builder("PeiHong").build();    
  }
  
  /**
   * Test the required field for AddressEntry Name 
   * when it is null.
   */
  @Test
  public void testNullName() {
    addressEntry = new AddressEntry.Builder(null).build();    
  }
  
  /**
   * Test the required field for AddressEntry Name 
   * when it is a blank.
   */
  @Test
  public void testBlankName() {
    addressEntry = new AddressEntry.Builder(" ").build();    
  }
  
  /**
   * Test the required field for AddressEntry Name 
   * when it is a empty string.
   */
  @Test
  public void testEmptyName() {
    addressEntry = new AddressEntry.Builder("").build();    
  }
  
  /**
   * Test all field builded by builder
   */
  @Test
  public void testAllFieldNormal() {
    addressEntry = new AddressEntry.Builder("Peihong")
        .address("NYU").email("pc1336@nyu.edu").phone("917-688-9725")
        .note("Peihong's taking PQS").build();    
  }
  
  /**
   * Test the normal name
   */
  @Test
  public void testNameContain() {
    addressEntry = new AddressEntry.Builder("Peihong")
      .address("NYU").email("pc1336@nyu.edu").phone("917-688-9725")
      .note("Peihong's taking PQS").build(); 
    assertEquals(true, addressEntry.contains("Peihong"));      
  }
  
  /**
   * Test the normal address 
   */
  @Test
  public void testAddressContain() {
    addressEntry = new AddressEntry.Builder("Peihong")
      .address("NYU").build();   
    assertEquals(true, addressEntry.contains("NYU"));       
  }

  /**
   * Test the normal phone 
   */
  @Test
  public void testPhoneContain() {
    addressEntry = new AddressEntry.Builder("Peihong")
      .phone("917-688-9725").build();   
    assertEquals(true, addressEntry.contains("917-688-9725"));       
  }
  
  /**
   * Test the normal note 
   */
  @Test
  public void testNoteContain() {
    addressEntry = new AddressEntry.Builder("Peihong")
    .note("Peihong's taking PQS").build();   
    assertEquals(true, addressEntry.contains("Peihong's taking PQS"));       
  }

    
  /**
   * Test the null name.
   */
  @Test
  public void testNullNameContain() {
    addressEntry = new AddressEntry.Builder(null).build(); 
    assertEquals(false, addressEntry.contains(null));       
  }
  
  /**
   * Test the null address 
   */  
  @Test
  public void testNullAddressContain() {
    addressEntry = new AddressEntry.Builder(null).build(); 
    assertEquals(false, addressEntry.contains(""));    
  }
  
  /**
   * Test the null email 
   */  
  @Test
  public void testNullEmailContain() {
    addressEntry = new AddressEntry.Builder(null).build(); 
    assertEquals(false, addressEntry.contains(""));    
  }
  
  /**
   * Test the null phone 
   */  
  @Test
  public void testNullPhoneContain() {
    addressEntry = new AddressEntry.Builder(null).build(); 
    assertEquals(false, addressEntry.contains(""));    
  }
  
  /**
   * Test the null note 
   */  
  @Test
  public void testNullNoteContain() {
    addressEntry = new AddressEntry.Builder(null).build(); 
    assertEquals(false, addressEntry.contains(""));    
  }
  
  /**
   * Test Serilizae method and Deseriliaze method
   */
  @Test
  public void testSeriliazeAndDeseriliaze() {
    addressEntry = new AddressEntry.Builder("Peihong")
      .address("NYU").email("pc1336@nyu.edu").phone("917-688-9725")
      .note("Peihong's taking PQS").build(); 
   JSONObject seriliazeAddressEntry = addressEntry.Seriliaze();

   AddressEntry deseriliazeAddressEntry = AddressEntry.Deseriliaze(seriliazeAddressEntry);
     
   assertEquals(addressEntry.toString(), deseriliazeAddressEntry.toString());
    
  }
  
  /**
   * Test deseriliaze if JSONobject is null
   */
  @Test
  public void testNullDeseriliaze() {
    AddressEntry newEntry = addressEntry.Deseriliaze(null);
    assertEquals(true, err.toString().contains("CaughtException"));
  }
  
  /**
   * Test ToString method
   * It should be equal, but it's not here.
   * Format: 
   * {"phone":"917-688-9725","email":"pc1336@nyu.edu",
   * "address":"NYU","name":"Peihong",
   * "note":"Peihong's taking PQS"}
   * 
   */
  @Test
  public void testToString() {
    addressEntry = new AddressEntry.Builder("Peihong")
      .address("NYU").email("pc1336@nyu.edu").phone("917-688-9725")
      .note("Peihong's taking PQS").build();
    StringBuilder sb = new StringBuilder();
    sb.append("{\"phone\":\"917-688-9725\",");
    sb.append("\"email\":\"pc1336@nyu.edu\",");
    sb.append("\"address\":\"NYU\",");
    sb.append("\"name\":\"Peihong\",");
    sb.append("\"note\":\"Peihong's taking PQS\"}");
        
    //System.out.println(sb.toString());
    //System.out.println(addressEntry.toString());
    assertEquals(sb.toString(), addressEntry.toString());
  }
  
  /**
   * Test the function <code>toString</code> when addressEntry is newly
   * instantiated.
   */
  @Test
  public void testEmptyToString() {
    addressEntry = new AddressEntry.Builder("Peihong").build();
    //System.out.println(addressEntry.toString());
    assertEquals("{\"phone\":\"\",\"email\":\"\",\"address\"" +
    		":\"\",\"name\":\"Peihong\",\"note\":\"\"}", addressEntry.toString());
  }
  
  
  

}
