import java.util.LinkedList;
import java.util.Queue;

/**
 * This class represents a workflow object.
 * @author M. Phan
 */
public class Workflow{

   Queue<String> steps;
   boolean isCompleted;
   Document doc;

   /**
    * Private constructor to create a Workflow object.
    */
   private Workflow(){
      steps = new LinkedList<>();
      steps.add("Data Entry");
      steps.add("Review");
      steps.add("Approval");
      isCompleted = false;
   }

   public static Workflow createWorkflow(){
    return new Workflow();

   }

   public Document getDoc(){
      return this.doc;
   }

   public boolean isCompleted(){
      return isCompleted;
   }

   /**
    * This method is used to update in Data Entry and Review
    * @param stepname
    * @param d
    * @return true if data is updated successfully, false otherwise.
    */
   public boolean updateData(String stepname, Document d){
    return false;
   }

   /**
    * This method is used to update in Approval
    * @param stepname
    * @param d
    * @param flag
    * @return true if data is updated successfully, false otherwise.
    */
   public boolean updateData(String stepname, Document d, boolean flag){
    return false;
   }

   /**
    * Show the current status of the workflow
    * @return
    */
   public String showStatus(){
    return "";
   }

   

}
