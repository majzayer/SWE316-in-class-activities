public class BankService {
    private BankAccount account;

    public BankService(BankAccount account) {
        this.account = account;
    }

    public void withdrawFromAccount(double amount) {
        account.withdraw(amount);
    }
}
