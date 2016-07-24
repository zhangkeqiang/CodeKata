package kata.bowling2;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class RollTest {
	BowlingRoll roll;
	
	@Before
	public final void newRollTest() {
		roll = new BowlingRoll(0);
		assertNotNull(roll);
	}

	@Test
	public final void roll_1ball_1(){
		roll.setPins(1);
		assertEquals(1, roll.getPins());
	}
	
	@Test
	public final void roll_1ball_2(){
		roll.setPins(2);
		assertEquals(2, roll.getPins());
	}
	
	
}
