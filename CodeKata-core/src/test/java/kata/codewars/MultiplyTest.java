package kata.codewars;

import static org.junit.Assert.*;

import org.junit.Test;

public class MultiplyTest {

	@Test
	public final void testMultiply() {
		double dbExpected = 19.1475;
		assertEquals(dbExpected, Multiply.multiply(3.45, 5.55),0.0001);
	}

}
