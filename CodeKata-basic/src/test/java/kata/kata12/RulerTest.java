package kata.kata12;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RulerTest {
	private static final double SMALLDELTA = 0.0000001;
	Ruler ruler;

	@Before
	public void setUp() {
		ruler = new Ruler();
	}

	@Test
	public void testGetInch() {
		ruler.setFeet(4);
		assertEquals(48, ruler.getInch(), SMALLDELTA);
	}

	@Test
	public void testGetFeet() {
		ruler.setInch(96);
		assertEquals(8, ruler.getFeet(), SMALLDELTA);
		assertEquals(96, ruler.getInch(), SMALLDELTA);

		ruler.setInch(97);
		assertEquals((double) 97 / 12, ruler.getFeet(), SMALLDELTA);
	}

	@Test
	public void testGetYard() {
		ruler.setInch(96);
		assertEquals(8, ruler.getFeet(), SMALLDELTA);
		assertEquals(96, ruler.getInch(), SMALLDELTA);
		assertEquals((double) 8 / 3, ruler.getYard(), SMALLDELTA);
	}

	@Test
	public void testSetGetYard() {
		ruler.setYard(3.5);
		assertEquals(10.5, ruler.getFeet(), SMALLDELTA);
		assertEquals(126, ruler.getInch(), SMALLDELTA);
		assertEquals(3.5, ruler.getYard(), SMALLDELTA);
	}

	@Test
	public void testSetGetYard2() {
		ruler.setYard(4.5);
		assertEquals(13.5, ruler.getFeet(), SMALLDELTA);
		assertEquals(162, ruler.getInch(), SMALLDELTA);
		assertEquals(4.5, ruler.getYard(), SMALLDELTA);
	}

	@Test
	public void testSetGetYard3() {
		ruler.setYard(4.5);
		assertEquals(13.5, ruler.getFeet(), SMALLDELTA);
		assertEquals(162, ruler.getInch(), SMALLDELTA);
		assertEquals(4.5, ruler.getYard(), SMALLDELTA);
	}
}
