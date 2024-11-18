class BankAccount {
    private String accountHolderName;
    private double balance;

    public BankAccount(String accountHolderName, double initialBalance) {
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: " + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: " + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
    }

    public void displayAccountDetails() {
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Current Balance: " + balance);
    }
}

public class BankApp {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Dev Mulkalwar", 1000.0);
        account.displayAccountDetails();
        account.deposit(500);
        account.withdraw(300);
        account.withdraw(1500);
        account.displayAccountDetails();
    }
}
