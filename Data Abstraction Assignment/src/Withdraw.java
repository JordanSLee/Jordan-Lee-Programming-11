import java.util.Date;

public class Withdraw {
    private double amount;
    private Date date;
    private String account;

    Withdraw(double amount, Date date, String account){
        this.amount = amount;
        this.date = date;
        this.account = account;
    }
    // modifies: this
    // effects: prints out ("Withdrawal of: $" + amount + "Date: " + date + "into account: " + account) by overwriting the regular toString
    public String toString(){
        //your code here
        return("Withdrawal of: $" + amount + "Date: " + date + "from account: " + account);
    }
}
