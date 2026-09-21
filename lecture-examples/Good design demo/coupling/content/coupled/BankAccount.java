/*
 * Content coupling example
 * Giving other classes control over this class's business logic makes it
 * difficult to control changes to the behavior of this class.
 */
public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }
    
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
