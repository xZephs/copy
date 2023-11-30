//Author: Phu Nguyen 
import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ApplicantTest{
  @Test
  //@SuppressWarnings("deprecation")
  void instantiateTestNull() //test if createApplicant creates an Applicant instance with parameters
  {
    Applicant first = Applicant.createApplicant("Jeff Mike", "1475 Dog Street", 25, 10478, "abcde@gmail.com");
    assertNotNull(first);  
  }
  @Test
  void instantiateCorrectTest() //test parameters entered are what returning.
  {
    Applicant temp = Applicant.createApplicant("Dummy Man", "47925 Silly Lane", 37, 475278, "12345@gmail.com");
    assertNotNull(temp);
    assertNotNull(temp.getName());
    assertNotNull(temp.getAddress());
    assertTrue(temp.getAge()>=0 && temp.getAge()<=110);
    assertTrue(temp.getAge()>=0 && temp.getAge()<=9999999); 
    assertEquals("Dummy Man", temp.getName());
    assertEquals("47925 Silly Lane", temp.getAddress());
    assertEquals("12345@gmail.com", temp.getEmail());
    assertTrue(temp.getAge()==37);
    assertTrue(temp.getID() == 475278);
  }
  @Test
  void instantiateInvalidInputTest()
  {
    Applicant first = Applicant.createApplicant("Hello Fresh","NordVPN Road",-1,1234567,""); //if the input is invalid, according to the handling, createApplicant should return null.
    assertNull(first);
  }
  @Test
  void instantiateNullInputTest() //test null inputs and error handling
  {
    Applicant temp = Applicant.createApplicant(null,null,-1,-1,null);
    assertNull(temp);
  }
  @Test
  void defaultConstructorTestNull()//test on default constructor to see if it actually make an instance
  {
    Applicant temp = Applicant.createApplicant();
    assertNotNull(temp);
  }
  @Test
  void getInfoTestDefault() //run getInfo method on the default constructor and test output
  {
    Applicant x = Applicant.createApplicant();   
    assertNotNull(x.getInfo());
    assertEquals("Name: No Name, Address: 1234 Default Street, Email: abcde@gmail.com, Age: 1, ID Number: 12345", x.getInfo());  

  }
  @Test
  void getInfoTest() //run getInfo method with modified values
  {
    Applicant x = Applicant.createApplicant("Jeff Mike", "1475 Dog Street", 25, 10478, "12345@gmail.com");
    assertNotNull(x);
    assertNotNull(x.getName());
    assertNotNull(x.getAddress());
    assertNotNull(x.getEmail());
    assertTrue(x.getAge()>=0 && x.getAge()<=110);
    assertTrue(x.getAge()>=0 && x.getAge()<=9999999);    
    assertNotNull(x.getInfo());
    assertEquals("Name: Jeff Mike, Address: 1475 Dog Street, Email: 12345@gmail.com Age: 25, ID Number: 10478", x.getInfo());
  }
  @Test
  void getInfoNullTest() //check null handling from getInfo
  {
    Applicant x = Applicant.createApplicant("Jeff Mike", "1475 Dog Street", 25, 10478,"12345@gmail.com");
    assertNotNull(x);
    x.setName(null);
    assertNull(x.getInfo());
  }
  @Test 
  void getInfoTestInvalid() //Check input validation from getInfo
  {
    Applicant y = Applicant.createApplicant("Bob", "41234 Test Road", 9, 0,"zxcvb@gmail.com");
    assertNull(y);
  }
  @Test
  void testVerifyApplicant()  //use a set/default value to verify applicant
  {
    Applicant x = Applicant.createApplicant("Test Dummy", "9786 Biggie Smalls Court", 30, 92341,"asdfg@gmail.com");
    assertNotNull(x);
    assertTrue(Applicant.verifyApplicant(x));
  }
  @Test
  void verifyNullApplicantTest() //verify null handling
  {
    Applicant y = null;
    assertFalse(Applicant.verifyApplicant(y));
  }
  
  
  

} 
