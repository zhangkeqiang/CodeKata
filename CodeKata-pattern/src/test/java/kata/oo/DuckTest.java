package kata.oo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DuckTest {

    Bird bird = new Duck();

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testDuck() {
        assertNotNull(bird);
    }

    @Test
    public void testFly() {
        int m = 100;
        assertFalse(bird.fly(m));
    }

    @Test
    public void testCountFeet() {
    	assertEquals(2, bird.countFeet());
    }
    
    @Test
    public void testWalk() {
    	int m = 10;
    	assertTrue(bird.walk(m));
    	assertEquals(m,bird.getDistance());
    }
    
    @Test 
    public void testgetURL() {
    	String url = "http://www.wildfowl-photography.co.uk/identification/types-of-duck.htm";
		assertEquals(url , bird.getURL());
    }
    
}
