package kata.primefactor;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**@ClassName: PrimeFactorTest
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Administrator 
 * @date 2016年8月4日 上午8:26:53 
 * @Copyright © 2016上海通善互联网金融信息服务有限公司
 */
public class PrimeFactorTest {

	/**@method setUp(这里用一句话描述这个方法的作用)
	 * @return void
	 * @author Administrator
	 * @date 2016年8月4日 上午8:26:53
	*/
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public final void test1() {
		List<Integer> listFactors = PrimeFactorAnalyzer.analyze(1);
		assertEquals(1, listFactors.get(0).intValue());
	}
	
	@Test
	public final void test4() {
		List<Integer> listFactors = PrimeFactorAnalyzer.analyze(4);
		assertEquals(generateList(2,2), listFactors);
	}


	@Test
	public final void test5() {
		List<Integer> listFactors = PrimeFactorAnalyzer.analyze(5);
		assertEquals(generateList(5), listFactors);
	}

	@Test
	public final void test6() {
		List<Integer> listFactors = PrimeFactorAnalyzer.analyze(6);
		assertEquals(generateList(2,3), listFactors);
	}
	private List<Integer> generateList(int... factors) {
		List<Integer> list = new ArrayList<Integer>();
		for(int f: factors){
			list.add(f);
		}
		return list;
	}
	
	

}
