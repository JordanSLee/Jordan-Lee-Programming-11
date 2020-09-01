import org.junit.Before;
import org.junit.Test;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WithdrawTester {
    /** Withdraw class Tests **/
    Withdraw test;
    String testing = "";

    @Before
    public void setup(){
         test = new Withdraw(300.0, new Date(2020,10,13,18,6,43),Customer.CHECKING);
    }

    @Test
    public void testWithdrawToString(){
        // print length of test
        System.out.println(testing.length());
        // check array list is empty
        assertTrue(testing.isEmpty());
        // test toString method by assigning variable "test"
        testing = test.toString();
        System.out.println(test);
        //test that testing isn't empty
        assertFalse(testing.isEmpty());
    }
}
