//Author: Phu Nguyen 
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.jupiter.api.Test;

class ApplicantTest{
  @Test
  //@SuppressWarnings("deprecation")
  void instantiateTestNull() //test whether createApplicant even creates an Applicant instance at all
  {
    Applicant first = Applicant.createApplicant("Jeff Mike", "1475 Dog Street", 25, 10478, "abcde@gmail.com");
    assertNotNull(first);  
  }
  @Test
  void instantiateCorrectTest() //test if the information entered is the same information returned
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
  void defaultConstructorTestNull()//make sure that the default constructor makes something
  {
    Applicant temp = Applicant.createApplicant();
    assertNotNull(temp);
  }
  @Test
  void getInfoTestDefault() //run getInfo on the default constructor and test output
  {
    Applicant x = Applicant.createApplicant();   
    assertNotNull(x.getInfo());
    assertEquals("Name: No Name, Address: 1234 Default Street, Email: abcde@gmail.com, Age: 1, ID Number: 12345", x.getInfo());  

  }
  @Test
  void getInfoTest() //run getInfo with custom values
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
    assertNull(y.getInfo());
  }
  @Test
  void testVerifyApplicant()  //test verify Applicant using a predetermined value
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
