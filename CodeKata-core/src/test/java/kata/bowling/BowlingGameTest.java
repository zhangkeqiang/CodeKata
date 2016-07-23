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
		assertEquals(0, game.score());
	}

	@Test
	public void firstStrike(){
//		game.roll(1);
//		assertEquals(1, game.score());
	}
}
