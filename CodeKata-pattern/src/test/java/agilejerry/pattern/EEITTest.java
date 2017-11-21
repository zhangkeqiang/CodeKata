package agilejerry.pattern;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EEITTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRun() {
		EITE eit = EITCommander.createEIT();
		eit.run();
	}
	@Test
	public void testRun2(){
		EITU eitu = new EITU();
		eitu.setEIT();
		eitu.run();
	}
}
