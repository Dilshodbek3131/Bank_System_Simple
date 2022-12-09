package Main;

import BankServices.*;
import myLibrary.MyArrayList;

public class MainClass {
    public static void main(String[] args) {
        Bank bank1 = new Bank("Capital Bank");
        System.out.println(bank1.getName());
        System.out.println();
        int c1 = bank1.createAccount("John", 5, 500.5);
        int c2 = bank1.createAccount("Mary", 10, 1000.);
        int c3 = bank1.createAccount("John", 20, 800.);
        int c4 = bank1.createAccount("Paul", 30, 252.4);
        Account account1 = null, account3 = null;
        System.out.println();

        bank1.deposit(c1, 7, 360.0);
        bank1.deposit(c4, 35, 270.0);
        bank1.withdraw(c3, 28, 350.0);
        bank1.withdraw(c2, 19, 350.0);
        bank1.withdraw(c3, 41, 158.0);
        bank1.transfer(c1, c3, 8, 400.0);
        account1 = bank1.getAccount(c1);
        account3 = bank1.deleteAccount(c3, 50);

        for (int i = 0; i < bank1.getAccounts().size(); i++) {
            Account account = ((Account) bank1.getAccounts().get(i));

            System.out.println("account: " + account);
            System.out.println(" movements:");

            for (int j = 0; j < account.getMovements().size(); j++) {
                Operation operation = ((Operation) account.getMovements().get(j));
                System.out.println(operation);

            }
            System.out.println();


        }
//
//        for (Account a : bank1.getAccounts()) {
//            System.out.println("account: " + a);
//            System.out.println(" movements:");
//            for (Operation o : a.getMovements())
//                System.out.println(o);
        System.out.println();


/*		account: 1,John,8,460.5
		 movements:
		8,400.0-
		7,360.0+
		5,500.5+

		account: 2,Mary,19,650.0
		 movements:
		19,350.0-
		10,1000.0+

		account: 4,Paul,35,522.4
		 movements:
		35,270.0+
		30,252.4+


*/
        System.out.println("deleted account: " + account3);
        System.out.println(" movements:");

        MyArrayList movements = account3.getMovements();

        for (int i = 0; i < movements.size(); i++) {
            System.out.println(movements.get(i));


//        for(Operation operation : account3 .getMovements())
//           System.out.println();


/*		deleted account: 3,John,50,0.0
		 movements:
		50,692.0-
		41,400.0+
		41,158.0-
		28,350.0-
		20,800.0+
*/
            System.out.println("account: " + account1);
            System.out.println(" movements:");
            for (int j = 0; j < account1.getMovements().size(); j++) {
                Operation operation = ((Operation) account1.getMovements().get(j));
                System.out.println(operation);
            }
//
            System.out.println(" deposits:");
            for (int j = 0; j < account1.getDeposits().size(); j++) {
                Deposit deposit = ((Deposit) account1.getDeposits().get(j));
                System.out.println(deposit);
            }
//
//            System.out.println(d);
            // for (Withdrawal w : a1.getWithdrawals())
//            System.out.println(w);
            System.out.println(" withdrawals:");
            for (int j = 0; j < account1.getWithdrawals().size(); j++) {
                Withdrawal withdrawal = ((Withdrawal) account1.getWithdrawals().get(j));
                System.out.println(withdrawal);

            }
            System.out.println();
//        System.out.println();

/*		account: 1,John,8,460.5
		 movements:
		8,400.0-
		7,360.0+
		5,500.5+
		 deposits:
		5,500.5+
		7,360.0+
		 withdrawals:
		8,400.0-
*/
            System.out.println("total deposit in the " + bank1.getName() + " bank: " + bank1.getTotalDeposit());
            System.out.println();
//
////		total deposit in the Uncle-$crooge bank: 1632.9
//
            System.out.println("accounts with balance higher than 500: " + bank1.getNumberHigher(500));
            System.out.println();
//
////		accounts with balance higher than 500: 66.0 %
//
            System.out.println("accounts with balance in range 500..700 :");
//            for (Account a : bank1.getAccountsByBalance(500, 700));
//      4      System.out.println(a);
//        System.out.println();

/*		accounts with balance in range 500..700 :
			2,Mary,19,650.0
			4,Paul,35,522.4
*/
        }
    }
}


