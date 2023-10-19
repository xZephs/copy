//Author: Arkan Jumani 
public class Immigrant implements Person{
    private String name; //instance variables for the immigrant class
    private String address;
    private int age;
    private int realID;
    public String getInfo()  //getInfo displays all of the immigrant's information in a single concise statement.
    {
        if(this==null || this.name == null || this.address == null || this.age <=0 || this.realID<=0 || this.age > 110 || this.realID > 9999999)
        {
            return null; //input validation; if any fields are outside of the allowed ranges/values, return null as an indication of such
        }
        return ""; //return the information of the immigrant
    }
    private Immigrant() //private immigrant constructor
    {
        this.name = "No Name"; //default values for an empty constructor
        this.address="1234 Default Street";
        this.age = 1;
        this.realID = 12345;
    }
    private Immigrant(String name, String address, int age, int realID)
    {
        this.name = name; //assign the respective variables with the corresponding arguments passed in
        this.address = address;
        this.age = age;
        this.realID = realID;
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
    public int getID()
    {
        return this.realID;
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
    public static Immigrant createImmigrant() { //public method used to access the default constructor
        Immigrant temp = null;
        return temp;
    }
    public static Immigrant createImmigrant(String name, String address, int age, int realID) //public method used to indirectly access constructor w/ arguments
    {
        if(name == null || address == null || age <=0 || realID<=0 || age >110 || realID > 9999999)
        {
            return null; //handle input validation by printing error statement and returning null
        }
        else
        {
            Immigrant temp = null; //if input is valid, create an immigrant instance using constructor, then return
            return temp;
        }
    }
    public static boolean verifyImmigrant(Immigrant x) //verifyImmigrant will make a call to an API (to be implemented) which helps validate the information provided.
    {
        if(x == null)
        {
            return false;
        }
        //verify immigrant by making call to database
        return false;
    }
    
    
}
