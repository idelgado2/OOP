/*************************************************************************
 * Project_1(BasicUser)
 * COSC3324
 * 10/30/2016
 * Purpose: This ABSTRACT class provides a User structure for inheriting 
 *          classes such as geek membership for the class. This basic
 *          structure includes memeber feilds for firs, middle, and last name
 *          as well as for their email which will be treated as a username;
 *          this class will also declare the abstract methods of purchasing
 *          and printpurchases
 **************************************************************************/

package electronicstore_project1;

abstract class BasicUser {
    private int userId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String email;
    
    
    BasicUser(String fname, String mname, String lname, String email){
        firstName = fname;
        middleName = mname;
        lastName = lname;
        this.email = email;
    }
    
    public String viewProducts(){
       String products = "these are products";
       //maby a method here that gets the string of products
        return products;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getMirstName(){
        return middleName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public void setFirstName(String name){
        firstName = name;
    }
    
    public void setMiddleName(String name){
        middleName = name;
    }
    
    public void setLastName(String name){
        lastName = name;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    abstract void purchase(String item, double price);
    abstract void printPurchases();
    
}
