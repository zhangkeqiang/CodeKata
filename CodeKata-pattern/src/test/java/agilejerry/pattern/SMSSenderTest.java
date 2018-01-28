package agilejerry.pattern;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SMSSenderTest extends SMSSender {
	
	SMSSender sender;
	@Before
	public void setUp() throws Exception {
		sender = this;
	}

	@Test
	public void testIsInCodeList() {
		String sPhone = "123455666666";
		String code = "666";
		assertTrue(sender.isInCodeList(sPhone, code));
	}

	@Test
	public void testIsInCodeList2() {
		String sPhone = null ;
		String code = "666";
		assertFalse(sender.isInCodeList(sPhone, code));
	}
	
	@Test
	public void testIsInCodeList3() {
		String sPhone = "123455661234";
		String code = "666";
		assertFalse(sender.isInCodeList(sPhone, code));
	}
	@Override
	public void send(String string, String string2) {
		
		
	}

}
