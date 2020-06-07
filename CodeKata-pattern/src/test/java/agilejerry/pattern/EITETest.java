package agilejerry.pattern;

import static org.junit.Assert.*;

import org.junit.Test;

public class EITETest {

	@Test
	public final void testRun() {
		EITE eite = new EITT2();
		EITContext context = EITContext.getInstance();
		eite.setContext(context);
		assertEquals(1505,eite.run());
		
	}

}
