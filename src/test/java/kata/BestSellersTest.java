/**
 * 
 */
package kata;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author zhangmike
 *
 */
public class BestSellersTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNewBestSellingList() {
		BestSellingList list = new BestSellingList();
		assertNotNull(list);
		
	}
	
	@Test
	public void testFullBestSellingList() {
		BestSellingList list = new BestSellingList();
		assertNotNull(list);
		assertTrue(list.add());
		
	}

}
