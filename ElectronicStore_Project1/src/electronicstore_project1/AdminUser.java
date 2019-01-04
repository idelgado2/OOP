/*************************************************************************
 * Project_1(Adminuser)
 * COSC3324
 * 10/30/2016
 * Purpose: This class implements an Admin membership for the class
 *          electronicStore_project1. This class also inherits from
 *          basicuser class. This Admin memebr only has the functionlaity of
 *          viewing history which is implmented in electronicStore_project1
 **************************************************************************/

package electronicstore_project1;

public class AdminUser extends BasicUser{

    AdminUser(String fname, String mname, String lname, String email){
        super(fname, mname, lname, email);
    }

    @Override
    void purchase(String item, double price) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void printPurchases() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
