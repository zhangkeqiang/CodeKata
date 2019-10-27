package kata.oo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AmericanBlackDuckTest {

	AmericanBlackDuck duck = new AmericanBlackDuck();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

    @Test
    public void testDuck() {
        assertNotNull(duck);
    }

    @Test
    public void testFly() {
        int m = 100;
        assertFalse(duck.fly(m));
    }

    @Test
    public void testCountFeet() {
    	assertEquals(2, duck.countFeet());
    }
    
    @Test
    public void testWalk() {
    	int m = 10;
    	assertTrue(duck.walk(m));
    	assertEquals(m,duck.getDistance());
    }
    
    @Test 
    public void testgetURL() {
    	String url = "http://www.wildfowl-photography.co.uk/wildfowl/american-black-duck.htm";
		assertEquals(url , duck.getURL());
    }

}
