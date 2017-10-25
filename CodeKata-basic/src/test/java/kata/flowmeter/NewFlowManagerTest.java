package kata.flowmeter;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class NewFlowManagerTest {
	FlowManager manager;
	UserFlow userFlow;
	DataPlan plan;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		 manager = new FlowManager();
		 userFlow = new UserFlow();
		 plan = new DataPlan(1000,30);
		 userFlow.setDataPlan(plan);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFlowmanagerInit() {
		assertNotNull(manager);		
		assertNotNull(userFlow);
		assertNotNull(plan);
	}
	
	@Test
	public void testcalcFlow1() {
		userFlow.setFlow(2015,10,800);
		userFlow.setFlow(2015,11,800);
		userFlow.setFlow(2015,12,800);
		userFlow.setFlow(2016,1,1678);
		int flow = manager.calculateBillingFlow(userFlow,2015,10);
		assertEquals(800, flow);
		assertEquals(600, manager.calculateBillingFlow(userFlow,2015,11));
		assertEquals(400, manager.calculateBillingFlow(userFlow,2015,12));
	}

	@Test
	public void testcalcFlow2() {
		userFlow.setDataPlan(plan);
		userFlow.setFlow(2015,10,200);
		userFlow.setFlow(2015,11,200);
		userFlow.setFlow(2015,12,200);
		userFlow.setFlow(2016,1,1678);
		int flow = manager.calculateBillingFlow(userFlow,2015,10);
		assertEquals(200, flow);
		assertEquals(0, manager.calculateBillingFlow(userFlow,2015,11));
		assertEquals(0, manager.calculateBillingFlow(userFlow,2015,12));
	}
	
	@Test
	public void testcalcFlow3() {
		userFlow.setFlow(2015,10,400);
		userFlow.setFlow(2015,11,400);
		userFlow.setFlow(2015,12,800);
		userFlow.setFlow(2016,1,1678);
		int flow = manager.calculateBillingFlow(userFlow,2015,10);
		assertEquals(400, flow);
		assertEquals(0, manager.calculateBillingFlow(userFlow,2015,11));
		assertEquals(0, manager.calculateBillingFlow(userFlow,2015,12));
	}
	
	@Test
	public void testcalcFlow4() {
		userFlow.setFlow(2015,10,400);
		userFlow.setFlow(2015,11,400);
		userFlow.setFlow(2015,12,800);
		userFlow.setFlow(2016,1,800);
		int flow = manager.calculateBillingFlow(userFlow,2015,10);
		assertEquals(400, flow);
		assertEquals(0, manager.calculateBillingFlow(userFlow,2015,11));
		assertEquals(0, manager.calculateBillingFlow(userFlow,2015,12));
		assertEquals(0, manager.calculateBillingFlow(userFlow,2016,1));
	}
	
	@Test
	public void testcalcFlow5() {
		userFlow.setFlow(2015,10,1100);
		userFlow.setFlow(2015,11,1200);
		userFlow.setFlow(2015,12,1200);
		userFlow.setFlow(2016,1,3800);
		int flow = manager.calculateBillingFlow(userFlow,2015,10);
		assertEquals(1100, flow);
		assertEquals(1200, manager.calculateBillingFlow(userFlow,2015,11));
		assertEquals(1200, manager.calculateBillingFlow(userFlow,2015,12));
		assertEquals(3800, manager.calculateBillingFlow(userFlow,2016,1));
	}
	
	@Test
	public void testcalcFlow6() {
		userFlow.setFlow(2015,10,900);
		userFlow.setFlow(2015,11,1200);
		userFlow.setFlow(2015,12,500);
		userFlow.setFlow(2016,1,1200);
		userFlow.setFlow(2016,2,1200);
		assertEquals(900, manager.calculateBillingFlow(userFlow,2015,10));
		assertEquals(1100, manager.calculateBillingFlow(userFlow,2015,11));
		assertEquals(500, manager.calculateBillingFlow(userFlow,2015,12));
		assertEquals(700, manager.calculateBillingFlow(userFlow,2016,1));
		assertEquals(900, manager.calculateBillingFlow(userFlow,2016,2));
	}
	
	@Test
	public void testcalcFlow7() {
		userFlow.setFlow(2015,10,900);
		userFlow.setFlow(2015,11,1200);
		userFlow.setFlow(2015,12,500);
		userFlow.setFlow(2016,1,200);
		userFlow.setFlow(2016,2,1200);
		assertEquals(900, manager.calculateBillingFlow(userFlow,2015,10));
		assertEquals(1100, manager.calculateBillingFlow(userFlow,2015,11));
		assertEquals(500, manager.calculateBillingFlow(userFlow,2015,12));
		assertEquals(0, manager.calculateBillingFlow(userFlow,2016,1));
		assertEquals(200, manager.calculateBillingFlow(userFlow,2016,2));
	}
	
	@Test
	public void testcalcFlow8() {
		userFlow.setFlow(2015,10,900);
		userFlow.setFlow(2015,11,1200);
		userFlow.setFlow(2015,12,500);
		userFlow.setFlow(2016,1,200);
		userFlow.setFlow(2016,2,1200);
		assertEquals(900, manager.calculateBillingFlow(userFlow,2015,10));
		assertEquals(1100, manager.calculateBillingFlow(userFlow,2015,11));
		assertEquals(500, manager.calculateBillingFlow(userFlow,2015,12));
		assertEquals(0, manager.calculateBillingFlow(userFlow,2016,1));
		assertEquals(200, manager.calculateBillingFlow(userFlow,2016,2));
	}
}
