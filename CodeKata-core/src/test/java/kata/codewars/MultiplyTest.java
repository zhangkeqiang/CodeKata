package kata.codewars;

import static org.junit.Assert.*;

import org.junit.Test;

public class MultiplyTest {

	@Test
	public final void testMultiply() {
		assertEquals(19.1475,Multiply.multiply(3.45, 5.55),0.0001);
	}

}
