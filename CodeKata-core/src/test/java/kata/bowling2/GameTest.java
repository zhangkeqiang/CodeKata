package kata.bowling2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import kata.bowling.BowlingTerm;
import kata.testassist.BaseTest;

/**
 * @ClassName: GameTest
 * @date 2016年7月24日 上午9:12:37
 */
public class GameTest extends BaseTest{
	BowlingGame game;

	/**
	 * @method setUp(这里用一句话描述这个方法的作用)
	 * @return void
	 * @author Administrator
	 * @date 2016年7月24日 上午9:12:37
	 */
	@Before
	public void setUp() throws Exception {
		game = new BowlingGame();
	}

	@Test
	public final void firstFrame_2ball_both1() {
		game.roll(1);
		BowlingFrame frame = game.getCurrentFrame();
		assertNotNull(frame);
		assertEquals(1, frame.getFirstScore());
		assertEquals(BowlingTerm.BLANK, frame.getSecondScore());
		game.roll(1);
		assertEquals(1, frame.getFirstScore());
		assertEquals(1, frame.getSecondScore());
		assertEquals(2, frame.getTotalScore());
	}

	@Test
	public final void firstFrame_4ball_all1() {
		rollsometimes(3, 1);
		BowlingFrame frame = game.getCurrentFrame();
		assertNotNull(frame);
		assertEquals(2, frame.getNo());
		assertEquals(1, frame.getFirstScore());
		assertEquals(BowlingTerm.BLANK, frame.getSecondScore());
		game.roll(1);
		assertEquals(1, frame.getFirstScore());
		assertEquals(1, frame.getSecondScore());
		assertEquals(2, frame.getTotalScore());
		assertEquals(true, frame.isOver());

	}

	@Test
	public final void roll_3ball_both10() {
		game.roll(10);
		BowlingFrame frame = game.getCurrentFrame();
		assertNotNull(frame);
		assertEquals(10, frame.getFirstScore());
		assertEquals(BowlingTerm.BLANK, frame.getSecondScore());
		assertEquals(BowlingTerm.X_STRIKE, frame.getTotalScore());
		assertEquals(true, frame.isOver());
		game.roll(10);
		frame = game.getCurrentFrame();
		assertEquals(10, frame.getFirstScore());
		assertEquals(BowlingTerm.BLANK, frame.getSecondScore());
		assertEquals(BowlingTerm.X_STRIKE, frame.getTotalScore());
		frame = game.getFrame(1);
		assertEquals(10, frame.getFirstScore());
		assertEquals(BowlingTerm.BLANK, frame.getSecondScore());
		assertEquals(BowlingTerm.X_STRIKE, frame.getTotalScore());
		game.roll(10);
		frame = game.getCurrentFrame();
		assertEquals(10, frame.getFirstScore());
		assertEquals(BowlingTerm.BLANK, frame.getSecondScore());
		assertEquals(BowlingTerm.X_STRIKE, frame.getTotalScore());
		frame = game.getFrame(1);
		assertEquals(10, frame.getFirstScore());
		assertEquals(BowlingTerm.BLANK, frame.getSecondScore());
		assertEquals(30, frame.getTotalScore());

	}

	@Test
	public final void roll_3ball_both5() {
		game.roll(5);
		BowlingFrame frame = game.getCurrentFrame();
		assertNotNull(frame);
		assertEquals(1, frame.getNo());
		assertEquals(5, frame.getFirstScore());
		assertEquals(BowlingTerm.BLANK, frame.getSecondScore());
		assertEquals(BowlingTerm.BLANK, frame.getTotalScore());
		assertEquals(false, frame.isOver());
		assertEquals(BowlingTerm.FRAME_RUNNING, frame.getState());
		game.roll(5);
		frame = game.getFrame(1);
		assertEquals(1, frame.getNo());
		assertEquals(5, frame.getFirstScore());
		assertEquals(5, frame.getSecondScore());
		assertEquals(BowlingTerm.SLASH_SQARE, frame.getState());
		assertEquals(BowlingTerm.SLASH_SQARE, frame.getTotalScore());
		frame = game.getFrame(1);
		assertEquals(5, frame.getFirstScore());
		assertEquals(5, frame.getSecondScore());
		assertEquals(BowlingTerm.SLASH_SQARE, frame.getTotalScore());
		game.roll(5);
		frame = game.getCurrentFrame();
		assertEquals(5, frame.getFirstScore());
		assertEquals(BowlingTerm.BLANK, frame.getSecondScore());
		assertEquals(BowlingTerm.BLANK, frame.getTotalScore());
		frame = game.getFrame(1);
		assertEquals(5, frame.getFirstScore());
		assertEquals(5, frame.getSecondScore());
		assertEquals(15, frame.getTotalScore());

	}

