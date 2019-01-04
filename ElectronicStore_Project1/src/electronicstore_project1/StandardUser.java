/*************************************************************************
 * Project_1(StandardUser)
 * COSC3324
 * 10/30/2016
 * Purpose: This class implements a User membership for the class
 *          electronicStore_project1. This class also inherits from
 *          basicdUser.. The functionality of this class includes purchasing
 *          and printing the purchases.
 **************************************************************************/
package electronicstore_project1;

public class StandardUser extends BasicUser{
    private long creditAccount;
    private int balance;
    private int numberOfItems; //that user wants to buy
    private String [] toBuy = new String[15]; //user can only have 15 items toBuy at a time
                                                //(like a wishlist)
    private Double [] toBuyPrices = new Double[15]; //to hold the prices
    
    
    public StandardUser(String fname, String mname, String lname, String email, long account){
      super(fname, mname, lname, email);
      creditAccount = account;
      numberOfItems = 0; //no items being bought just yet
    }
    
    public void purchase(String item, double price){ 
        toBuy[numberOfItems] = item; //add item to personal list of items
        toBuyPrices[numberOfItems] = price; //add price to parralle array
        numberOfItems++;
    }
    
    public void setCreditAccount(long account){
        creditAccount = account;
    }
    
    public void printPurchases(){       
        for(int i = 0; i < numberOfItems; i++){
            System.out.println(toBuy[i] + " =========> $" + toBuyPrices[i]);
        }
    }
}
