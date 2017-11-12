package kata;

import junit.framework.TestCase;

public class BowlingTest extends TestCase {
	private BowlingGame2 g;
	public void testHello()
	{
		assertTrue("alwaystrue",true);
	}
	protected void setUp() throws Exception {
		super.setUp();
		g = new BowlingGame2();
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testGutterGame() throws Exception {
	    rollMany(20, 0);
	    assertEquals(0, g.score());
	}
	
	private void rollMany(int n, int pins) {
		for (int i = 0; i < n; i++) {
	      g.roll(pins);
	    }
	}
	
	public void testAllOnes() throws Exception {
		rollMany(20,1);
	    assertEquals(20, g.score());
	  }

	public void testOneSpare() throws Exception {
		rollSpare();
	    g.roll(3);
	    rollMany(17,0);
	    assertEquals(String.valueOf(g.score()),16,g.score());
	}
	
	private void rollSpare() {
	    g.roll(5);
	    g.roll(5);
	  }

	public void testOneStrike() throws Exception {
	    g.roll(10); // strike
	    g.roll(3);
	    g.roll(4);
	    rollMany(16, 0);
	    assertEquals(24, g.score());
	    assertEquals("same score", g.score2(), g.score());
	}
	
	public void testPerfectGame() throws Exception {
	    rollMany(12,10);
	    assertEquals(300, g.score());
	}
	
	public void testScoreAfterOnePoorFrame() throws Exception {
		rollMany(2,4);
		assertEquals(8, g.scoreinprogress());
		assertEquals(8, g.getFrameScore(1));
		//assertEquals(BowlingGame.FIRSTROLLINFRAME, g.getFrameState());
	}

	
	public void testAfterOneSpare() throws Exception {
		//rollSpare();
		g.roll(9);
		g.roll(1); 
		assertEquals(10, g.scoreinprogress());
		assertEquals(10, g.getFrameScore(1));
		assertEquals('/', g.getFrameStatus(1));
		g.roll(6);
		assertEquals(16, g.getFrameScore(1));
		g.roll(2);
		assertEquals(16, g.getFrameScore(1));
	}
	
	public void testAfterOneStrike() throws Exception {
	    g.roll(10); // strike
	    assertEquals(10, g.scoreinprogress());
	    assertEquals(10, g.getFrameScore(1));
	    assertEquals('X', g.getFrameStatus(1));
	    g.roll(3);
	    assertEquals(3, g.getFrameScore(2));
	    assertEquals(13, g.getFrameScore(1));
	    assertEquals('.', g.getFrameStatus(2));
	    g.roll(4);
	    assertEquals(24, g.scoreinprogress());
	    assertEquals(17, g.getFrameScore(1));
	    assertEquals('^', g.getFrameStatus(2));
	    
	}
	
	public void testAfterTwoStrike() throws Exception {
	    g.roll(10); // strike
	    assertEquals(10, g.getFrameScore(1));
	    g.roll(10);
	    assertEquals(10, g.getFrameScore(2));
	    assertEquals(20, g.getFrameScore(1));
	    g.roll(4);
	    assertEquals(24, g.getFrameScore(1));
	    assertEquals(14, g.getFrameScore(2));
	    g.roll(6);
	    assertEquals(24, g.getFrameScore(1));
	    assertEquals(20, g.getFrameScore(2));
	    g.roll(5);
	    assertEquals(24, g.getFrameScore(1));
	    assertEquals(20, g.getFrameScore(2));
	    assertEquals(15, g.getFrameScore(3));
	    assertEquals(5, g.getFrameScore(4));
	    //System.out.println( "Hello World!" );
	}
}
