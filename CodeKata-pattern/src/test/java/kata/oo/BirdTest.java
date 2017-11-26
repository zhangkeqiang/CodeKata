package kata.oo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BirdTest {

    Bird bird;
    @Before
    public void setUp() throws Exception {
        bird = new Bird();
    }

    @Test
    public void testBirdFly() {
        assertNotNull(bird);
        assertTrue(bird.fly(1000));
    }

}
