/**
 *
 * @author Isaac
 */
public class CheckingAccount extends BankAccount{
    private int remainingChecks;
    
    public CheckingAccount(){
        super();
        remainingChecks = 100;
    }
    
    public CheckingAccount(String owner, double initBalance, int remainingChecks){
        super(owner, initBalance);
        this.remainingChecks = remainingChecks;
    }
    
    public void UseCheck(){
        remainingChecks--;
    }
    
    public void GetCheck(){
        remainingChecks++;
    }
}
