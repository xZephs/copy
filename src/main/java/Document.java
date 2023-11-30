/**
 * This class represents a Document to contain the request.
 * @author M. Phan
 */
public class Document {
    private Immigrant immigrant;
    private Applicant applicant;
    int form;
    int id;

    //private constructor
    private Document(Immigrant i, Applicant a, int form, int id){
        this.immigrant = i;
        this.applicant = a;
        this.form = form;
        this.id = id;
    }

    /**
     * This method is used to create a Document.
     * @param i
     * @param a
     * @param form
     * @param id
     * @return
     */
    public static Document createDoc(Immigrant i, Applicant a, int form, int id){
        Document d = new Document(i,a,form,id);
        return d;
    }

    public Applicant getApplicant(){
        return this.applicant;
    }

    public Immigrant getImmigrant(){
        return this.immigrant;
    }

    public int getForm(){
        return form;
    }

    public void setForm(int f){
        form = f;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    
   



}
