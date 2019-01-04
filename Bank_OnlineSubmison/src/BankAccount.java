/**
 *
 * @author Isaac
 */
public class BankAccount {
    private String owner;
    private double balance;
    
    public BankAccount(){
        owner = "Isaac Delgado";
        balance = 0.00;
    }
    
    public BankAccount(String owner, double balance){
        this.owner = owner;
        this.balance = balance;
    }
    
    public void Deposit(double amount){
        this.balance += amount;
    }
    
    public void Withdraw(double amount){
        this.balance -= amount;
    }
    
    public String getOwner(){
        return owner;
    }
    public double getBalance(){
        return balance;
    }
}
