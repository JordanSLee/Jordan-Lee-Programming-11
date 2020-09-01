import javax.security.sasl.SaslClient;
import java.util.ArrayList;
import java.util.Date;

public class Customer {
    private int accountNumber;
    private ArrayList<Deposit> deposits = new ArrayList<Deposit>();
    private ArrayList<Withdraw> withdraws = new ArrayList<Withdraw>();
    private double checkBalance;
    private double savingBalance;
    private double savingRate;
    private String name;
    public static final String CHECKING = "Checking";
    public static final String SAVING = "Saving";
    private final int OVERDRAFT = -100;

    Customer(){
        //create default constructor
        accountNumber = 0;
        checkBalance = 0;
        savingBalance = 0;
        savingRate = 0;
        name = "";
    }
    Customer(String name, int accountNumber, double checkDeposit, double savingDeposit){
        //constructor code here
        this.accountNumber = accountNumber;
        this.checkBalance = checkBalance + checkDeposit;
        this.savingBalance = savingBalance + savingDeposit;
        this.name = name;
    }

    // requires: double, date, string
    // modifies: checkBalance, savingBalance, arrayList deposits
    // effects: puts deposit in arraylist deposits, then adds it to savingBalance / checkingBalance
    public double deposit(double amt, Date date, String account){
        //your code here
        new Deposit(amt,date,account);
        if(account.equals(CHECKING)) {
            this.checkBalance = this.checkBalance + amt;
            deposits.add(new Deposit(amt,date,account));
        }
        else if(account.equals(SAVING)){
            this.savingBalance = this.savingBalance + amt;
            deposits.add(new Deposit(amt,date,account));
        }
        return 0;

        // requires: double, date, string
        // modifies checkBalance, savingBalance, arrayList withdraws
        //effects: puts withdraw in arrayList withdraws, then subtracts it from savingBalance / checkBalance
    }
    public double withdraw(double amt, Date date, String account){
        //your code here
        new Withdraw(amt,date,account);
        if(account.equals(CHECKING)) {
            if(!checkOverdraft(amt,CHECKING)) {
                this.checkBalance = this.checkBalance - amt;
                withdraws.add(new Withdraw(amt,date,account));
            }
            else{
                System.out.println("OVERDRAFT ERROR");
            }
        }
        if(account.equals(SAVING)) {
            if(!checkOverdraft(amt,SAVING)) {
                this.savingBalance = this.savingBalance - amt;
                withdraws.add(new Withdraw(amt,date,account));
            }
            else{
                System.out.println("OVERDRAFT ERROR");
            }
        }
        return 0;

        // requires: double, string
        // effects: checks if checkBalance / savingBalance is over the OVERDRAFT (-100)
    }
    private boolean checkOverdraft(double amt, String account){
        //your code here
        if(account.equals(CHECKING)){
            return this.savingBalance - amt < OVERDRAFT;
        }
        else if(account.equals(SAVING)){
            return this.savingBalance - amt < OVERDRAFT;
        }
        return false;
    }
    //do not modify
    public void displayDeposits(){
        for(Deposit d : deposits){
            System.out.println(d);
        }
    }
    //do not modify
    public void displayWithdraws(){
        for(Withdraw w : withdraws){
            System.out.println(w);
        }
    }

    /** getters and setters **/
    public ArrayList<Deposit> getDeposits() {
        return deposits;
    }

    public void setDeposits(ArrayList<Deposit> deposits) {
        this.deposits = deposits;
    }

    public ArrayList<Withdraw> getWithdraws() {
        return withdraws;
    }

    public void setWithdraws(ArrayList<Withdraw> withdraws) {
        this.withdraws = withdraws;
    }
}
