package com.agilejerry.bowling.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.agilejerry.bowling.BowlingFrame;
import com.agilejerry.bowling.BowlingGame;

import kata.bowling.BowlingTerm;

/**@ClassName: GameTest
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Administrator 
 * @date 2016年7月28日 上午10:22:08 
 * @Copyright © 2016上海通善互联网金融信息服务有限公司
 */
public class GameTest {

	BowlingGame game;
	/**@method setUp(这里用一句话描述这个方法的作用)
	 * @return void
	 * @author Administrator
	 * @date 2016年7月28日 上午10:22:08
	*/
	@Before
	public void setUp() throws Exception {
		game = new BowlingGame();
	}

	@Test
	public final void roll_1_ball_1() {
		game.prepare();
		game.roll(1);
		BowlingFrame frame = game.getCurrentFrame();
		assertNotNull(frame);
		assertEquals(1, frame.getPins(1).getPins());
		assertEquals(BowlingTerm.FRAME_RUNNING, frame.getState());
	}
	
	@Test
	public final void roll_2_ball_1_2(){
		game.prepare();
		BowlingFrame frame = game.getCurrentFrame();
		assertEquals(1,frame.getFrameNo());
		assertEquals(false,frame.isOver());
		game.roll(1);
		frame = game.getCurrentFrame();
		assertEquals(1,frame.getFrameNo());
		assertNotNull(frame);
		assertEquals(1,frame.getFrameNo());
		assertEquals(1, frame.getPins(1).getPins());		
		game.roll(2);
		assertEquals(2, frame.getPins(2).getPins());	
		assertEquals(BowlingTerm.FRAME_NORMALOVER, frame.getState());
		assertEquals(3, frame.getScore());
	}
	
	@Test
	public final void roll_3_ball_all_1(){
		game.prepare();
		game.roll(1);
		BowlingFrame firstframe = game.getCurrentFrame();
		assertNotNull(firstframe);
		assertEquals(1, firstframe.getPins(1).getPins());
		assertEquals(BowlingTerm.FRAME_RUNNING, firstframe.getState());
		game.roll(1);
		assertEquals(1, firstframe.getPins(2).getPins());
		assertEquals(BowlingTerm.FRAME_NORMALOVER, firstframe.getState());
		assertEquals(2, firstframe.getScore());
		game.roll(1);
		BowlingFrame secondframe = game.getCurrentFrame();
		assertEquals(secondframe, firstframe.nextFrame());
		assertEquals(firstframe, secondframe.previousFrame());
		assertEquals(BowlingTerm.FRAME_RUNNING, secondframe.getState());
		assertEquals(2, firstframe.getScore());
		assertEquals(BowlingTerm.BLANK, secondframe.getScore());
	}

}
