class InsufficientBalanceException extends Exception {
    InsufficientBalanceException(String message) {
        super(message);
    }
}
class BankAccount {
    double balance = 5000;

    void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount");
        } else {
            balance += amount;
            System.out.println("Amount deposited: " + amount);
        }
    }

    void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Insufficient balance");
        } else if (amount <= 0) {
            System.out.println("Invalid withdrawal amount");
        } else {
            balance -= amount;
            System.out.println("Amount withdrawn: " + amount);
        }
    }

    void displayBalance() {
        System.out.println("Current balance: " + balance);
    }
}

public class BankDemo {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();

        account.deposit(2000);

        try {
            account.withdraw(8000);
        } catch (InsufficientBalanceException e) {
            System.out.println("Exception: " + e.getMessage());
        }

        account.displayBalance();
    }
}
