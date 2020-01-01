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
	
	@Test
	public final void firstStrike_message_show_Strike() {
		lane.roll(10);
		assertThat(lane.showMessage(),containsString("not started"));
		assertTrue(lane.startMatch(1, 1));
		logger.info(lane.showMessage());
		assertThat(lane.showMessage(),containsString("Frame1"));
		lane.roll(10);
		logger.info(lane.showMessage());
		assertThat(lane.showMessage(),containsString("Strike!"));
		assertThat(lane.showMessage(),containsString("Frame2"));
		assertThat(lane.showMessage(),containsString("No.1"));
	}

	@Test
	public final void gutterBall_message_show_gutter() {
		assertTrue(lane.startMatch(1, 1));
		logger.info(lane.showMessage());
		lane.roll(0);
		logger.info(lane.showMessage());
		assertThat(lane.showMessage(),containsString("Gutter Ball!") );
		assertThat(lane.showMessage(),containsString("Frame1"));
	}
	
	@Test
	public final void two_Bowler_gutterBall_message_show_turns_change() {
		assertTrue(lane.startMatch(1, 2));
		logger.info(lane.showMessage());
		assertThat(lane.showMessage(),containsString("No.1"));
		lane.roll(10);
		logger.info(lane.showMessage());
		assertEquals(2, lane.getCurrentBowlerNum());
		BowlingFrame frame = lane.getCurrentBowler().getCurrentGame().getCurrentFrame();
		assertEquals(1, frame.getCurrentBlockNum());
		assertEquals("INIT", frame.getState());
		assertThat(lane.showMessage(),containsString("Strike") );
		assertThat(lane.showMessage(),containsString("No.2"));
		assertThat(lane.showMessage(),containsString("Frame1"));
		
		lane.roll(10);
		assertThat(lane.showMessage(),containsString("Strike") );
		//No.1 turn
		assertThat(lane.showMessage(),containsString("No.1"));
		assertThat(lane.showMessage(),containsString("Frame2"));
		
		lane.roll(0);
		assertThat(lane.showMessage(),containsString("Gutter") );
		assertThat(lane.showMessage(),containsString("No.1"));
		assertThat(lane.showMessage(),containsString("Frame2"));
		
		lane.roll(0);
		assertThat(lane.showMessage(),containsString("Gutter") );
		assertThat(lane.showMessage(),containsString("No.2"));
		assertThat(lane.showMessage(),containsString("Frame2"));
		
		lane.roll(0);
		assertThat(lane.showMessage(),containsString("Gutter") );
		assertThat(lane.showMessage(),containsString("No.2"));
		assertThat(lane.showMessage(),containsString("Frame2"));
		
		lane.roll(0);
		assertThat(lane.showMessage(),containsString("Gutter") );
		assertThat(lane.showMessage(),containsString("No.1"));
		assertThat(lane.showMessage(),containsString("Frame3"));
	}
	
}
