import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;

/**
 * Tester for Document.
 * @author M. Phan
 */
public class DocumentTest {
    
    @Test
    void testCreateDocument(){
        Applicant a = Applicant.createApplicant("Andrew", "Braddock", 25, 12345, "@gmail");
        Immigrant i = Immigrant.createImmigrant("Andrew", "Braddock", 25, 12345);
        
        assertNull(Document.createDoc(null,null,-1,-1));       //All invalid valid inputs
        assertNull(Document.createDoc(i,a,200,1));         //Invalid age input
        assertNull(Document.createDoc(null,a,30,1));     //Invalid immigrant input
        assertNull(Document.createDoc(i,null,30,1));     //Invalid applicant input
        assertNull(Document.createDoc(i,a,30,-1000000));      //Invalid id input

        //Successfully create Document
        assertEquals(Document.createDoc(i, a, 23, 1), Document.class);
        Document d = Document.createDoc(i, a, 23, 1);
        assertNotNull(d);

    }

    @Test
    void testDisplay() {
        //Objects instantiation for testing
        Applicant a = Applicant.createApplicant("Andrew", "Braddock", 25, 12345, "@gmail");
        Immigrant i = Immigrant.createImmigrant("Tony", "Braddock", 25, 12345);
        Document d = Document.createDoc(i, a, 23, 1);

        //displaying content of Document
        assertEquals(d.display(), "Applicant: Andrew \nImmigrant: Tony \n Form: 23\nID: 1");
    }
}
