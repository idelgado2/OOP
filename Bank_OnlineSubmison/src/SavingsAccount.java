/**
 *
 * @author Isaac
 */
public class SavingsAccount extends BankAccount{
    private final double INTEREST_RATE = 0.05;
    
    public SavingsAccount(){
        super();
    }
    
    public SavingsAccount (String owner, double initialBalance){
        super(owner, initialBalance);
    }
    
    public void AddInterest(){
        double increaseBy = (this.getBalance() * INTEREST_RATE);
        this.Deposit(increaseBy);
    }
}
