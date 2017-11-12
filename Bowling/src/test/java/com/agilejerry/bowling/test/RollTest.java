package com.agilejerry.bowling.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.agilejerry.bowling.BowlingRoll;

public class RollTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public final void newRollandBasic() {
		BowlingRoll roll = new BowlingRoll(10);
		assertNotNull(roll);
		assertEquals(10, roll.getMaxPins());
		
	}

}
