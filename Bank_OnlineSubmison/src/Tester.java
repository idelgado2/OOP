/**
 *
 * @author Isaac
 */
public class Tester {
    public static void main(String []args){
        BankAccount is = new BankAccount("Isaac", 50.00);
        println(is.getOwner());
        println(is.getBalance());
        println("------------------------------------------------");
        
        SavingsAccount pe = new SavingsAccount("Pedro", 10.00);
        pe.Deposit(20.00);
        pe.AddInterest();
        println(pe.getBalance());
        println("------------------------------------------------");
        
        CheckingAccount de = new CheckingAccount("Delgado", 100.00, 50);
        de.Withdraw(50.00);
        de.UseCheck();
        println(de.getBalance());
        println("------------------------------------------------");

        CheckingAccountFees ro = new CheckingAccountFees("Rocky", 300.00, 30);
        ro.Withdraw(25.00);
        ro.DeductFees();
        ro.UseCheck();
        println(ro.getBalance());
        
        println("------------------------------------------------");
        printOwner(is);
        printOwner(pe);
        printOwner(de);
        printOwner(ro);
    }
    
    public static void println(Object s){
        System.out.println(s);
    }
    
    public static void printOwner(BankAccount account){
        println(account.getOwner());
    }
}
