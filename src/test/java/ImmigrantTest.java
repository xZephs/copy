//Author: Arkan Jumani 
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

class ImmigrantTest{
  @Test
  //@SuppressWarnings("deprecation")
  void instantiateTestNull() //test whether createImmigrant even creates an immigrant instance at all
  {
    Immigrant first = Immigrant.createImmigrant("Jeff Mike", "1475 Dog Street", 25, 10478);
    assertNotNull(first);  
  }
  @Test
  void instantiateCorrectTest() //test if the information entered is the same information returned
  {
    Immigrant temp = Immigrant.createImmigrant("Dummy Man", "47925 Silly Lane", 37, 475278);
    assertNotNull(temp);
    assertNotNull(temp.getName());
    assertNotNull(temp.getAddress());
    assertTrue(temp.getAge()>=0 && temp.getAge()<=110);
    assertTrue(temp.getAge()>=0 && temp.getAge()<=9999999); 
    assertEquals("Dummy Man", temp.getName());
    assertEquals("47925 Silly Lane", temp.getAddress());
    assertTrue(temp.getAge()==37);
    assertTrue(temp.getRealID() == 475278);
  }
  @Test
  void instantiateInvalidInputTest()
  {
    Immigrant first = Immigrant.createImmigrant("Hello Fresh","NordVPN Road",-1,1234567); //if the input is invalid, according to the handling, createImmigrant should return null.
    assertNull(first);
  }
  @Test
  void instantiateNullInputTest() //test null inputs and error handling
  {
    Immigrant temp = Immigrant.createImmigrant(null,null,-1,-1);
    assertNull(temp);
  }
  @Test
  void defaultConstructorTestNull()//make sure that the default constructor makes something
  {
    Immigrant temp = Immigrant.createImmigrant();
    assertNotNull(temp);
  }
  @Test
  void getInfoTestDefault() //run getInfo on the default constructor and test output
  {
    Immigrant x = Immigrant.createImmigrant();   
    assertNotNull(x.getInfo());
    assertEquals("Name: No Name, Address: 1234 Default Street, Age: 1, ID Number: 12345", x.getInfo());  

  }
  @Test
  void getInfoTest() //run getInfo with custom values
  {
    Immigrant x = Immigrant.createImmigrant("Jeff Mike", "1475 Dog Street", 25, 10478);
    assertNotNull(x);
    assertNotNull(x.getName());
    assertNotNull(x.getAddress());
    assertTrue(x.getAge()>=0 && x.getAge()<=110);
    assertTrue(x.getAge()>=0 && x.getAge()<=9999999);    
    assertNotNull(x.getInfo());
    assertEquals("Name: Jeff Mike, Address: 1475 Dog Street, Age: 25, ID Number: 10478", x.getInfo());
  }
  @Test
  void getInfoNullTest() //check null handling from getInfo
  {
    Immigrant x = Immigrant.createImmigrant("Jeff Mike", "1475 Dog Street", 25, 10478);
    assertNotNull(x);
    x.setName(null);
    assertNull(x.getInfo());
  }
  @Test 
  void getInfoTestInvalid() //Check input validation from getInfo
  {
    Immigrant y = Immigrant.createImmigrant("Bob", "41234 Test Road", 9, 0);
    assertNull(y);
    //assertNull(y.getInfo());
  }
  @Test
  void testVerifyImmigrant()  //test verify immigrant using a predetermined value
  {
    Immigrant x = Immigrant.createImmigrant("Test Dummy", "9786 Biggie Smalls Court", 30, 92341);
    assertNotNull(x);
    assertTrue(Immigrant.verifyImmigrant(x));
  }
  @Test
  void verifyNullImmigrantTest() //verify null handling
  {
    Immigrant y = null;
    assertFalse(Immigrant.verifyImmigrant(y));
  }
} 
