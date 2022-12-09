package BankServices;

import myLibrary.MyArrayList;

import java.util.Scanner;

public class Bank {

    private String name;
    private MyArrayList accounts = new MyArrayList();

    public Bank(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int createAccount(String name, int date, double initial) {
        Account account = new Account(accounts.size() + 1, name, date, initial);
        accounts.add(account);
        return accounts.size();

    }

    public Account deleteAccount(int code, int date) {
        Account account = getAccount(code);
        if (account == null) return null;
        accounts.remove(account);
        account.withdraw(date, account.getAmount());
        accounts.remove(account);
        return account;

    }

    public Account getAccount(int code) {
        if (code < 1 || code > accounts.size()) {
            System.err.println("Error Invalid account code!");
            return null;
        }
        return ((Account) accounts.get(code - 1));
    }

    public void deposit(int code, int date, double value) {
        Account account = getAccount(code);
        account.deposit(date, value);


    }


    public void withdraw(int code, int date, double value) {
        Account account = getAccount(code);
        account.withdraw(date, value);
    }

    public void transfer(int fromCode, int toCode, int date, double value) {
        Account sender = getAccount(fromCode);
        Account receiver = getAccount(toCode);
        if (sender == null || receiver == null) return;
        sender.withdraw(date, value);
        receiver.deposit(date, value);

    }

    public int getTotalDeposit() {
        Account account = new Account(12,"ndclf",25,5);
        return ((int) account.getAmount());
//   getTotalDeposit() hozirda bankka qo'yilgan pulning umumiy miqdorini qaytaradi (barcha hisoblardagi qoldiqlar yig'indisi);
    }

    public MyArrayList getAccounts() {
        return accounts;
    }


    public MyArrayList getZeroAccounts() {
        return null;
    }

    public MyArrayList getAccountsByBalance(double low, double high) {
        return null;
    }

    public long getNumberHigher(double min) {
        return 0;
    }
}

