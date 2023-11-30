import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Tester for Document.
 * @author M. Phan
 */
public class DocumentTest {
    
    Applicant a = Applicant.createApplicant("Andrew", "Braddock", 25, 12345, "@gmail");
    Immigrant i = Immigrant.createImmigrant("Andrew", "Braddock", 25, 12345);
    
    @Test
    void testCreateDocument(){
        assertNull(Document.createDoc(null,null,-1,-1));       //All invalid valid inputs
        assertNull(Document.createDoc(null,a,30,1));           //Invalid immigrant input
        assertNull(Document.createDoc(i,null,30,1));           //Invalid applicant input
        assertNull(Document.createDoc(i,a,30,-1000000));       //Invalid id input

        //Successfully create Document
        assertEquals(Document.createDoc(i, a, 23, 1), Document.class);
        Document d = Document.createDoc(i, a, 23, 1);
        assertNotNull(d);

    }

    @Test
    void invalid2(){
         assertNull(Document.createDoc(i,a,30,-1000000));       //Invalid id input

    }

    @Test invalid3(){
        assertNull(Document.createDoc(null,a,30,1));   
    }

}
