/**
 *
 * @author Isaac
 */
public class CheckingAccountFees extends CheckingAccount{
    private final double FEES = 20.00;
    
    public CheckingAccountFees(){
        super();
    }
    
    public CheckingAccountFees(String owner, double initBalance, int remainingChecks){
        super(owner, initBalance, remainingChecks);
    }
    
    public void DeductFees(){
        this.Withdraw(FEES);
    }
}
