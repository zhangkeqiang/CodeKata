package kata.bowling;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BowlingFrameTest {
	Frame frame;
	@Before
	public void setUp() throws Exception {
		frame = new Frame(1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void newFirstFrame_scores_are_all_zero() {
		assertEquals(1,frame.getNo());
		assertEquals(-1,frame.getFirstScore());
		assertEquals(-1,frame.getSecondScore());	
		assertEquals(-1,frame.getTotalScore());	
	}
	
	@Test
	public final void firstFrame_deliver_0_ball_twice(){
		frame.deliver(1,0);
		assertEquals(0,frame.getFirstScore());
		assertEquals(-1,frame.getSecondScore());
		assertEquals(-1,frame.getTotalScore());	
		frame.deliver(2,0);
		assertEquals(0,frame.getFirstScore());
		assertEquals(0,frame.getSecondScore());
		assertEquals(0,frame.getTotalScore());
	}
	
	@Test
	public final void firstFrame_deliver_1_ball_twice(){
		frame.deliver(1,1);
		assertEquals(1,frame.getFirstScore());
		assertEquals(-1,frame.getSecondScore());
		assertEquals(-1,frame.getTotalScore());	
		frame.deliver(2,1);
		assertEquals(1,frame.getFirstScore());
		assertEquals(1,frame.getSecondScore());
		assertEquals(2,frame.getTotalScore());
	}
	
	@Test
	public final void firstFrame_deliver_strike_ball(){
		frame.deliver(1,10);
		assertEquals(10,frame.getFirstScore());
		assertEquals(-1,frame.getSecondScore());
		assertEquals(-2,frame.getTotalScore());	
	}
	
	
	@Test
	public final void firstFrame_deliver_spare_ball2(){
		frame.deliver(1,5);
		assertEquals(5,frame.getFirstScore());
		assertEquals(-1,frame.getSecondScore());
		assertEquals(-1,frame.getTotalScore());	
		frame.deliver(2,5);
		assertEquals(5,frame.getFirstScore());
		assertEquals(5,frame.getSecondScore());
		assertEquals(-3,frame.getTotalScore());	
	}
	
	

	
}
