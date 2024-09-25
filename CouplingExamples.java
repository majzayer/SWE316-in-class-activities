/*
* Content coupling example
* Giving other classes control over my class's business logic makes it difficult
* to control changes to the behavior of my class
*/
public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    // This should be a private method to maintain encapsulation
    public void setBalance(double balance) {
        this.balance = balance;
    }
}

public class BankService {
    private BankAccount account;

    public BankService(BankAccount account) {
        this.account = account;
    }

    public void withdraw(double amount) {
        // Content coupling: Directly modifying the internal state (balance) of BankAccount
        double currentBalance = account.getBalance();
        account.setBalance(currentBalance - amount);  // Violating encapsulation by setting balance directly
    }
}

/* 
* Content (de-)coupling example
*/
public class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    // Proper encapsulation: Only the BankAccount class can modify its own balance
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds.");
        }
    }
}

public class BankService {
    private BankAccount account;

    public BankService(BankAccount account) {
        this.account = account;
    }

    public void withdrawFromAccount(double amount) {
        account.withdraw(amount);  // Delegate the responsibility to BankAccount
    }
}

/*
* Control coupling example
* Depending on the value of the flag, a certain method would be called
*/
public class ReportGenerator {
    public void generateReport(boolean isDetailed) {
        if (isDetailed) {
            generateDetailedReport();  // Generate a detailed report
        } else {
            generateSummaryReport();  // Generate a summary report
        }
    }

    private void generateDetailedReport() {
        System.out.println("Generating detailed report...");
        // Detailed report logic
    }

    private void generateSummaryReport() {
        System.out.println("Generating summary report...");
        // Summary report logic
    }
}

/*
* Control (de-)coupling example
*/
interface Reportable {
    public void generate();
}

// Detailed report class
class DetailedReport implements Reportable {
    @Override
    public void generate() {
        System.out.println("Generating detailed report...");
        // Detailed report logic
    }
}

// Summary report class
class SummaryReport implements Reportable {
    @Override
    public void generate() {
        System.out.println("Generating summary report...");
        // Summary report logic
    }
}

public class ReportGenerator {
    private Reportable report;

    public ReportGenerator(Reportable report) {
        this.report = report;
    }

    public void generateReport() {
        report.generate();  // The specific report type handles the logic
    }
}

/*
* Stamp coupling example
*/
public class Emailer
{
 public void sendEmail(Employee e, String text) {...}
 ...
}

/*
* Stamp (de-) coupling example
*/
public interface Addressee
{
 public abstract String getName();
 public abstract String getEmail();
}
public class Employee implements Addressee {...}
public class Emailer
{
 public void sendEmail(Addressee e, String text) {...}
 ...
}
