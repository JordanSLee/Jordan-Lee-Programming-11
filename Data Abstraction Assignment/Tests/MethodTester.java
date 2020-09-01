import org.junit.Before;
import org.junit.Test;
import java.util.Date;

import static org.junit.Assert.*;

public class MethodTester {
    /** Customer class tests **/
    Customer test;

    @Before
    public void setup(){
        test = new Customer("Riley",1753,400.0,300.0);
    }

    @Test
    public void customerDepositTest(){
        // check array list is empty
        assertEquals(test.getDeposits().size(),0);
        // deposit money to Checking acc.
        test.deposit(200.0, new Date(2020,2,10,20,35,40),Customer.CHECKING);
        // check if array list size ++
        assertEquals(test.getDeposits().size(),1);

        // deposit money to Savings acc.
        test.deposit(400.0, new Date(2020,3,16,24,13,2),Customer.SAVING);
        // check if array list size ++
        assertEquals(test.getDeposits().size(),2);
    }
    @Test
    public void customerWithdrawTest(){
        // check array list is empty
        assertEquals(test.getWithdraws().size(),0);
        // withdraw money from savings acc.
        test.withdraw(100.0, new Date(2020,5,19,12,50,9), Customer.CHECKING);
        // check if array list size ++
        assertEquals(test.getWithdraws().size(),1);

        // withdraw money from checking acc.
        test.withdraw(150.0, new Date(2020,6,3,20,40,1), Customer.SAVING);
        // check if array list size ++
        assertEquals(test.getWithdraws().size(),2);

        // check overdraft in checking acc.
        test.withdraw(500.0, new Date(2020,8,17,4,6,8),Customer.CHECKING);
        // check overdraft in savings acc.
        test.withdraw(500.0, new Date(2020,8,18,5,11,57),Customer.SAVING);
        // check array list size has not changed
        assertEquals(test.getWithdraws().size(),2);
    }
}
