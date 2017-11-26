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

}
