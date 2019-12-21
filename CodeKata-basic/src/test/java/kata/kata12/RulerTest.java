package kata.kata12;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RulerTest {
	private static final double _0_0000001 = 0.0000001;
	Ruler ruler;

	@Before
	public void setUp() {
		ruler = new Ruler();
	}

	@Test
	public void testGetInch() {
		ruler.setFeet(4);
		assertEquals(ruler.getInch(), 48, _0_0000001);
	}

	@Test
	public void testGetFeet() {
		ruler.setInch(96);
		assertEquals(8, ruler.getFeet(), _0_0000001);
		assertEquals(96, ruler.getInch(), _0_0000001);

		ruler.setInch(97);
		assertEquals(ruler.getFeet(), (double) 97 / 12, _0_0000001);
	}

	@Test
	public void testGetYard() {
		ruler.setInch(96);
		assertEquals(8, ruler.getFeet(), _0_0000001);
		assertEquals(ruler.getInch(), 96, _0_0000001);
		assertEquals((double) 8 / 3, ruler.getYard(), _0_0000001);
	}

	@Test
	public void testSet_GetYard() {
		ruler.setYard(3.5);
		assertEquals(10.5, ruler.getFeet(), _0_0000001);
		assertEquals(126, ruler.getInch(), _0_0000001);
		assertEquals(3.5, ruler.getYard(), _0_0000001);
	}

}
