package kata.oo;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class WildGooseTest {

	WildGoose goose = new WildGoose();
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testWildGoose() {
		assertNotNull(goose);
	}

    @Test
    public void testFly() {
        int m = 100;
        assertTrue(goose.fly(m));
        assertEquals(m, goose.getFlyDistance());
        assertEquals(m, goose.getDistance());
    }

    @Test
    public void testCountFeet() {
    	assertEquals(2, goose.countFeet());
    }
}
