package kata.kata12;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RulerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetInch() {
		Ruler ruler = new Ruler(4);
		assertEquals(48, ruler.getInch());
	}

	@Test 
	public void testGetFeet() {
		Ruler ruler = new Ruler(1);
		ruler.setInch(96);
		assertEquals(8, ruler.getFeet());
		assertEquals(96, ruler.getInch());
	}
	
	@Test 
	public void testGetYard() {
		Ruler ruler = new Ruler(1);
		ruler.setInch(96);
		assertEquals(8, ruler.getFeet());
		assertEquals(96, ruler.getInch());
		assertEquals((double)8/3, ruler.getYard(), 0.0000001);
	}
	
}
