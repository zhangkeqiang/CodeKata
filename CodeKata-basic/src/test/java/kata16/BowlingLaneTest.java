package kata16;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class BowlingLaneTest {
	protected Logger logger = LogManager.getLogger();
	@Test
	public final void testRoll() {
		BowlingLane lane = new BowlingLane();
		lane.roll(10);
		assertTrue(lane.showMessage().indexOf("not started")>=0);
		assertTrue(lane.startMatch(1, 1));
		logger.info(lane.showMessage());
		lane.roll(10);
		logger.info(lane.showMessage());
		assertTrue(lane.showMessage().indexOf("Strike!")>=0);
	}

}
