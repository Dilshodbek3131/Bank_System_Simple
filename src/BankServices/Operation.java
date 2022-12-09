package BankServices;

public class Operation {

    private  int date;
    private  double amount;

    public Operation(int date, double amount) {
        this.date = date;
        this.amount = amount;
    }

    public int getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {return super.toString();
    }
}
