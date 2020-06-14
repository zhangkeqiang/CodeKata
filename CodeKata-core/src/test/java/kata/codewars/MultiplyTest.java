package kata.codewars;

import static org.junit.Assert.*;

import org.junit.Test;

public class MultiplyTest {
	double delta = 0.000001;
	@Test
	public final void testMultiply() {
		double dbExpected = 19.1475;
		double actual = Multiply.multiply(3.45, 5.55);
		assertEquals(dbExpected, actual, delta);
	}

}
