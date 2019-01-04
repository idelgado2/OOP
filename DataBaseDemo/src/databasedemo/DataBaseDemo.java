
package databasedemo;

import java.sql.*;

/**
 *
 * @author Isaac
 */
public class DataBaseDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException{
        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;
        
        String user = "root";
        String password = "idelgado2";
        
        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", user, password);

            // 2. Create a statement
            myStmt = myConn.createStatement();

            // 3. Execute SQL query
            myRs = myStmt.executeQuery("select * from pet");

            // 4. Process the result set
            while (myRs.next()) {
                System.out.println(myRs.getString("name") + ", " + myRs.getString("owner")
                                + ", " + myRs.getString("species") + ", " 
                                + myRs.getString("sex"));
            }
            
        String tempUsername = "Buffy";
        myRs = myStmt.executeQuery("select owner from pet where name = " +
                    "'" + tempUsername + "'");
        myRs.next();
        System.out.println(myRs.getString("owner"));
                
        }catch(Exception exc){
            exc.printStackTrace();
        }finally{
            if(myRs != null)
                myRs.close();
            if(myStmt != null)
                myStmt.close();
            if(myConn != null)
                myConn.close();
        }
       
            
    }
    
}
