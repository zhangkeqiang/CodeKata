package com.agilejerry.bowling.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**@ClassName: FrameTest
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Administrator 
 * @date 2016年7月25日 下午11:20:28 
 * @Copyright © 2016上海通善互联网金融信息服务有限公司
 */
public class FrameTest {

	/**@method setUp(这里用一句话描述这个方法的作用)
	 * @return void
	 * @author Administrator
	 * @date 2016年7月25日 下午11:20:28
	*/
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public final void newFrame() {
		BowlingFrame frame = new BowlingFrame();
	}

}