	@Test
	public final void roll_3ball_10_5_5() {
		game.roll(10);
		BowlingFrame frame = game.getCurrentFrame();
		assertNotNull(frame);
		assertEquals(1, frame.getNo());
		assertEquals(10, frame.getFirstScore());
		assertEquals(BowlingTerm.BLANK, frame.getSecondScore());
		assertEquals(BowlingTerm.X_STRIKE, frame.getTotalScore());
		assertEquals(true, frame.isOver());
		assertEquals(BowlingTerm.X_STRIKE, frame.getState());
		game.roll(5);
		frame = game.getCurrentFrame();
		assertEquals(2, frame.getNo());
		assertEquals(5, frame.getFirstScore());
		assertEquals(BowlingTerm.BLANK, frame.getSecondScore());
		assertEquals(BowlingTerm.FRAME_RUNNING, frame.getState());
		assertEquals(BowlingTerm.BLANK, frame.getTotalScore());
		frame = game.getFrame(1);
		assertEquals(10, frame.getFirstScore());
		assertEquals(BowlingTerm.BLANK, frame.getSecondScore());
		assertEquals(BowlingTerm.X_STRIKE, frame.getTotalScore());
		game.roll(5);
		frame = game.getCurrentFrame();
		assertEquals(5, frame.getFirstScore());
		assertEquals(5, frame.getSecondScore());
		assertEquals(BowlingTerm.SLASH_SQARE, frame.getTotalScore());
		frame = game.getFrame(1);
		assertEquals(10, frame.getFirstScore());
		assertEquals(BowlingTerm.BLANK, frame.getSecondScore());
		assertEquals(20, frame.getTotalScore());

	}

	@Test
	public final void roll_12ball_all10() {
		rollsometimes(4, 10);
		BowlingFrame frame = game.getCurrentFrame();
		assertEquals(10, frame.getFirstScore());
		assertEquals(BowlingTerm.BLANK, frame.getSecondScore());
		assertEquals(BowlingTerm.X_STRIKE, frame.getTotalScore());
		frame = game.getFrame(1);
		assertEquals(10, frame.getFirstScore());
		assertEquals(BowlingTerm.BLANK, frame.getSecondScore());
		assertEquals(30, frame.getTotalScore());
		rollsometimes(5, 10);
		frame = game.getCurrentFrame();
		assertEquals(10, frame.getFirstScore());
		assertEquals(BowlingTerm.BLANK, frame.getSecondScore());
		assertEquals(BowlingTerm.X_STRIKE, frame.getTotalScore());
		frame = game.getFrame(7);
		assertEquals(10, frame.getFirstScore());
		assertEquals(BowlingTerm.BLANK, frame.getSecondScore());
		assertEquals(30, frame.getTotalScore());
		frame = game.getFrame(8);
		assertEquals(10, frame.getFirstScore());
		assertEquals(BowlingTerm.BLANK, frame.getSecondScore());
		assertEquals(BowlingTerm.X_STRIKE, frame.getTotalScore());
		// the Tenth boll
		game.roll(10);
		frame = game.getCurrentFrame();
		assertEquals(10, frame.getFirstScore());
		assertEquals(BowlingTerm.BLANK, frame.getSecondScore());
		assertEquals(BowlingTerm.X_STRIKE, frame.getTotalScore());
		
		frame = game.getFrame(8);
		assertEquals(10, frame.getFirstScore());
		assertEquals(BowlingTerm.BLANK, frame.getSecondScore());
		assertEquals(30, frame.getTotalScore());
		// the 11th boll
		game.roll(10);
		frame = game.getCurrentFrame();
		assertEquals(10, frame.getNo());
		assertEquals(10, frame.getFirstScore());
		assertEquals(10, frame.getSecondScore());
		
		frame = game.getFrame(9);
		assertEquals(10, frame.getFirstScore());
		assertEquals(BowlingTerm.BLANK, frame.getSecondScore());
		assertEquals(30, frame.getTotalScore());
		// the 12th boll
		game.roll(10);
		frame = game.getCurrentFrame();
		assertEquals(10, frame.getNo());
		assertEquals(10, frame.getFirstScore());
		assertEquals(10, frame.getSecondScore());
		assertEquals(10, frame.getRollScore(3));		
		assertEquals(30, frame.getTotalScore());
		assertEquals(300, game.getTotalScore());

	}

	@Test
	public final void roll_20ball_all1(){
		rollsometimes(20,1);
		BowlingFrame frame = game.getCurrentFrame();
		assertEquals(1, frame.getFirstScore());
		assertEquals(1, frame.getSecondScore());
		assertEquals(2, frame.getTotalScore());
		for(int i = 0; i < 10; i++){
			logger.warn("FrameNo" + (i+1) + game.getFrame(i+1).getTotalScore());
		}
		assertEquals(20, game.getTotalScore());
	}
	private void rollsometimes(int times, int pins) {
		for (int i = 0; i < times; i++) {
			game.roll(pins);
		}
	}
}
