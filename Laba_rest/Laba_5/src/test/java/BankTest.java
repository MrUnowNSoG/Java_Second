import org.example.Bank;
import org.example.BankAccount;

class BankTest {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Створення рахунків і тестування операцій
        try {
            BankAccount account1 = bank.createAccount("User1", 1000);
            BankAccount account2 = bank.createAccount("User2", 500);

            // Переказ коштів із рахунку 1 на рахунок 2
            bank.transferMoney(account1.getAccountNumber(), account2.getAccountNumber(), 300);

            System.out.println("Balance of account 1: " + account1.getBalance());
            System.out.println("Balance of account 2: " + account2.getBalance());
        } catch (BankAccount.NegativeAmountException | BankAccount.InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Тестування пошуку рахунку за номером
        BankAccount foundAccount = bank.findAccount(1);
        if (foundAccount != null) {
            System.out.println("Found account: " + foundAccount.getAccountName());
            System.out.println(foundAccount.getAccountSummary());
        } else {
            System.out.println("Account not found.");
        }

        // Тестування обробки винятку AccountNotFoundException
        try {
            BankAccount nonExistentAccount = bank.findAccount(100);
            if (nonExistentAccount == null) {
                throw new BankAccount.AccountNotFoundException();
            }
        } catch (BankAccount.AccountNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}