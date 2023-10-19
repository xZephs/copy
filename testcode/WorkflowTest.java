import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.jupiter.api.Test;


/**
 * Tester for Workflow.
 * @author M. Phan
 */
public class WorkflowTest {

    @Test
    void testCreateWorkflow(){

        //checking return type of createWorkflow()
        assertEquals(w, Workflow.class);

    }

    //Instantiate objects for testing purposes
    Workflow w = Workflow.createWorkflow();
    Immigrant i = Immigrant.createImmigrant("David","86 Braddock Road", 25, 12345);
    Document d = Document.createDoc(i,2 , 0);

    @Test
    void testUpdateData(){

        assertEquals(w.updateData("Data Entry", null), false);
        assertEquals(w.updateData(null, d), false);
        assertEquals(w.updateData("Data Entry", d),true);
        assertEquals(w.updateData("Data Entry", d),false); //Data entry is not allowed to update twice.
        
        //if the approval set the flag to finished, workflow should indicate that it has ended.
        w.updateData("Approval", d, true);
        assertEquals(w.isCompleted(),true);
    }

    @Test
    void testShowStatus(){

        //showStatus() should display the current step and version of document.
        String s = "The current stage is Data Entry\nCurrent version of Document:\n" + d.display();
        assertEquals(w.showStatus().getClass(), String.class);
        assertEquals(w.showStatus(),s);

        //at the beginning when no doc is updated into workflow, showStatus() should display special message.
        w = Workflow.createWorkflow();
        assertEquals(w.showStatus(),"The workflow has not begun!");
    }

    
}
