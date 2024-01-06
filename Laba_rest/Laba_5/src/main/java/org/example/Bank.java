package org.example;

import java.util.ArrayList;

public class Bank {
    private ArrayList<BankAccount> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    // Додати новий об'єкт BankAccount до колекції
    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    // Створити новий рахунок з вказаним ім'ям користувача та початковим депозитом
    public BankAccount createAccount(String accountName, double initialDeposit) {
        if (initialDeposit < 0) {
            // Перевірка на негативний початковий депозит
            try {
                throw new BankAccount.NegativeAmountException();
            } catch (BankAccount.NegativeAmountException e) {
                throw new RuntimeException(e);
            }
        }

        int accountNumber = generateAccountNumber();
        BankAccount newAccount = new BankAccount(accountNumber, accountName, initialDeposit);
        accounts.add(newAccount);
        return newAccount;
    }

    // Пошук рахунку за номером рахунку
    public BankAccount findAccount(int accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        // Якщо рахунок не знайдено, повертаємо null
        return null;
    }

    // Переказати гроші із одного рахунку на інший
    public boolean transferMoney(int fromAccountNumber, int toAccountNumber, double amount)
            throws BankAccount.InsufficientFundsException, BankAccount.NegativeAmountException {
        if (amount < 0) {
            // Перевірка на негативну суму
            throw new BankAccount.NegativeAmountException();
        }

        BankAccount fromAccount = findAccount(fromAccountNumber);
        BankAccount toAccount = findAccount(toAccountNumber);

        if (fromAccount == null || toAccount == null) {
            // Якщо один з рахунків не знайдено, переказ не вдається виконати
            return false;
        }

        if (fromAccount.getBalance() < amount) {
            // Недостатньо коштів на рахунку fromAccount
            throw new BankAccount.InsufficientFundsException();
        }

        // Виконуємо переказ
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
        return true;
    }


    private int generateAccountNumber() {

        return accounts.size() + 1;
    }


}
