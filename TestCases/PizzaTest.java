import org.junit.Before;
import org.junit.Test;
import sample.Pizza;

import static org.junit.Assert.*;

public class PizzaTest {
    private Pizza testPizzaThere;
    private Pizza testPizzaNotThere;

    @Before
    public void setUp(){
        testPizzaThere = new Pizza("small",1,1.0d);
        testPizzaNotThere = new Pizza("",0,0.0d);
    }

    /** test size **/
    @Test
    public void testSizeThere(){
        //check size is already in set
        assertEquals("small", testPizzaThere.getSize());
        //empty size
        testPizzaThere.setSize("");
        //check the size isn't in the set
        assertTrue("Remove Size", testPizzaThere.getSize().equals(""));
    }
    @Test
    public void testSizeNotThere(){
        //check size is not already in set
        assertEquals("", testPizzaNotThere.getSize());
        //insert a size
        testPizzaThere.setSize("small");
        //check the size is in the set
        assertTrue("Input Size", testPizzaThere.getSize().equals("small"));
    }

    /** test type **/
    @Test
    public void testTypeNotThere(){
        //check type is already in set
        assertEquals(1, testPizzaThere.getType());
        //empty type
        testPizzaThere.setType(0);
        //check the type is in the set
        assertEquals(0, testPizzaThere.getType());
    }
    @Test
    public void testTypeThere(){
        //check type isn't already in set
        assertEquals(0,testPizzaNotThere.getType());
        //add size
        testPizzaNotThere.setType(2);
        //check type is in the set
        assertEquals(2,testPizzaNotThere.getType());
    }

    /** test cost **/
    @Test
    public void testCostNotThere(){
        //check cost is already in set
        assertEquals(1.0d, testPizzaThere.getCost(), 0.001);
        //empty cost
        testPizzaThere.setCost(0.0d);
        //check cost is removed
        assertEquals(0.0d, testPizzaThere.getCost(), 0.001);
    }
    @Test
    public void testCostThere(){
        //check cost is null
        assertEquals(0.0d, testPizzaNotThere.getCost(), 0.001);
        //add cost
        testPizzaNotThere.setCost(1.5d);
        //check cost is added
        assertEquals(1.5d, testPizzaNotThere.getCost(), 0.001);
    }
}
