
import java.util.LinkedList;
import java.util.Queue;

/**
 * This class represents a workflow object.
 * @author M. Phan
 */
public class Workflow {

    static Queue<String> steps;
    static boolean isCompleted;
    static Document doc;

    // Static initialization block
    static boolean init(Document d){
        if (d == null) return false;
        doc = d;
        steps = new LinkedList<>();
        steps.add("Review");
        steps.add("Approval");
        isCompleted = false;
        return true;
    }

    //external method to createWorkflow
    public static boolean createWorkflow(Document d) {
        return init(d);
    }

    //setters and getters
    public static void setDoc(Document d){
        doc = d;
    }

    public static Document getDoc() {
        return doc;
    }

    public static String getCurrStep(){
        return steps.peek();
    }

    public static void setCompleted(){
        isCompleted = true;
    }

    public static boolean isCompleted() {
        return isCompleted;
    }


    /**
     * This method is used to update.
     *
     * @param stepname
     * @param d
     * @param flag to indicate whether this process is completed 
     * @return true if data is updated successfully, false otherwise.
     */
    public static boolean updateData(String stepname, Document d, boolean flag) {
        if (stepname.equals("Review")){
            if (flag){
                steps.remove();
            }
        }
        if (stepname.equals("Approval")){
            steps.remove();
            if(flag){
                setCompleted();
            }
            else{
                steps.add("Review");
                steps.add("Approval");
            }
        }
        return false;
    }

    /**
     * Show the current status of the workflow.
     *
     * @return the current status
     */
    public static String showStatus() {
        if (!isCompleted) return steps.peek();
        return "Completed.";
    }

    /**
     * Show the remaining steps in line.
     *
     * @return remaining steps
     */
    public static String getRemainingSteps() {
        StringBuilder s = new StringBuilder();
        if (steps.peek() != null){
            for(String step: steps){
                s.append(step + " ");
            }
        }
        return s.toString().trim();
    }
}
