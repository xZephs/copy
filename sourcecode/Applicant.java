//Author: Phu Nguyen
public class Applicant implements Person{
    private String name; //instance variables for the applicant class
    private String address;
    private int age;
    private int realID;
    private String email;
    public String getInfo()  //getInfo displays all of the immigrant's information in a single concise statement.
    {
        if(this==null || this.email==null || this.name == null || this.address == null || this.age <=0 || this.realID<=0 || this.age > 110 || this.realID > 9999999)
        {
            return null; //input validation; if any fields are outside of the allowed ranges/values, return null as an indication of such
        }
        return ""; //return the information of the immigrant
    }
    
    private Applicant() //private applicant constructor
    {
        this.name = "No Name"; //default values for an empty constructor
        this.address="1234 Default Street";
        this.age = 1;
        this.realID = 12345;
        this.email = "abced@gmail.com";
    }
    
    private Applicant(String name, String address, int age, int realID, String email)
    {
        this.name = name; //assign the respective variables with the corresponding arguments passed in
        this.address = address;
        this.age = age;
        this.realID = realID;
        this.email = email;
    }
    
    public String getName() //various getters (for testing purposes mainly)
    {
        return this.name;
    }
    
    public String getAddress()
    {
        return this.address;
    }
    
    public int getAge()
    {
        return this.age;
    }
    
    public int getRealID()
    {
        return this.realID;
    }
    
    public String getEmail(){
        return this.email;
    }
    
    public void setName(String name) //various setters (for testing purposes)
    {
        this.name = name;
    }
    
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    public void setAge(int age)
    {
        this.age = age;
    }
    
    public void setID(int ID)
    {
        this.realID = ID;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public static Applicant createApplicant() { //public method used to access the default constructor
        Applicant temp = null;
        return temp;
    }
    
    public static Applicant createApplicant(String name, String address, int age, int realID, String email) //public method used to indirectly access constructor w/ arguments
    {
        if(name == null || address == null || age <=0 || realID<=0 || age >110 || realID > 9999999 || email == null)
        {
            return null; //handle input validation by printing error statement and returning null
        }
        else
        {
            Applicant temp = null; //if input is valid, create an applicant instance using constructor, then return
            return temp;
        }
    }
    
    public static boolean verifyApplicant(Applicant x) //verifyApplicant will make a call to an API (to be implemented) which helps validate the information provided.
    {
        if(x == null)
        {
            return false;
        }
        //verify applicant by making call to database
        return false;
    }
    
    
}
