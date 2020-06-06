package kata.flowmeter;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class OldFlowMeterTest {
	FlowManager manager;
	DataPlan plan;
	UserFlow userFlow;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		manager = new FlowManager();
		manager.setMode(FlowManager.ONEMONTH);
		plan = new DataPlan(1000,30);
		userFlow = new UserFlow();
		userFlow.setDataPlan(plan);
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testFlowMeter() {
		assertNotNull(manager);
	}
	
	@Test
	public void testcalcFlow1() {			
		userFlow.setFlow(2015,10,800);
		userFlow.setFlow(2015,11,800);
		userFlow.setFlow(2015,12,800);
		userFlow.setFlow(2016,1,1678);
		int flow = manager.calculateBillingFlow(userFlow,2015,10);
		assertEquals(800, flow);
		assertEquals(800, manager.calculateBillingFlow(userFlow,2015,11));
		assertEquals(800, manager.calculateBillingFlow(userFlow,2015,12));
	}

	@Test
	public void testcalcFlow2() {
		userFlow.setFlow(2015,10,200);
		userFlow.setFlow(2015,11,200);
		userFlow.setFlow(2015,12,200);
		userFlow.setFlow(2016,1,1678);
		int flow = manager.calculateBillingFlow(userFlow,2015,10);
		assertEquals(200, flow);
		assertEquals(200, manager.calculateBillingFlow(userFlow,2015,11));
		assertEquals(200, manager.calculateBillingFlow(userFlow,2015,12));
	}
	
	@Test
	public void testcalcFlow3() {
		userFlow.setFlow(2015,10,400);
		userFlow.setFlow(2015,11,400);
		userFlow.setFlow(2015,12,800);
		userFlow.setFlow(2016,1,1678);
		int flow = manager.calculateBillingFlow(userFlow,2015,10);
		assertEquals(400, flow);
		assertEquals(400, manager.calculateBillingFlow(userFlow,2015,11));
		assertEquals(800, manager.calculateBillingFlow(userFlow,2015,12));
	}

}
