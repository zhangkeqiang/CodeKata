package kata.flowmeter;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TwoMonthMeterTest {
	private TwoMonthMeter meter = new TwoMonthMeter();
	DataPlan plan = new DataPlan(1000,30);
	UserFlow userFlow = new UserFlow();
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		userFlow.setDataPlan(plan);
		userFlow.setFlow(2015,10,900);
		userFlow.setFlow(2015,11,1200);
		userFlow.setFlow(2015,12,500);
		userFlow.setFlow(2016,1,200);
		userFlow.setFlow(2016,2,1200);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCalculateBillingFlow() {
		assertEquals(900, meter.calculateBillingFlow(userFlow, 2015, 10));
		assertEquals(1100, meter.calculateBillingFlow(userFlow,2015,11));
		assertEquals(500, meter.calculateBillingFlow(userFlow,2015,12));
		assertEquals(0, meter.calculateBillingFlow(userFlow,2016,1));
		assertEquals(200, meter.calculateBillingFlow(userFlow,2016,2));
	}

}
