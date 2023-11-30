import static org.hamcrest.CoreMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


/**
 * Tester for Workflow.
 * @author M. Phan
 */
public class WorkflowTest {

    //Instantiate objects for testing purposes
    Immigrant i = Immigrant.createImmigrant("David","86 Braddock Road", 25, 12345);
    Applicant a = Applicant.createApplicant("Andrew", "Braddock", 25, 12345, "@gmail");
    Document d = Document.createDoc(i,a,2 , 0);

    @Test
    void testCreateWorkflow(){
        assertFalse(Workflow.createWorkflow(null));
        assertTrue(Workflow.createWorkflow(d));
    }

    
    @Test
    void testInitialSteps(){
        //initializing variables
        assertEquals(Workflow.getRemainingSteps(),"Review Approval");
        assertFalse(Workflow.isCompleted());
    }


    @Test
    void testEntries1(){
        assertFalse(Workflow.updateData(null, d, false));
    }

    @Test
    void testEntries2(){
        assertFalse(Workflow.updateData("apple", d, false));
    }

    @Test
    void testEntries3(){
        assertFalse(Workflow.updateData("Review", null, false));
    }

    @Test 
    void testReview(){
        assertTrue(Workflow.updateData("Review", d, true));
        assertEquals(Workflow.showStatus(),"Approval");
    }

    @Test
    void testApproval(){
        //disapprove, sending back 

        assertTrue(Workflow.updateData("Approval", d, false));
        assertEquals(Workflow.showStatus(),"Review");
        assertEquals(Workflow.getRemainingSteps(),"Review Approval");
        assertFalse(Workflow.isCompleted());

        Workflow.updateData("Review", d, true);
        assertEquals(Workflow.showStatus(), "Approval");
        assertEquals(Workflow.getRemainingSteps(), "Approval");
        assertFalse(Workflow.isCompleted());
    }

    @Test 
    void testApproval1(){
        assertTrue(Workflow.updateData("Approval", d, true));
        assertEquals(Workflow.showStatus(),"Completed");
        assertTrue(Workflow.isCompleted());
         assertEquals(Workflow.getRemainingSteps(),"Workflow is finished.");
    }

    
}
