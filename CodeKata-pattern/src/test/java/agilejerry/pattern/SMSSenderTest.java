package agilejerry.pattern;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

public class SMSSenderTest extends SMSSender {
	protected Logger logger = LogManager.getLogger();
	SMSSender sender;

	@Before
	public void setUp() throws Exception {
		sender = this;
	}

	@Test
	public void testsendVerifyCode() {
		this.sendVerifyCode("13311456789");
	}

	@Test
	public void testIsInCodeList() {
		String sPhone = "123455666666";
		String code = "666";
		assertTrue(sender.isInCodeList(sPhone, code));
		assertEquals(1, sender.verifyCode(sPhone, code));
	}

	@Test
	public void testIsInCodeList2() {
		String sPhone = null;
		String code = "666";
		assertFalse(sender.isInCodeList(sPhone, code));
		assertEquals(0, sender.verifyCode(sPhone, code));
	}

	@Test
	public void testIsInCodeList3() {
		String sPhone = "123455661234";
		String code = "666";
		assertFalse(sender.isInCodeList(sPhone, code));
		assertEquals(0, sender.verifyCode(sPhone, code));
	}

	@Override
	public void send(String sPhone, String string2) {
		// super's abstract method is needed
		logger.info("Send code to " + sPhone);
	}

}
