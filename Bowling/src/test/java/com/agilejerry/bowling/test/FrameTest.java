package com.agilejerry.bowling.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.agilejerry.bowling.BowlingFrame;
import com.agilejerry.bowling.BowlingRoll;

import kata.bowling.BowlingTerm;

/**@ClassName: FrameTest
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Administrator 
 * @date 2016年7月25日 下午11:20:28 
 * @Copyright © 2016上海通善互联网金融信息服务有限公司
 */
public class FrameTest {

	/**@method setUp(这里用一句话描述这个方法的作用)
	 * @return void
	 * @author Administrator
	 * @date 2016年7月25日 下午11:20:28
	*/
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public final void newFrame() {
		BowlingFrame frame = new BowlingFrame(1);
		assertNotNull(frame);
		BowlingFrame nextframe = frame.getNextFrame();
		assertNull(nextframe);
		
	}
	
	@Test
	public final void roll_1_ball_1() {
		BowlingFrame frame = new BowlingFrame(1);		
		BowlingRoll roll = frame.getRoll(1);
		//roll(1);
		assertNotNull(roll);
		assertEquals(10, roll.getMaxPins());
		roll = frame.roll(1);
		assertEquals(1, roll.getPins());
		assertEquals(roll, frame.getRoll(1));
		assertEquals(BowlingTerm.FRAME_RUNNING, frame.getState());
	}
	
	@Test
	public void roll_1_ball_10()
	{
		BowlingFrame frame = new BowlingFrame(1);		
		BowlingRoll roll = frame.getRoll(1);
		assertNotNull(roll);
		assertEquals(10, roll.getMaxPins());
		roll = frame.roll(10);
		assertEquals(10, roll.getPins());
		assertEquals(roll, frame.getRoll(1));
		assertEquals(BowlingTerm.X_STRIKE, frame.getState());
		
	}
	
	@Test
	public final void roll_2_ball_Not_Sqare() {
		BowlingFrame frame = new BowlingFrame(1);		
		BowlingRoll roll1 = frame.getRoll(1);
		assertNotNull(roll1);
		assertEquals(10, roll1.getMaxPins());
		roll1 = frame.roll(1);
		assertEquals(1, roll1.getPins());
		assertEquals(roll1, frame.getRoll(1));
		assertEquals(BowlingTerm.FRAME_RUNNING, frame.getState());
		BowlingRoll roll2 = frame.getRoll(2);
		assertNotNull(roll2);
		assertEquals(9, roll2.getMaxPins());
		frame.roll(1);
		assertEquals(1, roll2.getPins());
		assertEquals(roll2, frame.getRoll(2));
		assertEquals(BowlingTerm.FRAME_NORMALOVER, frame.getState());
	}

	@Test
	public final void roll_2_ball_got_Sqare() {
		BowlingFrame frame = new BowlingFrame(1);		
		BowlingRoll roll1 = frame.getRoll(1);
		assertNotNull(roll1);
		assertEquals(10, roll1.getMaxPins());
		roll1 = frame.roll(1);
		assertEquals(1, roll1.getPins());
		assertEquals(roll1, frame.getRoll(1));
		assertEquals(BowlingTerm.FRAME_RUNNING, frame.getState());
		BowlingRoll roll2 = frame.getRoll(2);
		assertNotNull(roll2);
		assertEquals(9, roll2.getMaxPins());
		frame.roll(9);
		assertEquals(9, roll2.getPins());
		assertEquals(roll2, frame.getRoll(2));
		assertEquals(BowlingTerm.SLASH_SQARE, frame.getState());
	}


}
