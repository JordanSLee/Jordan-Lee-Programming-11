import org.junit.Before;
import org.junit.Test;
import java.util.Date;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DepositTester {
    /** Deposit class Tests **/
    Deposit test;
    String testing = "";

    @Before
    public void setup(){
        test = new Deposit(300.0, new Date(2020,8,21,16,30,17),Customer.SAVING);
    }
    @Test
    public void testDepositToString(){
        // print legnth of test
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
