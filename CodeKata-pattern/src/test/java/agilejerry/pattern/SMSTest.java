package agilejerry.pattern;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SMSTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCreateSMSSender() {
		SMSSender sender = SMSCenter.createSMSSender();
		assertNotNull(sender);
	}
	
	@Test
	public void testSMSSend() {
		SMSSender sender = SMSCenter.createSMSSender();
		assertNotNull(sender);
		sender.send("13311650327","SMSContents");
	}
	


}
