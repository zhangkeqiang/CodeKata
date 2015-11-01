package kata.flowmeter;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class OldFlowMeterTest {
	FlowManager meter;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		meter = new FlowManager();
		meter.setMode(FlowManager.ONEMONTH);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFlowMeter() {
		assertNotNull(meter);
	}
	
	@Test
	public void testcalcFlow1() {		
		assertNotNull(meter);
		DataPlan plan = new DataPlan(1000,30);
		UserFlow userFlow = new UserFlow();
		userFlow.setDataPlan(plan);
		userFlow.setFlow(2015,10,800);
		userFlow.setFlow(2015,11,800);
		userFlow.setFlow(2015,12,800);
		userFlow.setFlow(2016,1,1678);
		int flow = meter.calculateBillingFlow(userFlow,2015,10);
		assertEquals(800, flow);
		assertEquals(800, meter.calculateBillingFlow(userFlow,2015,11));
		assertEquals(800, meter.calculateBillingFlow(userFlow,2015,12));
	}

	@Test
	public void testcalcFlow2() {
		assertNotNull(meter);
		DataPlan plan = new DataPlan(1000,30);
		UserFlow userFlow = new UserFlow();
		userFlow.setDataPlan(plan);
		userFlow.setFlow(2015,10,200);
		userFlow.setFlow(2015,11,200);
		userFlow.setFlow(2015,12,200);
		userFlow.setFlow(2016,1,1678);
		int flow = meter.calculateBillingFlow(userFlow,2015,10);
		assertEquals(200, flow);
		assertEquals(200, meter.calculateBillingFlow(userFlow,2015,11));
		assertEquals(200, meter.calculateBillingFlow(userFlow,2015,12));
	}
	
	@Test
	public void testcalcFlow3() {
		assertNotNull(meter);
		DataPlan plan = new DataPlan(1000,30);
		UserFlow userFlow = new UserFlow();
		userFlow.setDataPlan(plan);
		userFlow.setFlow(2015,10,400);
		userFlow.setFlow(2015,11,400);
		userFlow.setFlow(2015,12,800);
		userFlow.setFlow(2016,1,1678);
		int flow = meter.calculateBillingFlow(userFlow,2015,10);
		assertEquals(400, flow);
		assertEquals(400, meter.calculateBillingFlow(userFlow,2015,11));
		assertEquals(800, meter.calculateBillingFlow(userFlow,2015,12));
	}
	/*	
	@Test
	public void testcalcFlow4() {
		assertNotNull(meter);
		DataPlan plan = new DataPlan(1000,30);
		UserFlow userFlow = new UserFlow();
		userFlow.setDataPlan(plan);
		userFlow.setFlow(2015,10,400);
		userFlow.setFlow(2015,11,400);
		userFlow.setFlow(2015,12,800);
		userFlow.setFlow(2016,1,800);
		int flow = meter.calculateBillingFlow(userFlow,2015,10);
		assertEquals(400, flow);
		assertEquals(0, meter.calculateBillingFlow(userFlow,2015,11));
		assertEquals(0, meter.calculateBillingFlow(userFlow,2015,12));
		assertEquals(0, meter.calculateBillingFlow(userFlow,2016,1));
	}
	
	@Test
	public void testcalcFlow5() {
		assertNotNull(meter);
		DataPlan plan = new DataPlan(1000,30);
		UserFlow userFlow = new UserFlow();
		userFlow.setDataPlan(plan);
		userFlow.setFlow(2015,10,1100);
		userFlow.setFlow(2015,11,1200);
		userFlow.setFlow(2015,12,1200);
		userFlow.setFlow(2016,1,3800);
		int flow = meter.calculateBillingFlow(userFlow,2015,10);
		assertEquals(1100, flow);
		assertEquals(1200, meter.calculateBillingFlow(userFlow,2015,11));
		assertEquals(1200, meter.calculateBillingFlow(userFlow,2015,12));
		assertEquals(3800, meter.calculateBillingFlow(userFlow,2016,1));
	}
	
	@Test
	public void testcalcFlow6() {
		assertNotNull(meter);
		DataPlan plan = new DataPlan(1000,30);
		UserFlow userFlow = new UserFlow();
		userFlow.setDataPlan(plan);
		userFlow.setFlow(2015,10,900);
		userFlow.setFlow(2015,11,1200);
		userFlow.setFlow(2015,12,500);
		userFlow.setFlow(2016,1,1200);
		userFlow.setFlow(2016,2,1200);
		assertEquals(900, meter.calculateBillingFlow(userFlow,2015,10));
		assertEquals(1100, meter.calculateBillingFlow(userFlow,2015,11));
		assertEquals(500, meter.calculateBillingFlow(userFlow,2015,12));
		assertEquals(700, meter.calculateBillingFlow(userFlow,2016,1));
		assertEquals(900, meter.calculateBillingFlow(userFlow,2016,2));
	}
	
	@Test
	public void testcalcFlow7() {
		assertNotNull(meter);
		DataPlan plan = new DataPlan(1000,30);
		UserFlow userFlow = new UserFlow();
		userFlow.setDataPlan(plan);
		userFlow.setFlow(2015,10,900);
		userFlow.setFlow(2015,11,1200);
		userFlow.setFlow(2015,12,500);
		userFlow.setFlow(2016,1,200);
		userFlow.setFlow(2016,2,1200);
		assertEquals(900, meter.calculateBillingFlow(userFlow,2015,10));
		assertEquals(1100, meter.calculateBillingFlow(userFlow,2015,11));
		assertEquals(500, meter.calculateBillingFlow(userFlow,2015,12));
		assertEquals(0, meter.calculateBillingFlow(userFlow,2016,1));
		assertEquals(200, meter.calculateBillingFlow(userFlow,2016,2));
	}*/
}
