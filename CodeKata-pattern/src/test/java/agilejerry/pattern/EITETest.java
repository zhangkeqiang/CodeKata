package agilejerry.pattern;

import static org.junit.Assert.*;

import org.junit.Test;

public class EITETest {

	@Test
	public final void testRun() {
		EITE eite = new EITT2();
		EITContext context = EITContext.getInstance();
		assertEquals(500, context.getI());
		assertEquals(1505,eite.run());
		
	}

}
