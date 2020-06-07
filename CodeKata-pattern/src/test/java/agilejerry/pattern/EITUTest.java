package agilejerry.pattern;

import static org.junit.Assert.*;

import org.junit.Test;

public class EITUTest {

	@Test
	public final void testRun() {
		new EITU().run();
	}
	
	@Test
	public final void testCalc() {
		assertEquals(0,(new EITU()).calc());
	}

}
