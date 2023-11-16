package org.javafx;

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
        Document temp = new Document(i, a, form, id);
        return temp;
    }

    /**
     * This method displays the document.
     * @return
     */
    public String display(){
        return "";
    }

    //Document can be modified via a set of getters.



}
