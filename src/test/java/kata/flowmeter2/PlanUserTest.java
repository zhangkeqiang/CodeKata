package kata.flowmeter2;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kata.flowmeter.DataPlan;

public class PlanUserTest {
	PlanUser user;
	DataPlan plan;
	@Before
	public void setUp() throws Exception {
		user = new PlanUser();
		plan = new DataPlan(1000,30);
		user.setPlan(plan);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInit() {
		assertNotNull(user);
	}
	
	@Test
	public void testUserSetPlan() {		
		assertEquals(user.getPlan(),plan);
	}
	
	@Test
	public void testUserSetFlow() {		
		Integer I = user.setFlow(2015,10,2000);
		assertNull(I);
		I = user.setFlow(2015,11,12000);
		assertNull(I);
		int f201510 = user.getRealFlow(2015,10);
		assertEquals(2000,f201510);
		int f201511 = user.getRealFlow(2015,11);
		assertEquals(12000,f201511);
	}
	
	@Test
	public void testUserCalculateFlow() {
		user.setFlow(2015,9,400);
		user.setFlow(2015,10,400);
		user.setFlow(2015,11,400);
		int f201509Bill = user.calculateBillingFlow(2015,9);
		assertEquals(400, f201509Bill);
		assertEquals(400, user.calculateBillingFlow(2015,10));
		assertEquals(400, user.calculateBillingFlow(2015,11));
	}

}
