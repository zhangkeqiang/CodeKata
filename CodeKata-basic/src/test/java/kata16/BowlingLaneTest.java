package kata16;

import static org.junit.Assert.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;   

public class BowlingLaneTest {
	protected Logger logger = LogManager.getLogger();
	BowlingLane lane;
	@Before
	public void setUp() throws Exception {
		lane = new BowlingLane();
		
	}
	
	private void rollBall(int times, int pin) {
		for (int i = 0; i < times; i++) {
			lane.roll(pin);
		}
	}
	
	@Test
	public final void Roll12_10() {
		assertTrue(lane.startMatch(1, 1));
		rollBall(9,10);
		lane.roll(10);
		lane.roll(10);
		lane.roll(10);
		assertEquals(300,lane.getCurrentBowler().getCurrentGame().getScore());
	}
	
	@Test
	public final void Roll36_10_On_3_Bowlers() {
		assertTrue(lane.startMatch(1, 3));
		rollBall(36,10);
		assertEquals(300,lane.getCurrentBowler().getCurrentGame().getScore());
	}
	
	@Test
	public final void Roll60_1_On_3_Bowlers() {
		assertTrue(lane.startMatch(1, 3));
		rollBall(60,1);
		assertEquals(20,lane.getCurrentBowler().getCurrentGame().getScore());
	}
	
	@Test
	public final void Roll_10_For_9_Times_5_5_5() {
		assertTrue(lane.startMatch(1, 1));
		rollBall(9,10);
		rollBall(3,5);
		assertEquals(270,lane.getCurrentBowler().getCurrentGame().getScore());
	}
	
	@Test
	public final void Roll_5_For_21_Times() {
		assertTrue(lane.startMatch(1, 1));
		rollBall(21,5);
		assertEquals(150,lane.getCurrentBowler().getCurrentGame().getScore());
	}
	
	@Test
	public final void Strikes_message_show_Strike() {
		lane.roll(10);
		assertThat(lane.showTotalMessage(),containsString("not started"));
		assertTrue(lane.startMatch(1, 1));
		logger.info(lane.showTotalMessage());
		assertThat(lane.showTotalMessage(),containsString("Frame1"));
		lane.roll(10);
		logger.info(lane.showTotalMessage());
		assertThat(lane.showTotalMessage(),containsString("Strike!"));
		assertThat(lane.showTotalMessage(),containsString("Frame2"));
		assertThat(lane.showTotalMessage(),containsString("No.1"));
		lane.roll(10);
		assertThat(lane.showTotalMessage(),containsString("Double Strikes"));
		lane.roll(10);
		assertThat(lane.showTotalMessage(),containsString("10|30"));
	}

	@Test
	public final void Balls_NoStrike_NoSpare_score() {
		assertTrue(lane.startMatch(1, 1));
		logger.info(lane.showTotalMessage());
		lane.roll(1);
		assertThat(lane.showTotalMessage(),containsString("Frame1:1"));
		
		lane.roll(1);
		assertThat(lane.showTotalMessage(),containsString("Frame1:1,1|2"));
		lane.roll(1);
	}
	
	@Test
	public final void Balls_Spare_score() {
		assertTrue(lane.startMatch(1, 1));
		logger.info(lane.showTotalMessage());
		lane.roll(5);
		lane.roll(5);
		assertThat(lane.showTotalMessage(),containsString("Frame1:5,5|SPARE"));
		lane.roll(1);
		assertThat(lane.showTotalMessage(),containsString("Frame1:5,5|11"));
	}
	
	@Test
	public final void gutterBall_message_show_gutter() {
		assertTrue(lane.startMatch(1, 1));
		logger.info(lane.showTotalMessage());
		lane.roll(0);
		logger.info(lane.showTotalMessage());
		assertThat(lane.showTotalMessage(),containsString("Gutter Ball!") );
		assertThat(lane.showTotalMessage(),containsString("Frame1"));
	}
	
	@Test
	public final void two_Bowler_gutterBall_message_show_turns_change() {
		assertTrue(lane.startMatch(1, 2));
		logger.info(lane.showTotalMessage());
		assertThat(lane.showTotalMessage(),containsString("No.1"));
		lane.roll(10);
		assertEquals(2, lane.getCurrentBowlerNum());
		BowlingFrame frame = lane.getCurrentBowler().getCurrentGame().getCurrentFrame();
		assertEquals(1, frame.getCurrentBlockNum());
		assertEquals("INIT", frame.getState());
		assertThat(lane.showTotalMessage(),containsString("Strike") );
		assertThat(lane.showTotalMessage(),containsString("No.2"));
		assertThat(lane.showTotalMessage(),containsString("Frame1"));
		
		lane.roll(10);
		logger.info(lane.showTotalMessage());
		assertThat(lane.showTotalMessage(),containsString("Strike") );
		assertThat(lane.showTotalMessage(),containsString("No.1"));
		assertThat(lane.showTotalMessage(),containsString("Frame2"));
		
		lane.roll(0);
		logger.info(lane.showTotalMessage());
		assertThat(lane.showTotalMessage(),containsString("Gutter") );
		assertThat(lane.showTotalMessage(),containsString("No.1"));
		assertThat(lane.showTotalMessage(),containsString("Frame2"));
		
		lane.roll(0);
		logger.info(lane.showTotalMessage());
		assertThat(lane.showTotalMessage(),containsString("Gutter") );
		assertThat(lane.showTotalMessage(),containsString("No.2"));
		assertThat(lane.showTotalMessage(),containsString("Frame2"));
		
		lane.roll(0);
		logger.info(lane.showTotalMessage());
		assertThat(lane.showTotalMessage(),containsString("Gutter") );
		assertThat(lane.showTotalMessage(),containsString("No.2"));
		assertThat(lane.showTotalMessage(),containsString("Frame2"));
		
		lane.roll(0);
		logger.info(lane.showTotalMessage());
		assertThat(lane.showTotalMessage(),containsString("Gutter") );
		assertThat(lane.showTotalMessage(),containsString("No.1"));
		assertThat(lane.showTotalMessage(),containsString("Frame3"));
	}
	
	

	
}
