package kata1;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaskifyTest {
	Maskify mask = new Maskify();

	@Test
	public final void testHideLast4Chars() {
		assertEquals("####SDDS", mask.hideLast4Chars("abcdSDDS"));
	}
	
	@Test
	public final void testHideLast4CharsforShortString() {
		
		assertEquals("DDS", mask.hideLast4Chars("DDS"));
	}

}
