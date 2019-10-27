package kata.oo;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CompositedDuckTest {

    CompositedDuck duck;
    @Before
    public void setUp() throws Exception {
        duck = new CompositedDuck();
    }

    @Test
    public void testCompositedDuck() {
        assertNotNull(duck);
    }
    
    
    @Test
    public void check_how_many_wings(){
        assertEquals(2, duck.countWings());
    }
    
    @Test
    public void check_how_many_feet(){
        assertEquals(2, duck.countFeet());
    }
}
