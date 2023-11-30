import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DocumentTest {

    Applicant a = Applicant.createApplicant("Andrew", "Braddock", 25, 12345, "@gmail");
    Immigrant i = Immigrant.createImmigrant("Andrew", "Braddock", 25, 12345);
    
    @Test
    void testAllInvalid(){
        assertNull(Document.createDoc(null,null,-1,-1));       //All invalid valid inputs
    }

    @Test
    void testNullApplicant(){
        assertNull(Document.createDoc(i,null,30,1));     //Invalid applicant input
    }

    @Test 
    void testNullImmigrant(){
        assertNull(Document.createDoc(null,a,30,1));     //Invalid immigrant input
    }

    @Test 
    void testInvalidForm(){
        assertNull(Document.createDoc(i,a,-1,1));        //Invalid form
    }

    @Test
    void testInvalidID(){
        assertNull(Document.createDoc(i,a,30,-1000000));      //Invalid id input
    }

    @Test 
    void testSuccess(){
        //Successfully create Document
        Document d = Document.createDoc(i, a, 23, 1);
        assertTrue(d instanceof Document);
        assertNotNull(d);
        assertEquals(d.getApplicant(), a);
    }

   
}
