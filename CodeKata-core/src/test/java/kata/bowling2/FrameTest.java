package kata.bowling2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import kata.bowling.BowlingTerm;

public class FrameTest {
	BowlingFrame frame;
	BowlingGame game;
	@Before
	public void setUp() throws Exception {
		game = new BowlingGame();
		frame = game.newFrame();
		assertNotNull(frame);
	}

	@Test
	public final void frame_roll_1ball_1() {
		frame.roll(1);
		assertEquals(1,frame.getFirstScore());
		assertEquals(BowlingTerm.BLANK,frame.getSecondScore());
	}
	
	@Test
	public final void frame_roll_1ball_2() {
		frame.roll(2);
		assertEquals(2,frame.getFirstScore());
	}

	@Test
	public final void frame_roll_2ball_both1() {
		frame.roll(1);
		frame.roll(1);
		assertEquals(1,frame.getFirstScore());
		assertEquals(1,frame.getSecondScore());
		assertEquals(true,frame.isOver());
	}
}
