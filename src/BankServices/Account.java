package BankServices;

import myLibrary.MyArrayList;

import java.util.Arrays;

public class Account {

    private int code;
    private String owner;
    private int date;
    private double amount;

    public double getAmount() {
        return amount;
    }

    private MyArrayList operations = new MyArrayList();
    private MyArrayList deposits = new MyArrayList();
    private MyArrayList withdrawals = new MyArrayList();

    public Account(int code, String owner, int date, double amount) {
        this.code = code;
        this.owner = owner;
        this.date = date;
        this.amount = amount;

        Deposit deposit = new Deposit(date, amount);
        operations.add(deposit);
        deposits.add(deposit);
    }


    public MyArrayList getMovements() {
        return operations;

//        getMovements() sanalar bo'yicha tartiblangan hisobda bajarilgan barcha operatsiyalar ro'yxatini qaytaradi;
    }

    public MyArrayList getDeposits() {
        return deposits;

//        getDeposits() hisobda amalga oshirilgan barcha omonatlar ro'yxatini ko'paytirish miqdori bo'yicha tartiblangan holda qaytaradi;
    }

    public MyArrayList getWithdrawals() {
        return withdrawals;

//getWithdrawals() ko'tarilgan miqdorlar bo'yicha tartiblangan hisobda amalga oshirilgan barcha yechib olishlar ro'yxatini qaytaradi.
    }

    public void deposit(int date, double value) {
        Deposit deposit = new Deposit(date, amount);
        amount += value;
        operations.add(deposit);
        deposits.add(deposit);
    }

    public void withdraw(int date, double value) {
        if (value > amount) {
            System.out.println("Error : Not enough money");
            return;
        }
        amount -= value;

        Withdrawal withdrawal = new Withdrawal(date, value);
        operations.add(withdrawal);
        withdrawals.add(withdrawal);
    }


    @Override
    public String toString() {
        return +code + "," + owner + "," + date + "," + amount + ", " + operations + "," ;
    }
}

//Account sinfi toString() methodini amalga oshiradi , u quyidagilardan iborat qatorni qaytaradi: hisob raqami, egasining ismi, oxirgi operatsiya sanasi
//va joriy balans, ularning barchasi vergul (" , ") bilan ajratilgan va ularsiz oraliq blankalar (masalan, " 4,Paul,35,522.3 ").

