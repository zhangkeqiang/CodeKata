package com.agilejerry.bowling.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.agilejerry.bowling.BowlingRoll;
import com.agilejerry.bowling.TenthFrame;

public class TenthFrameTest {

	TenthFrame frame;
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public final void roll_5_3() {
		frame =  new TenthFrame(10);
		BowlingRoll roll1 = frame.roll(5);
		BowlingRoll roll2 = frame.roll(5);
		BowlingRoll roll3 = frame.roll(5);
		assertNotNull(roll3);
		
	}

	
}
