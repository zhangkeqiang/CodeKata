package kata.bowling;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**@ClassName: BowlingGameTest
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Administrator 
 * @date 2016年7月23日 下午5:53:35 
 * @Copyright © 2016上海通善互联网金融信息服务有限公司
 */
public class BowlingGameTest {
	Game game;
	/**@method setUp(这里用一句话描述这个方法的作用)
	 * @return void
	 * @author Administrator
	 * @date 2016年7月23日 下午5:53:35
	*/
	@Before
	public void setUp() throws Exception {
		game = new Game();		
	}

	/**@method tearDown(这里用一句话描述这个方法的作用)
	 * @return void
	 * @author Administrator
	 * @date 2016年7月23日 下午5:53:35
	*/
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void newGame() {		
		assertEquals(BowlingTerm.BLANK, game.score());
	}

	@Test
	public void firstStrike_Blow(){
		game.roll(1);
		assertEquals(BowlingTerm.BLANK, game.score());
		Frame firstFrame = game.getFrame(1);
		assertEquals(1, firstFrame.getFirstScore());
		assertEquals(BowlingTerm.BLANK, firstFrame.getSecondScore());
		assertEquals(BowlingTerm.BLANK, firstFrame.getTotalScore());
		game.roll(1);
		assertEquals(1, firstFrame.getFirstScore());
		assertEquals(1, firstFrame.getSecondScore());
		assertEquals(2, firstFrame.getTotalScore());
	}
	
	@Test
	public void firstStrike_Strike(){
		game.roll(10);
		assertEquals(BowlingTerm.BLANK, game.score());
		Frame firstFrame = game.getFrame(1);
		assertEquals(10, firstFrame.getFirstScore());
		assertEquals(BowlingTerm.BLANK, firstFrame.getSecondScore());
		assertEquals(BowlingTerm.X_STRIKE, firstFrame.getTotalScore());
		
	}
	
	@Test
	public void firstStrike_Sqare(){
		game.roll(0);
		assertEquals(BowlingTerm.BLANK, game.score());
		Frame firstFrame = game.getFrame(1);
		assertEquals(0, firstFrame.getFirstScore());
		assertEquals(BowlingTerm.BLANK, firstFrame.getSecondScore());
		assertEquals(BowlingTerm.BLANK, firstFrame.getTotalScore());
		game.roll(10);
		assertEquals(0, firstFrame.getFirstScore());
		assertEquals(10, firstFrame.getSecondScore());
		assertEquals(BowlingTerm.SLASH_SQARE, firstFrame.getTotalScore());
	}
	
	@Test 
	public void rallall_1_20_times(){
		for(int i=0;i<20;i++){
			game.roll(1);
		}
		
		Frame frame = game.getFrame(5);
		assertEquals(1, frame.getFirstScore());
		assertEquals(1, frame.getSecondScore());
		assertEquals(2, frame.getTotalScore());
		
		assertEquals(20, game.score());
	}
}
