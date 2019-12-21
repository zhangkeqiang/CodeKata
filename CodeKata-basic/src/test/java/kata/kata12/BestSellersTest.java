/**
 * 
 */
package kata.kata12;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import kata.kata12.BestSellingManager;
import kata.kata12.SaleItem;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangmike
 *
 */
public class BestSellersTest {

	Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

	// private ArrayList<SaleItem> list;
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
		// list = new BestSellingList<SaleItem>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testNewBestSellingList() {

		// assertNotNull(list);

	}

	@Test
	public void testFullBestSellingList() {
		// SaleItem item = new SaleItem("Apple Mac");
		// assertNotNull(list);
		// assertTrue(list.add(item));

	}

	@Test
	// @Ignore
	public void testGenerateBestSellingList() {
		long sleeptime = 1000;
		BestSellingManager manager = new BestSellingManager();
		manager.start();
		List<SaleItem> bestList = manager.getBestList();
		assertNotNull(bestList);
		manager.changeType(BestSellingManager.HOURLYUPDATE);
		try {
			BestSellingManager.sleep(sleeptime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for (SaleItem item : bestList) {
			logger.info(item.getName());
		}
		assertNotNull(bestList);

		manager.changeType(BestSellingManager.DAILYUPDATE);
		try {
			BestSellingManager.sleep(sleeptime);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// bestList = manager.getBestList();
		if (bestList.isEmpty())
			return;
		try {
			for (SaleItem item : bestList) {
				logger.info(item.getName());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		assertNotNull(bestList);

		manager.changeType(BestSellingManager.REALTIMEUPDATE);
		// manager.generateBestList();
		try {
			BestSellingManager.sleep(sleeptime);
			// bestList = manager.getBestList();
			for (SaleItem item : bestList) {
				logger.info(item.getName());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		assertNotNull(bestList);

	}

}
