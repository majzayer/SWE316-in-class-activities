public class BankService {
    private BankAccount account;

    public BankService(BankAccount account) {
        this.account = account;
    }

    public void withdraw(double amount) {
        double currentBalance = account.getBalance();
        account.setBalance(currentBalance - amount);
    }
}
