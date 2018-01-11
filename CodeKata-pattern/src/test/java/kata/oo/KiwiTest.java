package kata.oo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class KiwiTest {


    Kiwi bird = new Kiwi();
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testCountWings() {
        assertEquals(0, bird.countWings());
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
}
