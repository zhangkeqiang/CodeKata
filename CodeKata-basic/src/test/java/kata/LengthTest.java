package kata;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LengthTest {

	@Test
	public void testLength() {
		Length l1 = new Length(12,"INCH");
		Length l2 = new Length(1,"FEET");
		assertEquals(l1.getInch(), l2.getInch());
	}

}
