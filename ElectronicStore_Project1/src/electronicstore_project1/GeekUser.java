/*************************************************************************
 * Project_1(GeekUser)
 * COSC3324
 * 10/30/2016
 * Purpose: This class implements a geek membership for the class
 *          electronicStore_project1. This class also inherits from
 *          standardUser class which in turn inherits from basicUser.
 **************************************************************************/

package electronicstore_project1;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class GeekUser extends StandardUser {

    private boolean paidThisMonth; 
    private int geekPoints; 

    public GeekUser(String fname, String mname, String lname, String email, long account)
    {
        super(fname, mname, lname, email, account);
        geekPoints = 0;
    }
    
    public int getGeekPoints(){
        return geekPoints;
    }
    
    @Override
    public void purchase(String item, double price){ 
        super.purchase(item, price);
        NumberFormat formatter = new DecimalFormat("#0.00"); //for formatting price for geekPoints
        if(price >= 100){
            geekPoints += (int)(price/100) * 100; //$100 equals to 100 GeekPoints
            geekPoints += (int)Math.round(Double.parseDouble(formatter.format(price % 100))/.2); //$0.2 equals to 1 GeekPoint
        }else{
            geekPoints += (price / 0.2); //$0.2 equals to 1 GeekPoint
        }
    }
    
    @Override
    public void printPurchases(){
        super.printPurchases();
        System.out.println("\nTotal Geek Points =====> " + geekPoints);
    }
}
