package com.agilejerry.bowling.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.agilejerry.bowling.BowlingFrame;
import com.agilejerry.bowling.BowlingGame;
import com.agilejerry.bowling.TenthFrame;

import kata.bowling.BowlingTerm;

/**
 * @ClassName: GameTest
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Administrator
 * @date 2016年7月28日 上午10:22:08
 * @Copyright © 2016上海通善互联网金融信息服务有限公司
 */
public class GameTest {

	BowlingGame game;

	/**
	 * @method setUp(这里用一句话描述这个方法的作用)
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
		assertEquals(1, frame.getRoll(1).getPins());
		assertEquals(BowlingTerm.FRAME_RUNNING, frame.getState());
	}

	@Test
	public final void roll_2_ball_1_2() {
		game.prepare();
		BowlingFrame frame = game.getCurrentFrame();
		assertEquals(1, frame.getFrameNo());
		assertEquals(false, frame.isOver());
		game.roll(1);
		frame = game.getCurrentFrame();
		assertEquals(1, frame.getFrameNo());
		assertNotNull(frame);
		assertEquals(1, frame.getFrameNo());
		assertEquals(1, frame.getRoll(1).getPins());
		game.roll(2);
		assertEquals(2, frame.getRoll(2).getPins());
		assertEquals(BowlingTerm.FRAME_NORMALOVER, frame.getState());
		assertEquals(3, frame.getScore());
	}

	@Test
	public final void roll_3_ball_all_1() {
		game.prepare();
		game.roll(1);
		BowlingFrame firstframe = game.getCurrentFrame();
		assertNotNull(firstframe);
		assertEquals(1, firstframe.getRoll(1).getPins());
		assertEquals(BowlingTerm.FRAME_RUNNING, firstframe.getState());
		game.roll(1);
		assertEquals(1, firstframe.getRoll(2).getPins());
		assertEquals(BowlingTerm.FRAME_NORMALOVER, firstframe.getState());
		assertEquals(2, firstframe.getScore());
		game.roll(1);
		BowlingFrame secondframe = game.getCurrentFrame();
		assertEquals(secondframe, firstframe.getNextFrame());
		assertEquals(firstframe, secondframe.previousFrame());
		assertEquals(BowlingTerm.FRAME_RUNNING, secondframe.getState());
		assertEquals(2, firstframe.getScore());
		assertEquals(BowlingTerm.BLANK, secondframe.getScore());
	}

	@Test
	public final void roll_4_ball_all_1() {
		game.prepare();
		rollBall(4, 1);
		BowlingFrame frame1 = game.getFrame(1);
		BowlingFrame frame2 = game.getCurrentFrame();
		assertEquals(4, frame2.getScore());
		assertEquals(2, frame1.getScore());

	}

	private void rollBall(int times, int pins) {
		for (int i = 0; i < times; i++) {
			game.roll(pins);
		}
	}

	@Test
	public final void roll_5_ball_all_5() {
		game.prepare();
		rollBall(2, 5);
		BowlingFrame frame1 = game.getCurrentFrame();
		assertEquals(1, frame1.getFrameNo());
		assertEquals(true, frame1.isOver());
		assertEquals(BowlingTerm.SLASH_SQARE, frame1.getState());
		assertEquals(BowlingTerm.BLANK, frame1.getScore());
		rollBall(1, 5);
		BowlingFrame frame2 = game.getCurrentFrame();
		assertEquals(15, frame1.getScore());
		rollBall(2, 5);

		assertEquals(30, frame2.getScore());

	}

	@Test
	public void roll_21_ball_all_5() {
		game.prepare();
		rollBall(21, 5);
		BowlingFrame frame2 = game.getFrame(2);
		assertEquals(30, frame2.getScore());
		BowlingFrame frame5 = game.getFrame(5);
		assertEquals(75, frame5.getScore());
		BowlingFrame frame10 = game.getFrame(10);
		assertEquals(150, frame10.getScore());
	}

	@Test
	public void check_tenthFrame() {
		game.prepare();
		BowlingFrame frame10 = game.getFrame(10);
		System.out.println(frame10.getClass().getName());
		assertTrue(frame10 instanceof TenthFrame);
	}

	@Test
	public void roll_3_ball_all_10() {
		game.prepare();
		rollBall(3, 10);
		BowlingFrame frame1 = game.getFrame(1);
		assertEquals(30, frame1.getScore());
	}

	@Test
	public void roll_12_ball_all_10() {
		game.prepare();
		rollBall(12, 10);
		BowlingFrame frame10 = game.getFrame(10);
		assertEquals(true, frame10.isOver());
		BowlingFrame frame8 = game.getFrame(8);
		assertEquals(240, frame8.getScore());
		BowlingFrame frame9 = game.getFrame(9);
		assertEquals(270, frame9.getScore());
		assertEquals(300, frame10.getScore());
	}

	@Test
	public void roll_11_ball_all_10() {
		game.prepare();
		rollBall(10, 10);
		BowlingFrame frame10 = game.getFrame(10);
		assertEquals(false, frame10.isOver());
		BowlingFrame frame8 = game.getFrame(8);
		assertEquals(240, frame8.getScore());
		BowlingFrame frame9 = game.getFrame(9);
		assertEquals(BowlingTerm.BLANK, frame9.getScore());
		assertEquals(BowlingTerm.BLANK, frame10.getScore());
		rollBall(1, 10);
		assertEquals(272, frame9.getScore());
	}

	@Test
	public void roll_10_ball_all_10_then_2_6() {
		game.prepare();
		rollBall(10, 10);
		BowlingFrame frame10 = game.getFrame(10);
		assertEquals(false, frame10.isOver());
		BowlingFrame frame8 = game.getFrame(8);
		assertEquals(240, frame8.getScore());
		BowlingFrame frame9 = game.getFrame(9);
		assertEquals(BowlingTerm.BLANK, frame9.getScore());
		assertEquals(BowlingTerm.BLANK, frame10.getScore());
		rollBall(2, 6);
		assertEquals(266, frame9.getScore());
		assertEquals(BowlingTerm.BLANK, frame10.getScore());

	}

	@Test
	public void roll_10_ball_all_6() {
		game.prepare();
		rollBall(10, 6);
		BowlingFrame frame1 = game.getFrame(1);
		BowlingFrame frame3 = game.getFrame(3);
		assertEquals(false, frame1.isOver());
		assertEquals(BowlingTerm.BLANK, frame1.getScore());
		assertEquals(BowlingTerm.BLANK, frame3.getScore());

	}

	@Test
	public void roll_realsimulate1() {
		game.prepare();
		rollBall(1, 6);
		BowlingFrame frame = game.getCurrentFrame();
		assertEquals(false, frame.isOver());
		assertEquals(6, frame.getRoll(1).getPins());
		assertEquals(BowlingTerm.BLANK, frame.getScore());
		game.roll(4);
		assertEquals(true, frame.isOver());
		assertEquals(1, frame.getFrameNo());
		assertEquals(BowlingTerm.BLANK, frame.getScore());
		game.roll(10);
		assertEquals(1, frame.getFrameNo());
		assertEquals(20, frame.getScore());
		rollBall(5, 10);
		frame = game.getCurrentFrame();
		assertEquals(true, frame.isOver());
		assertEquals(7, frame.getFrameNo());
		assertEquals(BowlingTerm.BLANK, frame.getScore());
		rollBall(6, 5);
		BowlingFrame frame2 = game.getFrame(2);
		assertEquals(50, frame2.getScore());
		BowlingFrame frame3 = game.getFrame(3);
		assertEquals(80, frame3.getScore());
		BowlingFrame frame6 = game.getFrame(6);
		assertEquals(165, frame6.getScore());
		BowlingFrame frame7 = game.getFrame(7);
		assertEquals(185, frame7.getScore());

		assertEquals(185, frame.getScore());

		frame = game.getCurrentFrame();
		assertEquals(false, frame.isOver());
		assertEquals(10, frame.getFrameNo());
		game.roll(6);
		assertEquals(231, frame.getScore());
	}

	@Test
	public void roll_20_ball_all_1() {
		game.prepare();
		rollBall(20, 1);
		BowlingFrame frame1 = game.getFrame(1);
		assertEquals(true, frame1.isOver());

		assertEquals(1, frame1.getFrameNo());

		BowlingFrame frame = game.getCurrentFrame();
		assertEquals(true, frame.isOver());

		assertEquals(20, frame.getScore());

	}
}
