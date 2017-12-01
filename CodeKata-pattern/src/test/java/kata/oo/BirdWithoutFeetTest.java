package kata.oo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BirdWithoutFeetTest {

	BirdWithoutFeet bird = new BirdWithoutFeet();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testKiwi() {
	       assertNotNull(bird);
	}

    @Test
    public void testFly() {
        int m = 100;
        assertTrue(bird.fly(m));
    }

    @Test
    public void testCountFeet() {
    	assertEquals(0, bird.countFeet());
    }
    
    @Test
    public void testWalk() {
    	int m = 10;
    	assertFalse(bird.walk(m));
    	assertEquals(0,bird.getDistance());
    }
}
