package agilejerry.pattern;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import junit.framework.TestCase;

public class EITTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testRun2() {
		EITE eit = EITCommander.createEIT();
		assertEquals(503, eit.run());
	}
	
	public void testRun3() {
		EITE eit2 = EITCommander.createEIT();
		assertEquals(503, eit2.run());
		EITE eit = new EITT2();
		eit.setContext(EITCommander.getContext());
		assertEquals(1505, eit.run());
		eit.setContextI(5);
		//eit2 = EITCommander.createEIT();
		assertEquals(8, eit2.run());
		eit.setContextI(100);
		assertEquals(103, eit2.run());
	}

	public void testRun() {
		EITI eit = new EITIT();
		eit.run();
	}
	
	
	@Test
	public void testEITIConstant() {
		assertEquals(1001, EITI.III);
	}
	

}
